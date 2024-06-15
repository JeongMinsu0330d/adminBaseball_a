package com.example.adminbaseball.admin_servlet;

import com.example.adminbaseball.common.DataConverter;
import com.example.adminbaseball.common.Section;
import com.example.adminbaseball.common.Ticket;
import com.example.adminbaseball.common.Value;
import com.example.adminbaseball.admin_dao.StadiumDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "AddStadiumServlet", value = "/stadium/create")
public class AddStadiumServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("../admin/StadiumReg.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message ="";
        Section[] sections = DataConverter.convertJsonToModel(request.getParameter("rgData[]"));
        Ticket[] tickets = DataConverter.convertJsonToModelToTicket(request.getParameter("rgPriceData[]"));

        StadiumDAO stadiumService = new StadiumDAO();

//        경기장 생성
        String strStadiumName = request.getParameter("stadium_name");
        String pathSeatImage = request.getParameter("stadium_seat_image");

        try {
            if(!stadiumService.startTransaction()){ // 트랜잭션 실행
                throw new SQLException("StartTransaction : Failed");
            }
            // 경기장 생성 및 경기장 번호 반환
            int nStadiumNo = stadiumService.createStadium(strStadiumName, pathSeatImage);

            // 경기 좌석 생성 (stadium_no, section_type, section_no, seat_col,seat_row, admin_no:0)
            for (Section section : sections) {
                List<Value> values = section.getValues();
                if (values.isEmpty()) {
                    continue; // 값이 없으면 다음 섹션으로 넘어감
                }

                for (Value value : values) {
//                    경기장 좌석 정보 DB 저장.
                    stadiumService.setStadiumSeatInfo(nStadiumNo,section,value);
                }
                System.out.println("success_seat_info");
            }
//        티켓 가격 생성. stadium_no, section_type 조회 > if(isAge) 권종 3개 생성 가격의 각 100%, 80%, 60%
            for(Ticket ticket: tickets){
                int nWeekPrice = ticket.getPrice1();
                int nWeekEndPrice = ticket.getPrice2();
                if(ticket.isAgeType()){
                    System.out.println(ticket.isAgeType());
                    String[] rgAgeType = {"a","b","c"};
                    for(int i = 0; i < 3; i++){
                        if(rgAgeType[i].equals("b")){
                            nWeekPrice = ticket.getPrice1() - 1000;
                            nWeekEndPrice = ticket.getPrice2() - 1000;
                        }else if(rgAgeType[i].equals("c")){
                            nWeekPrice = ticket.getPrice1() - 2000;
                            nWeekEndPrice = ticket.getPrice2() - 2000;
                        }
                        stadiumService.setStadiumTicket(nStadiumNo, ticket.getSection_type(), rgAgeType[i], nWeekPrice, nWeekEndPrice);
                    }
                }else{
                    stadiumService.setStadiumTicket(nStadiumNo, ticket.getSection_type(), "a", nWeekPrice, nWeekEndPrice);
                }
            }

            stadiumService.commit();
            stadiumService.close();
            message = "구단 생성 완료 되었습니다.";

        }catch(SQLException e){
            try {
                stadiumService.rollback();
                stadiumService.close();
                e.printStackTrace();
            }catch(Exception e2){
                e2.printStackTrace();
            }finally {
                message = "구단 생성 실패 하였습니다.";
            }
        }finally{
            request.setAttribute("message",message);
            request.getRequestDispatcher("/_layout/PopUpMessagePage.jsp").forward(request,response);
        }
    }
}

package com.example.adminbaseball.servlet;

import com.example.adminbaseball.DAO.ReservationDAO;
import com.example.adminbaseball.models.ReservationVo;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ReservationServlet", value = "/reservation")
public class ReservationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("menu","예매 관리");
        ReservationDAO reservationDAO = new ReservationDAO();
        // 예매 정보
        ReservationVo reservationVo = new ReservationVo();

        String message ="";
        try{
            List<ReservationVo> reservationVoList = reservationDAO.getAllReservation();
            request.setAttribute("reservationVoList", reservationVoList);

            request.getRequestDispatcher("admin/Reservation.jsp").forward(request,response);

        }catch(SQLException e){
            message = "Reservation 정보 조회 실패";
            request.setAttribute("message", message);
            System.out.println("ReservationServlet[GET] : 예매정보 조회 실패 !(SQLException)");
            e.printStackTrace();
            request.getRequestDispatcher("../_layout/PopUpMessagePage.jsp").forward(request,response);
        }catch(Exception e){

            e.printStackTrace();
        }
        // 예매 정보 가져오기
       



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

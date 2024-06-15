package com.example.adminbaseball.admin_servlet;

import com.example.adminbaseball.common.PriceListModel;
import com.example.adminbaseball.admin_model.StadiumPriceInfo;
import com.example.adminbaseball.admin_dao.PriceInfoDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "StadiumPriceInfoServlet", value = "/stadium/priceinfo")
public class StadiumPriceInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int nStadiumNo = Integer.parseInt(request.getParameter("stadiumno"));
            PriceInfoDAO priceInfoService = new PriceInfoDAO();
            System.out.println("ll: " + nStadiumNo);
            List<StadiumPriceInfo> priceInfos = priceInfoService.getAllPriceInfoToStadiumNo(nStadiumNo);
            Map<String, PriceListModel> rgStadiumPriceBoard = new LinkedHashMap<>();

            //test
            Map<String,int[]> rgPrice = new LinkedHashMap<>(); // Key : 연령타입 / value : {p1,p2}
            Map<String, Map<String,List<Integer>>> test = new LinkedHashMap<>(); // key : 좌석 등급 value : 가격표

//String,
            for (StadiumPriceInfo priceInfo : priceInfos) {
                if (!rgStadiumPriceBoard.containsKey(priceInfo.getStrSectionType())) {
                    rgStadiumPriceBoard.put(priceInfo.getStrSectionType(), new PriceListModel(priceInfo.getSection_no_list()));
                }
                // 구간 타입 구분

                // 연령 타입 구분

                // 주중 타입 구분

                // 가격 추가

                if(rgPrice != null || rgPrice.isEmpty()){
                    rgPrice.put(priceInfo.getStrAgeType(),new int[2]);
                }

                if(priceInfo.getStrDateType().equals("a")){
                    //주중
                    int[] price = rgPrice.get(priceInfo.getStrAgeType());
                    price[0] = priceInfo.getnTicketPrice();
                    rgPrice.put(priceInfo.getStrAgeType(),price);
                }else{
                    int[] price = rgPrice.get(priceInfo.getStrAgeType());
                    price[1] = priceInfo.getnTicketPrice();
                    rgPrice.put(priceInfo.getStrAgeType(),price);
                }

            }
            System.out.println("al : "+rgPrice.keySet()+ " ||" + rgPrice.get("a")[0]+","+rgPrice.get("a")[1]);

            request.getRequestDispatcher("../admin/PriceInfo.jsp").forward(request, response);
        }catch(Exception e){
            e.printStackTrace();
            request.setAttribute("errorMessage", e);
            request.getRequestDispatcher("../ErrorPage.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}


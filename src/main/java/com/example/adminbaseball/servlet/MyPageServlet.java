package com.example.adminbaseball.servlet;

import com.example.adminbaseball.common.JDBCconnection;
import com.example.adminbaseball.model.Member;
import com.example.adminbaseball.model.MileageChangeList;
import com.example.adminbaseball.model.Reservation;
import com.example.adminbaseball.service.MemberService;
import com.example.adminbaseball.service.MileageService2;
import com.example.adminbaseball.service.ReservationService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebServlet(name = "MyPageServlet", value = "/web/my/*")
public class MyPageServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        if (session == null){
            response.sendRedirect(request.getContextPath()+"/web");
        }
        int userNo = (int)session.getAttribute("user_no");

        String requestURI = request.getRequestURI();
        int lastSlashIndex = requestURI.lastIndexOf('/');

        String lastUri = requestURI.substring(lastSlashIndex + 1);
        System.out.println(lastUri);

        String path = "/baseball/mypage/";
        int mileage = 0;

        if(lastUri.equals("mileage")){

            MileageService2 mileageService = new MileageService2();
            mileage = mileageService.fnGetMyMileage(userNo);
            List<MileageChangeList> mileageChangeList = mileageService.fnGetMileageChangeList(userNo);


            request.setAttribute("mileageChangeList", mileageChangeList);
            request.setAttribute("mileage", mileage);

            path += "Mileage.jsp";

        }else if(lastUri.equals("reservation")){

            ReservationService reservationService = new ReservationService();
            List<Reservation> reservations = reservationService.fnGetReservationList(userNo);



            request.setAttribute("reservations", reservations);

            path += "Reservation.jsp";
        }else if(lastUri.equals("point")){
            path += "Point.jsp";
        }else if(lastUri.equals("coupon")){
            path += "Coupon.jsp";
        }else {
            path += "Reservation.jsp";
        }



        request.getRequestDispatcher(path).forward(request, response);

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    }
}
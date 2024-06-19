package com.example.adminbaseball.servlet;

import com.example.adminbaseball.model.Member;
import com.example.adminbaseball.service.MemberService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
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

        String path = "/web/mypage/";

        if(lastUri.equals("mileage")){
            path += "Mileage.jsp";
        }else if(lastUri.equals("reservation")){
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
package com.example.adminbaseball.servlet;

import com.example.adminbaseball.model.Member;
import com.example.adminbaseball.service.MemberService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ReservationServlet", value = "/web/reservation")
public class ReservationServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("예매하기");

        request.getRequestDispatcher("/baseball/Reservation.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        request.getRequestDispatcher("/baseball/Reservation3.jsp").forward(request, response);
    }


}
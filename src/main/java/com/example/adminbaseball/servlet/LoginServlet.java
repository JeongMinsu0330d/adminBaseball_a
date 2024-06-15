package com.example.adminbaseball.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/web/member/login")
public class LoginServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("login");
        request.getRequestDispatcher("/web/member/Login.jsp").forward(request, response);
    }

    public void destroy() {
    }
}
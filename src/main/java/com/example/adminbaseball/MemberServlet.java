package com.example.adminbaseball;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "member", value = "/member")
public class MemberServlet extends HttpServlet {

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("menu","회원 관리");

        request.getRequestDispatcher("admin/Member.jsp").forward(request,response);
    }

    public void destroy() {
    }
}
package com.example.adminbaseball.servlet;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "FindMemberServlet", value = "/web/member/idInquiry")
public class IdInquiryServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String doParam = request.getParameter("do");
        String path = "";

        if(doParam.equals("id")) {
            path = "/baseball/member/Find.jsp";
        }else{
            path = "/baseball/member/idInquiry.html";
        }



    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


}

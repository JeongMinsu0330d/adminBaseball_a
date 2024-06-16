package com.example.adminbaseball.servlet;

import com.example.adminbaseball.model.Member;
import com.example.adminbaseball.service.MemberService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.Map;

@WebServlet(name = "LoginServlet", value = "/web/member/login")
public class LoginServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        if(request.getParameter("logout") != null) {
             // 로그 아웃
             HttpSession session = request.getSession();
             session.invalidate();

             request.setAttribute("message", "로그아웃에 성공하였습니다.");
             request.getRequestDispatcher("/web/index.jsp").forward(request, response);
         }else{
             request.getRequestDispatcher("/web/member/Login.jsp").forward(request, response);
         }

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        MemberService memberService = new MemberService();


        Map<String, String[]> paramMap = request.getParameterMap();
         for (Map.Entry<String, String[]> entry : paramMap.entrySet()) {
            String paramName = entry.getKey();
            String[] paramValues = entry.getValue();

            for (String paramValue : paramValues) {
                if (paramValue == null || paramValue.trim().isEmpty()) {
                    // 처리 로직 (예: 에러 메시지 반환)
                    System.out.println(paramName + " parameter is missing or empty.");
                }else{
                    System.out.println(paramName + " parameter is: " + paramValue);
                }
            }
         }

        String userId = (String)request.getParameter("userId");
        String password = (String)request.getParameter("password");

        Member member = new Member();
        member.setUserEmail(userId);
        member.setPassword(password);


        member = memberService.fnLogin(member);

        HttpSession session = request.getSession();
        session.setAttribute("user_no",member.getUserNo());
        session.setAttribute("user_id",member.getUserEmail());

        request.setAttribute("message","로그인에 성공하였습니다.");
        request.getRequestDispatcher("/web/index.jsp").forward(request,response);

    }
}
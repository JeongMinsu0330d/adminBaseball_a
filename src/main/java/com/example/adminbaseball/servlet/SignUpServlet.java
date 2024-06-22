package com.example.adminbaseball.servlet;

import com.example.adminbaseball.model.Member;
import com.example.adminbaseball.service.MemberService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

@WebServlet(name = "SignUpServlet", value = "/web/member/signup")
public class SignUpServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("here");

        request.getRequestDispatcher("/baseball/member/SignUp.jsp").forward(request, response);
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String message ="";
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
                // 추가적인 형식 검증 로직 적용 가능
            }
        }

        String serviceAgree = request.getParameter("isCheckedService");
        String privateAgree = request.getParameter("isCheckedPrivate");
        String userId = request.getParameter("userId");
        String password = request.getParameter("password");
        String userName = request.getParameter("userName");
        String userAddress = request.getParameter("userAddress");
        String userBirth= request.getParameter("userBirth");
        try{
        if(!serviceAgree.equals("on") || !privateAgree.equals("on")){
            throw new Exception();
        }
        MemberService memberService = new MemberService();
        Member member = new Member(userId,password,userName,userAddress,userBirth,serviceAgree,privateAgree);


            memberService.fnInsertMember(member);

            message = "회원 가입에 성공 하였습니다.";
            request.setAttribute("message", message);
            request.getRequestDispatcher("/web").forward(request, response);
        }catch(Exception e){
            message = "회원 가입에 실패 하였습니다.";
            request.setAttribute("message", message);
            response.sendRedirect("/baseball/member/SignUp.jsp");

        }
    }


}

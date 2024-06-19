package com.example.adminbaseball.servlet;

import com.example.adminbaseball.common.JDBCconnection;
import com.example.adminbaseball.model.Member;
import com.example.adminbaseball.service.MemberService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        int mileage = 0;

        if(lastUri.equals("mileage")){
            String qryMileage = "SELECT mileage FROM mileage_list WHERE user_no = ? AND mileage_type = 'm'";
            try{
                JDBCconnection jdbc = new JDBCconnection();
                Connection conn = jdbc.CBaseBallMaster;

                PreparedStatement ps = conn.prepareStatement(qryMileage);
                ps.setInt(1, userNo);

                ResultSet rs = ps.executeQuery();

                if(rs.next()){
                     mileage = rs.getInt("mileage");
                }

            }catch(SQLException e){
                e.printStackTrace();
            }
            request.setAttribute("mileage", mileage);
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
package com.example.adminbaseball.admin_servlet;

import com.example.adminbaseball.StadiumVo;
import com.example.adminbaseball.admin_dao.StadiumDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "StadiumServlet", value = "/stadium")
public class StadiumServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("menu","경기장 관리");
        StadiumDAO sDao = new StadiumDAO();
        try{
            List<StadiumVo> stadiums = sDao.getAllStadium();
            request.setAttribute("stadiums", stadiums);

            request.getRequestDispatcher("admin/Stadium.jsp").forward(request,response);
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}

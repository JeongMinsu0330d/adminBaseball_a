package com.example.adminbaseball.admin_servlet;

import com.example.adminbaseball.admin_dao.TeamDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "DeleteTeamServlet", value = "/team/delete")
public class DeleteTeamServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("../admin/TeamDelete.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TeamDAO teamService = new TeamDAO();
        int nTeamNo = Integer.parseInt(request.getParameter("team_no"));

        try{
            teamService.deleteTeam(nTeamNo);

            String message= "구단 삭제 완료 되었습니다.";

            request.setAttribute("message",message);
            request.getRequestDispatcher("../_layout/PopUpMessagePage.jsp").forward(request,response);
        }catch(Exception e ){
            String message= "구단 삭제 실패.";
            request.setAttribute("message",message);
            request.getRequestDispatcher("../_layout/PopUpMessagePage.jsp").forward(request,response);

        }


    }
}

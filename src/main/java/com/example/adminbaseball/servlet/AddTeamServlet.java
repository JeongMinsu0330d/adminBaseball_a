package com.example.adminbaseball.servlet;

import com.example.adminbaseball.TeamVo;
import com.example.adminbaseball.service.TeamService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AddTeamServlet", value = "/team/create")
public class AddTeamServlet extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("../admin/TeamReg.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();

        String teamName = request.getParameter("team_name");
        String teamImage = request.getParameter("team_image");
        String[] stadium = request.getParameter("stadium").split("-");
        int stadiumNo = Integer.parseInt(stadium[0]);
        String strStadiumName = stadium[1];

        TeamService teamService = new TeamService();
        TeamVo team = new TeamVo();

        team.setStrTeamName(teamName);
        team.setStrTeamImage(teamImage);
        team.setnStadiumNo(stadiumNo);
        team.setStrStadiumName(strStadiumName);

        String message;

        try{
            teamService.setTeam(team);
            message = "구단 생성 완료 되었습니다.";
            request.setAttribute("message",message);
            request.getRequestDispatcher("../_layout/PopUpMessagePage.jsp").forward(request,response);

        }catch(Exception e){
            message = "구단 생성 실패 하였습니다.";
            request.setAttribute("message",message);
            request.getRequestDispatcher("../_layout/PopUpMessagePage.jsp").forward(request,response);
        }

    }
}

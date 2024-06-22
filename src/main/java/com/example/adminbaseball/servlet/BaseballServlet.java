package com.example.adminbaseball.servlet;

import com.example.adminbaseball.TeamVo;
import com.example.adminbaseball.admin_model.GameVo;
import com.example.adminbaseball.service.BaseballService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "BaseballServlet", value = "/web")
public class BaseballServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String context = request.getContextPath();
        // 경기 내역, 팀내역
        BaseballService baseballService = new BaseballService();

        List<TeamVo> teams = baseballService.fnGetTeamList();
        List<GameVo> games = baseballService.fnGetGameList();

        request.setAttribute("games", games);
        request.setAttribute("teams", teams);
        request.getRequestDispatcher("/baseball/index.jsp").forward(request, response);
    }

}

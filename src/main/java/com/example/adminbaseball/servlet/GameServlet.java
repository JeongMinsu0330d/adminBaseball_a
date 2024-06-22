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

@WebServlet(name = "GameServlet", value = "/web/game")
public class GameServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int gameCode = request.getParameter("gameCode") != null ? Integer.parseInt(request.getParameter("gameCode")) : -1;
//        teamNo=2&playDate=2024-06-26
        BaseballService baseballService = new BaseballService();
        if(gameCode == -1){
            int teamNo = request.getParameter("teamNo") != null ? Integer.parseInt(request.getParameter("teamNo")): -1;
            String playDate = request.getParameter("playDate") != null ? request.getParameter("playDate") : null;

            List<GameVo> games =  baseballService.fnGetGameOneByTeamNoAndPlayDate(teamNo,playDate);

            request.setAttribute("games",games);
            request.getRequestDispatcher("/baseball/Detail.jsp").forward(request, response);

        }else{
            List<GameVo> games =  baseballService.fnGetGameOneByGameCode(gameCode);
            request.setAttribute("games",games);
            request.getRequestDispatcher("/baseball/Detail.jsp").forward(request, response);

        }

    }

}

package com.example.adminbaseball.servlet;

import com.example.adminbaseball.models.GameVo;
import com.example.adminbaseball.DAO.GameDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "game", value = "/game")
public class GameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GameDAO gameService = new GameDAO();
        try{
            request.setAttribute("menu","경기 관리");

            List<GameVo> games = gameService.getAllGameList();
            request.setAttribute("games",games);

            request.getRequestDispatcher("admin/Game.jsp").forward(request,response);
        }catch(Exception e){
            e.printStackTrace();
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {




    }
}

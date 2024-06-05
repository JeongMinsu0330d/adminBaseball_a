package com.example.adminbaseball.servlet;

import com.example.adminbaseball.StadiumVo;
import com.example.adminbaseball.TeamVo;
import com.example.adminbaseball.models.GameVo;
import com.example.adminbaseball.DAO.GameDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet(name = "AddGameServlet", value = "/game/create")
public class AddGameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("../admin/GameReg.jsp").forward(request,response);
    }

//    home_team, away_team, game_date, stadium
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message;
        try{


            /**
             * ds
 *  그 날 경기 중인 팀이 존재 하는가 체크
 *  그 날 경기장을 이미 사용 하고 있는가 체크
 *  동일 한 팀이 경기를 하고 있는가
 *
  */
// 정합성 검사 & 변수 세팅
            if(request.getParameter("home_team") == null || request.getParameter("home_team") == ""){
                throw new NullPointerException("입력 정보가 정확하지 않습니다. 다시 입력 해주세요!");
            }
            if(request.getParameter("away_team") == null || request.getParameter("away_team") == ""){
                throw new NullPointerException("입력 정보가 정확하지 않습니다. 다시 입력 해주세요!");
            }
            if(request.getParameter("game_date") == null || request.getParameter("game_date") == ""){
                throw new NullPointerException("입력 정보가 정확하지 않습니다. 다시 입력 해주세요!");
            }
            if(request.getParameter("stadium") == null || request.getParameter("stadium") == ""){
                throw new NullPointerException("입력 정보가 정확하지 않습니다. 다시 입력 해주세요!");
            }

            int homeTeamNo = Integer.parseInt(request.getParameter("home_team"));
            int awayTeamNo = Integer.parseInt(request.getParameter("away_team"));
            String gameDate = request.getParameter("game_date");
            int stadiumNo = Integer.parseInt(request.getParameter("stadium"));

//  경기 생성 가능 여부 체크
            if(homeTeamNo == awayTeamNo){
                throw new Exception("팀 정보가 정확 하지 않습니다. 다시 확인해 주세요 !");
            }
            List<GameVo> games = new ArrayList<>();
            GameDAO gameService = new GameDAO();

            games = gameService.getAllGameListByDateAndTeam(gameDate,homeTeamNo,awayTeamNo);

            if(games.get(1) != null){
                
            }



//  팀정보 가져오기
            TeamVo homeTeamInfo = new TeamVo();
            TeamVo awayTeamInfo = new TeamVo();


//  경기장 정보 가져오기
            StadiumVo stadiumInfo = new StadiumVo();

//  경기 생성 하기


            request.getRequestDispatcher("../admin/Empty.jsp").forward(request,response);

        }catch(NullPointerException nullPointerException){
            nullPointerException.printStackTrace();
            message = nullPointerException.getMessage();
            request.setAttribute("message",message);
            request.getRequestDispatcher("/_layout/PopUpMessagePage.jsp").forward(request,response);

        }catch(Exception e){
            e.printStackTrace();
            message = e.getMessage();
            request.setAttribute("message",message);
            request.getRequestDispatcher("/_layout/PopUpMessagePage.jsp").forward(request,response);
        }



    }
}

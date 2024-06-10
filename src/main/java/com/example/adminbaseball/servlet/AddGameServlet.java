package com.example.adminbaseball.servlet;

import com.example.adminbaseball.DAO.StadiumDAO;
import com.example.adminbaseball.DAO.TeamDAO;
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
            String gameDate = request.getParameter("game_date")+" 12:00:00";
            int stadiumNo = Integer.parseInt(request.getParameter("stadium"));

            System.out.println(gameDate);

//  경기 생성 가능 여부 체크
            if(homeTeamNo == awayTeamNo){
                throw new Exception("팀 정보가 정확 하지 않습니다. 다시 확인해 주세요 !");
            }
            List<GameVo> games = new ArrayList<>();
            GameVo game = new GameVo();

            GameDAO gameService = new GameDAO();
            TeamDAO teamService = new TeamDAO();
            StadiumDAO stadiumService = new StadiumDAO();

            games = gameService.getAllGameListByDateAndTeam(gameDate,homeTeamNo,awayTeamNo);

            if(games.size() > 0){
                throw new Exception("경기일정을 변경해주세요!");
            }

//  팀정보 가져오기
            TeamVo homeTeamInfo = new TeamVo();
            TeamVo awayTeamInfo = new TeamVo();

           homeTeamInfo =  teamService.getTeamNameByTeamNo(homeTeamNo);
           awayTeamInfo =  teamService.getTeamNameByTeamNo(awayTeamNo);

//  경기장 정보 가져오기
            StadiumVo stadiumInfo = stadiumService.getStadiumInfoByStadiumNo(stadiumNo);


            //            play_date,stadium_no,stadium_name, home_team_no, home_team_name, away_team_no, away_team_name
            game.setDtPlayDate(gameDate);
            game.setnStadiumNo(stadiumInfo.getnStadiumNo());
            game.setStrStadiumName(stadiumInfo.getStrStadiumName());
            game.setnHomeTeamNo(homeTeamInfo.getnTeamNo());
            game.setStrHomeTeamName(homeTeamInfo.getStrTeamName());
            game.setnAwayTeamNo(awayTeamInfo.getnTeamNo());
            game.setStrAwayTeamName(awayTeamInfo.getStrTeamName());

            System.out.println(game.getnHomeTeamNo());
            System.out.println(game.getnAwayTeamNo());
            System.out.println(game.getnStadiumNo());
            System.out.println(game.getDtRegDate());


//  경기 생성 하기
            boolean isCreateGame = gameService.setGameList(game);
            if(!isCreateGame){
                System.out.println("error");
            }

            message = "경기 생성 완료 되었습니다.";
            request.setAttribute("message",message);
            request.getRequestDispatcher("../_layout/PopUpMessagePage.jsp").forward(request,response);
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

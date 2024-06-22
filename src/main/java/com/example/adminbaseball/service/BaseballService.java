package com.example.adminbaseball.service;

import com.example.adminbaseball.TeamVo;
import com.example.adminbaseball.admin_model.GameVo;
import com.example.adminbaseball.common.DateFunction;
import com.example.adminbaseball.common.JDBCconnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BaseballService {

    public List<TeamVo> fnGetTeamList(){
        System.out.println("메인페이지 구단 정보 조회");
        JDBCconnection jdbc = new JDBCconnection();
//        초기 준비 세팅
        Connection CBaseballDbMaster = jdbc.CBaseBallMaster;
        PreparedStatement pstmtTeam = null;
        ResultSet rsTeam = null;

        String qrySelectTeam = "SELECT team_name,team_no FROM code_baseball_team_list;";
        try{
            List<TeamVo> teams = new ArrayList<>();
            pstmtTeam = CBaseballDbMaster.prepareStatement(qrySelectTeam);
            rsTeam = pstmtTeam.executeQuery();

            while(rsTeam.next()){
                TeamVo team = new TeamVo();
                team.setStrTeamName(rsTeam.getString("team_name"));
                team.setnTeamNo(rsTeam.getInt("team_no"));

                teams.add(team);
            }
            return teams;
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }

    }
    public List<GameVo> fnGetGameList(){
        System.out.println("메인페이지 구단 정보 조회");
        JDBCconnection jdbc = new JDBCconnection();
//        초기 준비 세팅
        Connection CBaseballDbMaster = jdbc.CBaseBallMaster;
        PreparedStatement pstmtGame = null;
        ResultSet rsGame = null;

        String qrySelectTeam = "SELECT a.seq as game_code,a.home_team_name as home_team, a.away_team_name as away_team,a.play_date as play_date, b.team_image as home_team_image, c.team_image as away_team_image  " +
                               "  FROM baseball_game_list as a" +
                               "  LEFT JOIN code_baseball_team_list as b on(a.home_team_no= b.team_no)" +
                               "  LEFT JOIN code_baseball_team_list as c on(a.away_team_no= c.team_no)" +
                               "WHERE DATE(a.play_date) BETWEEN ? AND ? ORDER BY a.play_date ASC, a.seq ASC;";
        try{
            DateFunction dateFunction = new DateFunction();
            String[] date = dateFunction.fnGetWeekly();

            List<GameVo> games = new ArrayList<>();
            pstmtGame = CBaseballDbMaster.prepareStatement(qrySelectTeam);
            pstmtGame.setString(1,date[0]);
            pstmtGame.setString(2,date[1]);

            rsGame = pstmtGame.executeQuery();

            while(rsGame.next()){
                GameVo game = new GameVo();
                game.setSeq(rsGame.getInt("game_code"));
                game.setStrHomeTeamName(rsGame.getString("home_team"));
                game.setStrAwayTeamName(rsGame.getString("away_team"));
                game.setDtPlayDate(rsGame.getString("play_date"));
                game.setHomeTeamImage(rsGame.getString("home_team_image"));
                game.setAwayTeamImage(rsGame.getString("away_team_image"));
                games.add(game);
            }

            return games;
        }catch(SQLException e){

            e.printStackTrace();
            return null;
        }

    }

    // 경기명(홈팀,상대팀), 일정, 걍ㄱ;징, 이미지, 게임 코드
    public List<GameVo> fnGetGameOneByGameCode(int gameCode){


        String qrySelectGame ="SELECT a.seq as game_code,a.home_team_name as home_team, a.away_team_name as away_team,a.play_date as play_date, b.team_image as home_team_image, c.team_image as away_team_image  " +
                              "  FROM baseball_game_list as a" +
                              "  LEFT JOIN code_baseball_team_list as b on(a.home_team_no= b.team_no)" +
                              "  LEFT JOIN code_baseball_team_list as c on(a.away_team_no= c.team_no)" +
                              " WHERE a.game_code = ? limit 1";

        System.out.println("선택 경기 정보 조회");

        JDBCconnection jdbc = new JDBCconnection();
//        초기 준비 세팅
        Connection CBaseballDbMaster = jdbc.CBaseBallMaster;
        PreparedStatement pstmtGame = null;
        ResultSet rsGame = null;

        try{
            List<GameVo> games = new ArrayList<>();
            pstmtGame = CBaseballDbMaster.prepareStatement(qrySelectGame);
            pstmtGame.setInt(1,gameCode);

            rsGame = pstmtGame.executeQuery();

            if(rsGame.next()){
                GameVo game = new GameVo();
                game.setSeq(rsGame.getInt("game_code"));
                game.setStrHomeTeamName(rsGame.getString("home_team"));
                game.setStrAwayTeamName(rsGame.getString("away_team"));
                game.setDtPlayDate(rsGame.getString("play_date"));
                game.setHomeTeamImage(rsGame.getString("home_team_image"));
                game.setAwayTeamImage(rsGame.getString("away_team_image"));
                games.add(game);
            }
            return games;
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public List<GameVo> fnGetGameOneByTeamNoAndPlayDate(int teamNo, String playDate){
       System.out.println("메인페이지 구단 정보 조회");
        JDBCconnection jdbc = new JDBCconnection();
//        초기 준비 세팅
        Connection CBaseballDbMaster = jdbc.CBaseBallMaster;
        PreparedStatement pstmtGame = null;
        ResultSet rsGame = null;

        String qrySelectTeam = "SELECT a.seq as game_code,a.home_team_name as home_team, a.away_team_name as away_team,a.play_date as play_date, b.team_image as home_team_image, c.team_image as away_team_image  " +
                               "  FROM baseball_game_list as a" +
                               "  LEFT JOIN code_baseball_team_list as b on(a.home_team_no= b.team_no)" +
                               "  LEFT JOIN code_baseball_team_list as c on(a.away_team_no= c.team_no)" +
                               "WHERE DATE(a.play_date) = ? AND (a.away_team_no = ? OR a.away_team_no = ?) ORDER BY a.play_date ASC, a.seq ASC;";
        try{
            DateFunction dateFunction = new DateFunction();
            String[] date = dateFunction.fnGetWeekly();
            List<GameVo> games = new ArrayList<>();
            pstmtGame = CBaseballDbMaster.prepareStatement(qrySelectTeam);

            pstmtGame.setString(1,playDate);
            pstmtGame.setInt(2,teamNo);
            pstmtGame.setInt(3,teamNo);

            rsGame = pstmtGame.executeQuery();

            while(rsGame.next()){
                GameVo game = new GameVo();
                game.setSeq(rsGame.getInt("game_code"));
                game.setStrHomeTeamName(rsGame.getString("home_team"));
                game.setStrAwayTeamName(rsGame.getString("away_team"));
                game.setDtPlayDate(rsGame.getString("play_date"));
                game.setHomeTeamImage(rsGame.getString("home_team_image"));
                game.setAwayTeamImage(rsGame.getString("away_team_image"));
                games.add(game);
            }

            return games;
        }catch(SQLException e){

            e.printStackTrace();
            return null;
        }
    }


}

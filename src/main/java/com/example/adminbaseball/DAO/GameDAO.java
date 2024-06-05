package com.example.adminbaseball.DAO;

import com.example.adminbaseball.common.JDBCconnection;
import com.example.adminbaseball.models.GameVo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GameDAO extends JDBCconnection {

    public GameDAO(){

    }

// 게임 정보 가져 오기
    public List<GameVo> getAllGameList() throws SQLException {
        List<GameVo> games = new ArrayList<>();
        String qrySelectGame = "select seq, play_date, stadium_no, stadium_name, home_team_no, home_team_name, away_team_no, away_team_name, reg_date From baseball_game_list";

        psmt = CBaseBallMaster.prepareStatement(qrySelectGame);
        rs = psmt.executeQuery();

        while(rs.next()){
            GameVo game = new GameVo();
            game.setSeq(rs.getInt("seq"));
            game.setDtPlayDate(rs.getString("play_date"));
            game.setnHomeTeamNo(rs.getInt("home_team_no"));
            game.setnAwayTeamNo(rs.getInt("away_team_no"));
            game.setStrHomeTeamName(rs.getString("home_team_name"));
            game.setStrAwayTeamName(rs.getString("away_team_name"));
            game.setnStadiumNo(rs.getInt("stadium_no"));
            game.setStrStadiumName(rs.getString("stadium_name"));
            game.setDtRegDate(rs.getString("reg_date"));

            games.add(game);
        }

        return games;
    }

// 기간별 게임 정보 불러오기
    public List<GameVo> getAllGameListByDateAndTeam(String gameDate, int homeTeam, int awayTeam) throws SQLException{
        List<GameVo> games = new ArrayList<>();

        String query = "SELECT * FROM baseball_game_list WHERE play_date = ";
        query += "'" + gameDate + " 12:00:00' " ;
        query += "AND home_team_no IN ( "+ homeTeam +"," +  awayTeam  + ") OR away_team_name IN ( "+ homeTeam +"," +  awayTeam  + ");";

        psmt = CBaseBallMaster.prepareStatement(query);
        rs = psmt.executeQuery();

        while(rs.next()){
            GameVo game = new GameVo();
            game.setSeq(rs.getInt("seq"));
            game.setDtPlayDate(rs.getString("play_date"));
            game.setnHomeTeamNo(rs.getInt("home_team_no"));
            game.setnAwayTeamNo(rs.getInt("away_team_no"));
            game.setStrHomeTeamName(rs.getString("home_team_name"));
            game.setStrAwayTeamName(rs.getString("away_team_name"));
            game.setnStadiumNo(rs.getInt("stadium_no"));
            game.setStrStadiumName(rs.getString("stadium_name"));
            game.setDtRegDate(rs.getString("reg_date"));

            games.add(game);
        }

        return games;
    }



}

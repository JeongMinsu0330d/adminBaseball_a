package com.example.adminbaseball.admin_dao;

import com.example.adminbaseball.common.JDBCconnection;
import com.example.adminbaseball.admin_model.GameVo;

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
        query += "'" + gameDate + "'" ;
        query += "AND home_team_no IN ( "+ homeTeam +"," +  awayTeam  + ") OR away_team_name IN ( "+ homeTeam +"," +  awayTeam  + ");";

        psmt = CBaseBallMaster.prepareStatement(query);
        System.out.println(query);
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
    public boolean setGameList(GameVo game) throws SQLException{
        String qryInsertGame = "INSERT INTO baseball_game_list (play_date,stadium_no,stadium_name, home_team_no, home_team_name, away_team_no, away_team_name, caution_contents)" +
                " VALUES (?,?,?,?,?,?,?,?)";
        psmt = CBaseBallMaster.prepareStatement(qryInsertGame);
        psmt.setString(1,game.getDtPlayDate());
        psmt.setInt(2,game.getnStadiumNo());
        psmt.setString(3,game.getStrStadiumName());
        psmt.setInt(4,game.getnHomeTeamNo());
        psmt.setString(5,game.getStrHomeTeamName());
        psmt.setInt(6,game.getnAwayTeamNo());
        psmt.setString(7,game.getStrAwayTeamName());
        psmt.setString(8,"");

        psmt.executeUpdate();


        return true;
    }

}

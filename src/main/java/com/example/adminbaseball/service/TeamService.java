package com.example.adminbaseball.service;

import com.example.adminbaseball.TeamVo;
import com.example.adminbaseball.common.JDBCconnection;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeamService extends JDBCconnection {

    public TeamService(){

    }

    public List<TeamVo> getAllTeam() throws SQLException {
        List<TeamVo> teams = new ArrayList<>();

        String qrySelectTeam="SELECT team_no, team_name, stadium_no, reg_date, team_image FROM code_baseball_team_list";

        psmt = CBaseBallMaster.prepareStatement(qrySelectTeam);
        rs = psmt.executeQuery();

        while(rs.next()){
            int nTeamNo = rs.getInt("team_no");
            String strTeamName = rs.getString("team_name");
            int nStadiumNo = rs.getInt("stadium_no");
            String dtRegDate = rs.getString("reg_date");
            String strTeamImage = rs.getString("team_image");
            TeamVo team = new TeamVo(nTeamNo,strTeamName,nStadiumNo,dtRegDate,strTeamImage);

            teams.add(team);
        }

        return teams;
    }

    public boolean setTeam(TeamVo teamVo) throws SQLException{

        String qryInsertTeam = "INSERT INTO code_baseball_team_list (team_name,team_image, stadium_no, stadium_name, admin_no, reg_date) VALUES (?,?,?,?,'0',NOW()" +
                ")";

        psmt = CBaseBallMaster.prepareStatement(qryInsertTeam);
        psmt.setString(1,teamVo.getStrTeamName());
        psmt.setString(2, teamVo.getStrTeamImage());
        psmt.setInt(3,teamVo.getnStadiumNo());
        psmt.setString(4,teamVo.getStrStadiumName());
        psmt.executeUpdate();

        return true;
    }

    public boolean deleteTeam(int nTeamNo){

        String qryDeleteTeam = "";


        return true;
    }


}
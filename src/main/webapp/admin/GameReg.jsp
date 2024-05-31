<%@ page import="com.example.adminbaseball.StadiumVo" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.adminbaseball.service.StadiumService" %>
<%@ page import="com.example.adminbaseball.TeamVo" %>
<%@ page import="com.example.adminbaseball.service.TeamService" %><%--
  Created by IntelliJ IDEA.
  User: jeongminsu
  Date: 4/14/24
  Time: 1:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    StadiumService sDao = new StadiumService();
    TeamService tDao = new TeamService();

    List<StadiumVo> stadiums = sDao.getAllStadium();
    List<TeamVo> teams = tDao.getAllTeam();

%>
<html>
<head>
    <title>게임등록</title>
</head>
<body>
<h1>경기 생성</h1>
<form action="" method="post" id="form_add">
    <table border="1">
        <tr>
            <th>이름</th>
            <th>
                <select id="homeTeam" name="home_team" onchange="selectHome(this)">
                    <%
                        for(int cnt=0; cnt<teams.size();cnt++){
                    %>
                    <option value="<%= teams.get(cnt).getnTeamNo()%>"><%= teams.get(cnt).getStrTeamName()%></option>
                    <%
                        }
                    %>
                </select>
                vs
                <select id="awayTeam" name="away_team">
                    <%
                        for(int cnt=0; cnt<teams.size();cnt++){

                    %>
                    <option value="<%= teams.get(cnt).getnTeamNo()%>"><%= teams.get(cnt).getStrTeamName()%></option>
                    <%
                        }
                    %>
                </select>
            </th>
        </tr>
        <tr>
            <th>경기날짜</th>
            <th><input type="date" name="game_date"></th>
        </tr>
        <tr>
            <th>경기장</th>
            <th>
                <select id="stadium" name="stadium">
                    <%
                        for(int cnt=0; cnt<stadiums.size();cnt++){
                    %>
                    <option value="<%= stadiums.get(cnt).getnStadiumNo()%>"><%= stadiums.get(cnt).getStrStadiumName()%></option>
                    <%
                        }
                    %>
                </select>
            </th>
        </tr>
    </table>
    <input type="submit" value="등록">
</form>

<script>
    const selectHome = (e)  =>{
        const selectHomeTeam = e.value;


    }

    const createGameInfo = {};

</script>

</body>
</html>

<%@ page import="com.example.adminbaseball.StadiumVo" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.adminbaseball.DAO.TeamDAO" %>
<%@ page import="com.example.adminbaseball.TeamVo" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
  TeamDAO teamService = new TeamDAO();
  List<TeamVo> teams = teamService.getAllTeam();

%>
<html>
<head>
  <style>
    .container{
      display:flex;
      justify-content: flex-end;
      width:1600px;

    }
    /* 스타일 설정 */
    #sidebar {
      position: fixed;
      top: 0;
      left: 0;
      width: 200px;
      height: 100%;
      background-color: #f0f0f0;
      padding: 20px;
    }
    button{
      border : 1px solid black;
    }
    .menu {
      list-style-type: none;
      padding: 0;
    }

    .menu li {
      margin-bottom: 10px;
    }

    .menu li a {
      text-decoration: none;
    }

    .menu li.active a {
      font-weight: bold;
    }

    .section{
      width:1300px;
    }

    .modal{
      position:absolute;
      display:none;

      justify-content: center;
      top:0;
      left:0;

      width:100%;
      height:100%;

      background-color: rgba(0,0,0,0.4);
    }

  </style>
</head>
<body>
<div class="container">


  <div id="sidebar">
    <ul class="menu">
      <li><a href="./member">회원 관리</a></li>
      <li><a href="./game">게임 관리</a></li>
      <li><a href="./stadium">경기장 관리</a></li>
      <li><a href="./team">구단 관리</a></li>
      <li><a href="./mileage">마일리지/포인트 관리</a></li>
      <li><a href="./reservation">예매 관리</a></li>
      <li><a href="./coupon">쿠폰 관리</a></li>
    </ul>
  </div>

  <div id="content" class="section">
    <%@ include file="../_layout/Header.jsp"%>
    <!-- 메뉴 클릭에 따른 내용은 이곳에 표시됩니다. -->
    <div>
      <h2>구단 정보</h2>
      <button onclick="addTeam()"> 구단 등록 </button>
    </div>

    <table border="1" width="100%">
      <tr>
        <th>구단 번호</th>
        <th>등록 날짜</th>
        <th>구단 명</th>
        <th>엠블러</th>
        <th>삭제</th>
      </tr>
      <%
        for(int seq = 0; seq < teams.size(); seq ++){
          TeamVo team = teams.get(seq);
      %>

        <tr>
          <td><%= team.getnTeamNo()%></td>
          <td><%= team.getDtRegDate()%></td>
          <td><%= team.getStrTeamName()%></td>
          <td><%= team.getStrTeamImage()%></td>
          <td><button onclick="delete_team(<%= team.getnTeamNo()%>)">삭제</button></td>
        </tr>
      <%
        }
      %>


    </table>
  </div>

</div>
</div>

<script>
  function addTeam(){
    window.open("${pageContext.request.contextPath}/team/create","_blank","width=1200,height=800");
  }
  function delete_team(teamNo){
    window.open("${pageContext.request.contextPath}/team/delete?team_no="+teamNo,"_blank","width=1200,height=800");
  }
</script>
</body>
</html>
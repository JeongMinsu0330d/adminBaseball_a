<%@ page import="java.util.List" %>
<%@ page import="com.example.adminbaseball.admin_model.GameVo" %><%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2024-06-22
  Time: 오후 6:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<%
    List<GameVo> games = (List<GameVo>) request.getAttribute("games");
%>

<html>
<head>
    <style>
        .container{
            width:80%;
            max-width: 1550px;
            min-width: 800px;
            margin:30px auto;
            box-sizing: border-box;
        }

        .game_list_wrap{
            display:flex;
            align-items: center;
            padding: 0 20px;
            width:100%;
            height: 200px;
            border: 1px solid black;
            margin-bottom: 30px;
        }
        .image_wrap{
            width: 210px;
            height:150px;
            border: 1px solid black;
            border-radius: 10px;
        }
        .btnReservation{
            margin-top:10px;
            width:120px;
            text-align: center;
            padding:4px;
            border : 1px solid black;
        }
    </style>
    <script>
        function fnReservation(gameCode){
            let path = "<%=request.getContextPath()%>/web/Reservation.jsp?gameCode="+gameCode;
            window.open(path,"_blank","width=800, height=600")

        }
    </script>

    <title>경기예매</title>
</head>
<body>
    <%@include file="/baseball/_layout/Header.jsp"%>

    <div class="container">

        <%
            if(games == null){
        %>
            <span>경기정보</span>
                <div class="game_list_wrap">
                    <span>경기 정보가 존재 하지 않습니다.</span>
                </div>
            <span>등급 좌석 정보</span>
                <div class="stadium_info">
                    <span>경기 정보가 존재 하지 않습니다.</span>
                </div>
        <%
            }else {
                for (GameVo game : games) {
        %>
        <span>경기정보</span>
        <form action="<%=request.getContextPath()%>/web/reservation" method="GET">
            <div class="game_list_wrap">
                <div class="image_wrap">
                    <image src="<%= game.getHomeTeamImage()%>"></image>
                    <image src="<%= game.getAwayTeamImage()%>"></image>
                </div>
                <div class="gameInfo">
                    <span> 경기명 :  </span> <%= game.getStrHomeTeamName()%> VS <%= game.getStrAwayTeamName()%>
                    <br>
                    <span> 일정 :  </span> <%= game.getDtPlayDate()%>
                    <br>
                    <span> 경기장 :  </span> <%= game.getStrStadiumName() %>
                    <br>
                    <div class="btnReservation" onclick="fnReservation(<%=game.getSeq()%>)">예매하기</div>
                </div>
            </div>
        <span>등급 좌석 정보</span>
            <div class="stadium_info">

            </div>
        </form>
        <%
                }
            }
        %>
        <div>



        </div>

    </div>
</body>
</html>

<%@ page import="java.util.List" %>
<%@ page import="com.example.adminbaseball.models.GameVo" %>
<%@ page import="com.example.adminbaseball.StadiumVo" %>
<%@ page import="com.example.adminbaseball.service.StadiumService" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    List<GameVo> games = (List<GameVo>) request.getAttribute("games");
    StadiumService stadiumService = new StadiumService();
    List<StadiumVo> stadiums = stadiumService.getAllStadium();
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
            border:1px solid black;
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
        <div class="searchBar">
<%--            <form action="" method="GET">--%>

<%--                <input type="date" name="sDate">--%>
<%--                <input type="date" name="eDate">--%>

<%--                <input type="number" name="playNo">--%>
<%--                <select name="stadiumNo" id="">--%>
<%--                    <%--%>
<%--                        for(int cnt=0;cnt<stadiums.size();cnt++){--%>
<%--                            StadiumVo stadium = stadiums.get(cnt);--%>
<%--                    %>--%>
<%--                    <option value="<%= stadiums.get(cnt).getnStadiumNo()%>"><%= stadiums.get(cnt).getStrStadiumName()%></option>--%>
<%--                    <%--%>
<%--                        }--%>
<%--                    %>--%>
<%--                </select>--%>
<%--                <input type="submit" value="검색">--%>
<%--            </form>--%>
        </div>
        <div>
            <button onclick="addGame()">게임 생성</button>
        </div>
        <table border="1" width="100%">
            <thead>
            <tr>
                <th>게임번호</th>
                <th>경기장 명</th>
                <th>경기 일정</th>
                <th>홈 팀</th>
                <th>어웨이 팀</th>
                <th>등록일자</th>
            </tr>
            </thead>
            <tbody>
            <%
                for(int i = 0; i < games.size(); i++){
                    GameVo game = games.get(i);
            %>

            <tr>
                <td> <%= game.getSeq()%></td>
                <td> <%= game.getStrStadiumName()%></td>
                <td> <%= game.getDtPlayDate()%></td>
                <td> <%= game.getStrHomeTeamName()%></td>
                <td> <%= game.getStrHomeTeamName()%></td>
                <td> <%= game.getDtRegDate()%></td>
            </tr>
            <%
                }
            %>
            </tbody>
        </table>


    </div>

</div>
<script>
    function addGame(){
        window.open("${pageContext.request.contextPath}/game/create","_blank","width=1200,height=800");
    }

    function searchBox(){

    }
</script>

</body>
</html>
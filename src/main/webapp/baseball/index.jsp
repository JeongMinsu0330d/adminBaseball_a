<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.adminbaseball.TeamVo" %>
<%@ page import="com.example.adminbaseball.admin_model.GameVo" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
    List<TeamVo> teams = (List<TeamVo>)request.getAttribute("teams");
    List<GameVo> games = (List<GameVo>)request.getAttribute("games");


%>
<!DOCTYPE html>
<html>
<head>
    <title>메인페이지</title>
    <style>
        .container{
            width:80%;
            max-width: 1550px;
            min-width: 800px;
            margin:0 auto;
            box-sizing: border-box;
        }
        .container > .section_wrap{
            display:flex;
            flex-direction: column;
            width:100%;
            padding:20px 50px;
            max-width: 100%;
            min-width: 750px;
            box-sizing: border-box;
        }

        .section_wrap > .search_wrap > form{
            display:flex;
            flex-direction: row;
            align-items: center;
            justify-content: space-between;
            width:100%;
            height: 100px;
            border: 1px solid black;
            border-radius: 12px;
            margin-top:15px;
            padding: 4px;
        }

        .section_wrap > .search_wrap  .input_search_team {
            width: 320px;
            height: 40px;
        }
        .section_wrap > .search_wrap  .input_search_date {
            width: 320px;
            height: 40px;
        }
        .section_wrap > .search_wrap  .input_search_btn {
            width: 100px;
            height: 40px;

        }

        .section_wrap > .event_wrap{
            width:100%;
            height: 150px;
            margin-top:10px;
        }

        .section_wrap > .daily_game_list_wrap{
            display:flex;
            flex-direction: row;
            justify-content: space-between;
            width:100%;
            height: 300px;
            margin-top:30px;
            border:1px solid black;
            box-sizing: border-box;
        }

          .btn_wrap{
            align-content: center;
            text-align: center;
            font-size: 23px;
            width:60px;
            height: 300px;
        }
          .daily_game_contents{
            display: flex;
            flex-direction: row;
            justify-content: space-around;
            border:1px solid black;
            overflow: hidden;
        }
         .items{
            display:flex;
            flex-direction: column;
            justify-content: space-around;
            align-items: center;
            width: 210px;
            height: 295px;
            border : 1px solid black;
            margin-right: 42px;
        }

         .image_wrap{
            width: 190px;
            height: 190px;
            border: 1px solid black;
            border-radius: 13px;
        }
        .info_wrap{
            font-size:12px;
        }


    </style>
    <script>
        let no = 1;
        let totalContent = 10;
        const fnSlider = (e) =>{
            no += e;
            if(no < 1){
                no = 1;
            }else if(no > totalContent){
                no = totalContent;
            }
        }

    </script>
</head>
<body>
<%
    String message = (String)request.getAttribute("message");
   if (message != null && !message.trim().isEmpty()) {
%>
    <script type="text/javascript">
        alert("<%= message %>");
    </script>
<%
    }
%>

    <div class="container">
        <%@ include file="/baseball/_layout/Header.jsp"%>

        <div class="section_wrap">
            <div class="search_wrap">

                <form action="<%=request.getContextPath()%>/web/game" method="GET">
                    <select name="teamNo" id="team_no"  class="input_search_team">
                        <option value="0">구단을 선택해 주시기 바랍니다.</option>
                        <%
                            for(TeamVo team : teams){
                        %>
                                <option value="<%= team.getnTeamNo()%>"><%=team.getStrTeamName()%></option>
                        <%
                            }
                        %>
                    </select>
                    <input type="date" class="input_search_date" value="" name="playDate" placeholder="경기일정 선택">
                    <input type="submit" class="input_search_btn" value = "검색">
                </form>


            </div>

            <div class="event_wrap">
                <label>이벤트</label>
            </div>
            <h2> 금주 경기 </h2>
            <div class="daily_game_list_wrap">
                <div class="btn_wrap"> < </div>

                <div class="daily_game_contents">

                    <%
                        if(games == null){
                    %>
                        <span>금주 경기가 없습니다.</span>
                    <%
                        }else{
                            for(GameVo game:games){
                    %>
                        <form action="<%=request.getContextPath()%>/web/game" method="GET">
                            <div class="items">
                                <div class="info_wrap">
                                    <%= game.getStrHomeTeamName()%> VS <%= game.getStrAwayTeamName()%>>
                                    <br>
                                    <%=game.getDtPlayDate()%>>
                                    <hr>
                                </div>
                                <div class="image_wrap">
                                <image src="<%= game.getHomeTeamImage()%>"></image>
                                <image src="<%= game.getAwayTeamImage()%>"></image>
                                </div>
                                <div class="btn_res">
                                    <input type="hidden" name="gameCode" value="<%=game.getSeq()%>">
                                    <input type="submit" value="예매하기">
                                </div>
                            </div>
                        </form>
                    <%
                            }
                        }
                    %>
                </div>
                <div class="btn_wrap"> > </div>
            </div>
        </div>

    </div>

</body>
</html>
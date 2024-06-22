<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


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

        .section_wrap > .daily_game_list_wrap > .btn_wrap{
            align-content: center;
            text-align: center;
            font-size: 23px;
            width:60px;
            height: 300px;
        }
        .section_wrap > .daily_game_list_wrap > .daily_game_contents{
            display: flex;
            flex-direction: row;
            justify-content: space-around;
            border:1px solid black;
            overflow: hidden;
        }
        .daily_game_contents > .items{
            display:flex;
            flex-direction: column;
            justify-content: space-around;
            align-items: center;
            width: 210px;
            height: 295px;
            border : 1px solid black;
            margin-right: 42px;
        }

        .daily_game_contents > .items > .image_wrap{
            width: 190px;
            height: 190px;
            border: 1px solid black;
            border-radius: 13px;
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
                <form action="game/detail" method="GET">
                    <input type="text" class="input_search_team" name="team_name" placeholder="구단명을 입력해주세요">
                    <select name="team_no" id="team_no"  class="input_search_team">
                        <option value="0">구단을 선택해 주시기 바랍니다.</option>
<%--                        <%--%>
<%--                            for(Team team : teams){--%>
<%--                        %>--%>
<%--                                <option value="<%= team.getnTeamNo()%>"><%=team.getStrTeamName()%></option>--%>
<%--                        <%--%>
<%--                            }--%>
<%--                        %>--%>
                        <option value="1">기아 타이거즈</option>
                    </select>

                    <input type="date" class="input_search_date" vaule="" name="play_date" placeholder="경기일정 선택">
                    <input type="submit" class="input_search_btn" value = "검색">
                </form>

            </div>

            <div class="event_wrap">
                <label>이벤트</label>
            </div>

            <div class="daily_game_list_wrap">
                <div class="btn_wrap"> < </div>
                <div class="daily_game_contents">
                    <div class="items">
                        <div class="info_wrap">
                            내용 1 | 시간
                        </div>
                        <div class="image_wrap">

                        </div>
                        <div class="btn_res">
                            예매하기
                        </div>
                    </div>

                    <div class="items">
                        <div class="info_wrap">
                            내용 1 | 시간
                        </div>
                        <div class="image_wrap">

                        </div>
                        <div class="btn_res">
                            예매하기
                        </div>
                    </div>

                    <div class="items">
                        <div class="info_wrap">
                            내용 1 | 시간
                        </div>
                        <div class="image_wrap">

                        </div>
                        <div class="btn_res">
                            예매하기
                        </div>
                    </div>

                    <div class="items">
                        <div class="info_wrap">
                            내용 1 | 시간
                        </div>
                        <div class="image_wrap">

                        </div>
                        <div class="btn_res">
                            예매하기
                        </div>
                    </div>

                    <div class="items">
                        <div class="info_wrap">
                            내용 1 | 시간
                        </div>
                        <div class="image_wrap">

                        </div>
                        <div class="btn_res">
                            예매하기
                        </div>
                    </div>

                    <div class="items">
                        <div class="info_wrap">
                            내용 1 | 시간
                        </div>
                        <div class="image_wrap">

                        </div>
                        <div class="btn_res">
                            예매하기
                        </div>
                    </div>

                    <div class="items">
                        <div class="info_wrap">
                            내용 1 | 시간
                        </div>
                        <div class="image_wrap">

                        </div>
                        <div class="btn_res">
                            예매하기
                        </div>
                    </div>

                </div>
                <div class="btn_wrap"> > </div>
            </div>
        </div>

    </div>

</body>
</html>
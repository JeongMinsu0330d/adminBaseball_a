<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
    String contextPath = request.getContextPath();
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
            flex-direction: row;
            width:100%;
            padding:20px 50px;
            max-width: 100%;
            min-width: 750px;
            box-sizing: border-box;
        }



        .section_wrap > .menu_wrap{
            display:flex;
            position: sticky;
            flex-direction: row;
            justify-content: space-between;
            width:300px;
            height:300px;
            margin-top:30px;
            border:1px solid black;
            box-sizing: border-box;
            background-color: #ddd;
        }
        .section_wrap > .content_wrap{
            width:1200px;
            height:800px;
            margin-top:30px;
            border:1px solid black;
            box-sizing: border-box;
            background-color: #fff;
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
        <%@ include file="/web/_layout/Header.jsp"%>
        <div class="section_wrap">
            <div class="menu_wrap">
                <div id="sidebar">
                    <ul class="menu">
                        <li><a href=<%=contextPath%>"/web/mypage/reservation">예매 내역</a></li>
                        <li><a href=<%=contextPath%>"/web/mypage/mileage">마일리지</a></li>
                        <li><a href=<%=contextPath%>"/web/mypage/point">포인트</a></li>
                        <li><a href=<%=contextPath%>"/web/mypage/coupon">할인쿠폰</a></li>
                    </ul>
                </div>
            </div>
            <div class="content_wrap">




            </div>
        </div>

    </div>

</body>
</html>
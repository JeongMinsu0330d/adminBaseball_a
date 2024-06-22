<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2024-06-23
  Time: 오전 1:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    int gameCode = Integer.parseInt(request.getParameter("gameCode"));

%>

<html>
<head>
    <style>
        .container{
            display:flex;
            justify-content: space-around;
            width:100%;
            height:500px;
        }
        .section{
            width:50%;
            height:500px;
            box-sizing: border-box;
            border:2px solid black;
        }
        .image_item{
            width:100%;
            height:95%;
        }

    </style>

    <title>예매하기</title>
</head>
<body>
    <div class="container">
        <div class="section">
            <span>좌석정보</span>
            <image class="image_item" src="<%=0%>"></image>
        </div>
        <div class="section">
            <%

            %>
        </div>
    </div>
</body>
</html>

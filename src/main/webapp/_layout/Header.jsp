<%--
  Created by IntelliJ IDEA.
  User: jeongminsu
  Date: 4/13/24
  Time: 7:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%
    String menuName = (String)request.getAttribute("menu") != null? (String)request.getAttribute("menu"):"예매 관리";

%>

<html>
<head>
    <style>
        .header{
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 0 50px;
            width:100%;
            height:60px;
            border: 1px solid black;
            box-sizing: border-box;
        }

    </style>
</head>
<body>
<div class="header">
    <div>
        <%= menuName %>
    </div>

    <div class="search_wrap">
        회원번호
        <input type="text" value="">
    </div>
</div>
</body>
</html>

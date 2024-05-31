<%--
  Created by IntelliJ IDEA.
  User: jeongminsu
  Date: 4/13/24
  Time: 7:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%
    String menuname = "예매리스트";

%>

<html>
<head>
  <style>
    .header{
        width:700px;
        height:60px;
        border: 1px solid black;
    }

  </style>
</head>
<body>
    <div class="header">
        <div>
            <%= menuname %>
        </div>

        <div class="search_wrap">
            회원번호
            <input type="text" value="">
        </div>
    </div>
</body>
</html>

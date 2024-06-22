<%@ page import="com.example.adminbaseball.common.DateFunction" %><%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2024-06-22
  Time: 오후 7:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        DateFunction dateFunction = new DateFunction();
        String[] date = (String[])dateFunction.fnGetWeekly();
//        dateFunction.fnGetWeekType();
    %>
    <br>
<%= date[0]%>
<%= date[1]%>
</body>
</html>

<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%
    String user_id = (String)session.getAttribute("user_id");

%>
<!DOCTYPE html>
<html>
<head>
    <style>
        a{
            color:inherit;
            text-decoration: none;
        }
        .header_wrap{
            display: flex;
            justify-content: space-between;
            align-items: center;
            width: 100%;
            height: 100px;
            border : 1px solid black;
            padding: 0 20px;
            box-sizing: border-box;
        }
        .header_wrap > .header_wrap_box{
            padding: 10px 15px;
        }
    </style>
</head>
<body>
<div class="header_wrap">
    <div class="header_wrap_box">로고</div>
    <%
        if(user_id == null || user_id == ""){
    %>
<%--    ${pageContext.request.contextPath}/login/login.do --%>
<%--    ${pageContext.request.contextPath}/login/logout.do --%>
    <div class="header_wrap_box">
        <a href="./member/login">로그인</a>
        <span> / </span>
        <a href="./member/signup">회원가입</a>
    </div>
    <%
    }else {
    %>
    <div class="header_wrap_box">
        <%= user_id %> 님
        |
        <a href="#"> 로그 아웃 </a>
    </div>
    <%
        }
    %>
</div>
</body>
</html>
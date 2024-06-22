<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%
    String user_id =  (String)session.getAttribute("user_id");
    String contextPath = request.getContextPath();
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
        <a href="<%=contextPath%>/web/member/login">로그인</a>
        <span> / </span>
        <a href="<%=contextPath%>/web/member/signup">회원가입</a>
    </div>
    <%
    }else {
    %>
    <div class="header_wrap_box">
        <%= user_id %> 님
        |
        <a href="<%=contextPath%>/web/member/login?logout=1"> 로그 아웃 </a>
        |
        <a href="<%=contextPath%>/web/my/mileage"> 마이페이지 </a>

    </div>
    <%
        }
    %>
</div>
</body>
</html>
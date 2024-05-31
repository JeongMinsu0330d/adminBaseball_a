<%--
  Created by IntelliJ IDEA.
  User: jeongminsu
  Date: 4/15/24
  Time: 3:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>구단 삭제</title>
</head>
<body>
<h1> 구단 삭제 </h1>
<%= request.getParameter("team_no")%> 삭제 할까요 ?
<form action=""method="POST">
    <input type="hidden" value="<%= request.getParameter("team_no")%>">
<button onclick="onsubmit(this)"> 확인 </button>
<button onclick="fnClose()"> 취소 </button>
</form>
<script>

    function fnClose(){
        window.close();
    }

</script>

</body>
</html>

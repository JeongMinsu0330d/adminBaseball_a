<%--
  Created by IntelliJ IDEA.
  User: jeongminsu
  Date: 4/15/24
  Time: 3:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<%
  String message = (String)request.getAttribute("message");
%>

<body>
  <%= message %>
  <button onclick="fnClose()"> 닫 기 </button>

<script>
  function fnClose(){
    window.close();
  }

</script>


</body>
</html>

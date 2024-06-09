<%--
  Created by IntelliJ IDEA.
  User: jeongminsu
  Date: 4/19/24
  Time: 5:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>파일업로드</title>
</head>
<style>
    .container{
        margin: 0 auto;
        border:1px solid black;
        width:400px;
        height:200px;
    }

</style>
<body>
    <div class="container">
        <form action="upload.do" method="POST" name="fileForm" enctype="multipart/form-data">
            <label>이미지 첨부</label>
            <input type="file" name="attachedFile">
            <input type="submit" value="확인">
        </form>

        <%
            if (request.getParameter("attachedFile") != null) {
        %>
            <%= request.getParameter("attachedFile")%>
        <%
            }
        %>
    </div>
</body>
</html>

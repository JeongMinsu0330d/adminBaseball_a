<%@ page import="com.example.adminbaseball.service.StadiumService" %>
<%@ page import="com.example.adminbaseball.StadiumVo" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<%
  StadiumService sDao = new StadiumService();
  List<StadiumVo> stadiums = sDao.getAllStadium();

%>

<html>
<head>
    <title>구단 생성</title>
</head>
<body>
  <form action="" method="POST">
    <table border="1" width="100%">
      <tr>
        <td>구단명</td>
        <td><input type="text" name="team_name" value="" placeholder="구단 명"></td>
      </tr>
      <tr>
        <td>구단 엠블럼</td>
        <td><input type="text" name="team_image" value="" placeholder="구단 명"></td>
      </tr>
      <tr>
        <td>홈 경기장</td>
        <td>
          <select id="stadium" name="stadium">
            <%
              for(int cnt=0; cnt<stadiums.size();cnt++){
            %>
            <option value="<%= stadiums.get(cnt).getnStadiumNo() + "-" +stadiums.get(cnt).getStrStadiumName()%>"><%= stadiums.get(cnt).getStrStadiumName()%></option>
            <%
              }
            %>
          </select>
        </td>
      </tr>
    </table>
    <input type="submit" value="생성">
  </form>
</body>
</html>

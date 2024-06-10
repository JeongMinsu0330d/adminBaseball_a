<%@ page import="com.example.adminbaseball.common.JDBCconnection" %>
<%@ page import="com.example.adminbaseball.Member" %>
<%@ page import="com.example.adminbaseball.models.MemberVo" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: jeongminsu
  Date: 4/13/24
  Time: 9:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<%
  Member mDao = new Member();
  List<MemberVo> members = mDao.getReservationList(0);
%>

<html>
<head>
    <title>회원관리</title>
  <style>

    .container{
      display:flex;
      justify-content: flex-end;
      width:1600px;

    }
    /* 스타일 설정 */
    #sidebar {
      position: fixed;
      top: 0;
      left: 0;
      width: 200px;
      height: 100%;
      background-color: #f0f0f0;
      padding: 20px;
    }
    button{
      font-weight: normal;
      border: none; /* 버튼의 테두리 없애기 */
      background-color: transparent; /* 배경색 없애기 */
      cursor: pointer; /* 마우스 커서를 포인터로 변경 */
      padding: 0; /* 내부 패딩 제거 */
    }
    button.active {
      font-weight: bold; /* 선택된 메뉴의 글씨를 굵게 만듦 */
    }
    .menu {
      list-style-type: none;
      padding: 0;
    }

    .menu li {
      margin-bottom: 10px;
    }

    .menu li a {
      text-decoration: none;
    }

    .menu li.active a {
      font-weight: bold;
    }

    .section{
      width:1300px;
    }
  </style>
</head>
<body>

<div class="container">
  <div id="sidebar">
    <ul class="menu">
      <li><a href="./member">회원 관리</a></li>
      <li><a href="./game">게임 관리</a></li>
      <li><a href="./stadium">경기장 관리</a></li>
      <li><a href="./team">구단 관리</a></li>
      <li><a href="./mileage">마일리지/포인트 관리</a></li>
      <li><a href="./reservation">예매 관리</a></li>
      <li><a href="./coupon">쿠폰 관리</a></li>
    </ul>
  </div>

  <div id="content" class="section">
    <%@ include file="../_layout/Header.jsp"%>
    <!-- 메뉴 클릭에 따른 내용은 이곳에 표시됩니다. -->
    <div class="list">
      <table border="1" width="100%">
        <thead>
        <tr>
          <th>회원 번호</th>
          <th>가입 날짜</th>
          <th>회원 아이디</th>
        </tr>
        </thead>
        <tbody>

        <%
          for(int i = 0; i < members.size(); i++){
            MemberVo mem = members.get(i);
        %>
        <tr>
          <td> <%= mem.getnUserNo()%></td>
          <td> <%= mem.getDtRegDate()%></td>
          <td> <%= mem.getStrUserEmail()%></td>
        </tr>
        <%
          }
        %>
        </tbody>
      </table>
      <div class="pagination">
        <a href="#" id="prev">&laquo; 이전</a>
        <% for(int i = 1; i <= 5; i++) { %>
        <a href="<%= i-1%>" class="<%= (i == 1) ? "active" : "" %>"><%= i %></a>
        <% } %>
        <a href="#" id="next">다음 &raquo;</a>
      </div>

    </div>
  </div>

</div>

</body>
</html>

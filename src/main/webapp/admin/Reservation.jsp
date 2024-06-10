<%@ page import="com.example.adminbaseball.DAO.ReservationDAO" %>
<%@ page import="com.example.adminbaseball.models.ReservationVo" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%

  String menu = request.getParameter("menu") != null ? request.getParameter("menu") : "";

  String path = "./admin/Member.jsp";
  if(menu.equals("member")) {
    path = "./admin/Member.jsp";
  }else if(menu.equals("play")) {
    path = "./admin/GameReg.jsp";
  }else{
    path="./admin/Member.jsp";
  }

  List<ReservationVo> reservations = (List<ReservationVo>) request.getAttribute("reservationVoList");




%>
<html>
<head>
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
    <h2>예매 관리 사이트</h2>
     <table border="1" width="100%">
        <thead>
        <%-- seq, 예매 날짜, 구분, 경기명, 거래번호, 결제 수단, 수수료, 할인쿠폰, 포인트, 정가 , 구매가격--%>
        <tr>
          <th>NO</th>
          <th>날짜</th>
          <th>회원번호</th>
          <th>구 분</th>
          <th>경기 명</th>
          <th>예약 번호</th>
          <th>결제수단</th>
          <th>수수료</th>
          <th>할인쿠폰</th>
          <th>포인트</th>
          <th>정 가</th>
          <th>총 결제 금액</th>
        </tr>
        </thead>

<%
    if(reservations != null) { // 예매정보가 존재하지 않는 경우
%>
       <tr>
          <td colspan='11'>회원정보가 존재 하지 않습니다.</td>
      </tr>
<%
    }
%>

<%
      for(int i = 0; i < reservations.size(); i++){
        ReservationVo reservation = reservations.get(i);
%>
<%-- seq, 예매 날짜, 구분, 경기명, 거래번호, 결제 수단, 수수료, 할인쿠폰, 포인트, 정가 , 구매가격--%>
        <tr>
         <td><%=reservation.getTradeId()%></td>




        </tr>
<%
      }
%>









  </div>

</div>
<script>
  // 페이지 로드 시 현재 URL에서 파라미터를 읽어와서 해당 메뉴 버튼에 active 클래스를 추가
  window.onload = function() {
    var urlParams = new URLSearchParams(window.location.search);
    var menuParam = urlParams.get('menu');
    if (menuParam) {
      var menuButton = document.querySelector('button[data-menu="' + menuParam + '"]');
      if (menuButton) {
        menuButton.classList.add('active');
      }
    }
  };

  // 버튼 클릭 이벤트 처리 함수
  function handleClick(button, menu) {
    // 모든 버튼의 클래스 제거
    let buttons = document.querySelectorAll('button');
    buttons.forEach(function(btn) {
      btn.classList.remove('active');
    });
    // 클릭된 버튼에만 클래스 추가
    button.classList.add('active');

    // 파라미터 추가 함수 호출
    addParam('menu', menu);
  }

  // URL에 파라미터 추가하는 함수
  function addParam(key, value) {
    var url = new URL(window.location.href);
    url.searchParams.set(key, value);
    window.location.href = url.toString();
  }
</script>

</body>
</html>
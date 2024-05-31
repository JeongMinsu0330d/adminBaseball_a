<%@ page import="com.example.adminbaseball.StadiumVo" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
  List<StadiumVo> stadiums = (List<StadiumVo>)request.getAttribute("stadiums");

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
      border : 1px solid black;
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

     .modal{
       position:absolute;
       display:none;

       justify-content: center;
       top:0;
       left:0;

       width:100%;
       height:100%;

       background-color: rgba(0,0,0,0.4);
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
    <h1> 경기장 정보 </h1>

      <table border="1" width="100%">
        <thead>
        <tr>
          <th>경기장 번호</th>
          <th>경기장 명</th>
          <th>좌석 배치도</th>
          <th>가격표 보기</th>

        </tr>
        </thead>
        <tbody>
        <%
          for(int i = 0; i < stadiums.size(); i++){
            StadiumVo stadium = stadiums.get(i);
        %>

        <tr>
          <td> <%= stadium.getnStadiumNo()%></td>
          <td> <%= stadium.getStrStadiumName()%></td>
          <td>배치도</td>
          <td> <button onclick="fnPriceInfo(<%= stadium.getnStadiumNo()%>)">가격표 보기</button></td>
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

    <button onclick="fnAddStadium();">경기장 등록</button>
  </div>







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

  function fnAddStadium(){
    window.open("${pageContext.request.contextPath}/stadium/create","_blank","width=1200,height=800");
  }

  function fnPriceInfo(mStadiumNo){
    window.open("${pageContext.request.contextPath}/stadium/priceinfo?stadiumno="+ mStadiumNo,"_blank","width=1200,height=800");
  }


</script>

</body>
</html>
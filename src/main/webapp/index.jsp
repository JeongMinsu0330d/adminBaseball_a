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
            <%@ include file="_layout/Header.jsp"%>
            <!-- 메뉴 클릭에 따른 내용은 이곳에 표시됩니다. -->
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
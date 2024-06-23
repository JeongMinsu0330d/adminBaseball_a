
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    // 게임 번호를 가지고 경기장 의 구간 가격 ( 평일 주말 체크 )

    // 할인쿠폰 정보 가져오기

    // 수수료 정보 가져오기

    //마일리지 결제인 경우 마일리지  내보유 마일리지 정보 가져오기


    // 총 결제금액 : 상품금액 - 쿠폰 - 포인트 + 수수료
%>
<html>
<head>
    <title>예매3</title>
    <script>
        function paymentSelect(){

        }

    </script>
</head>
<body>

<p><span>예매자 : </span> <%= session.getAttribute("user_name")%></p>
<p><span>이메일 : </span> <%= session.getAttribute("user_id")%></p>
<p><span>할인쿠폰 : </span><%= request.getParameter("coupon")%></p>
<p><span>사용 포인트 : </span><%= request.getParameter("point")%></p>

<br>

<div>
    <p><span>결제 수단</span></p>
        <input type="radio" value="m" name="payment" onclick="paymentSelect()">마일리지
        <input type="radio" value="c" name="payment" onclick="paymentSelect()">카드
        <input type="radio" value="p" name="payment" onclick="paymentSelect()">휴대폰

<p><span>상품 금액: </span> </p>
<p><span>쿠폰 할인 금액: </span></p>
<p><span>포인트: </span></p>
<p><span>수수료: </span></p>


<p><span>총 결제 금액: </span></p>

</div>
</body>
</html>

<%@ page import="com.example.adminbaseball.service.BaseballService" %>
<%@ page import="com.example.adminbaseball.model.Coupon" %>
<%@ page import="java.util.List" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%
    String sectionType = request.getParameter("seatType");
    String sectionNo = request.getParameter("sectionNo");
    String seatNos = request.getParameter("seatNo");
    String gameCode = request.getParameter("gameCode");

    String[] seatno = seatNos.split(",");
    BaseballService service = new BaseballService();

    List<Coupon> coupons = service.fnGetCoupon((int)session.getAttribute("user_no"));
//        쿠폰 내역
    int point = service.fnGetPoint((int)session.getAttribute("user_no"));

    LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSSS");
    String tradeId = now.format(formatter);
    System.out.println(tradeId);
%>

<html>
<head>
    <title>예매 정보</title>

    <script>
    // SELECT 박스에서 값이 변경될 때 실행되는 함수
    let selectedValue ="";
    document.getElementById("mySelect").addEventListener("change", function() {
        // 선택한 값 가져오기
        selectedValue = document.getElementById("mySelect").value;
    });

    function previous(){
        window.history.go(-1);
    }
    function next(){
        let selectCoupon = document.getElementById("coupon");
        let coupon = selectCoupon.value;

        let point = document.getElementById("point").value;
        console.log(point);
        window.location.href = "<%=request.getContextPath()%>/baseball/Reservation3.jsp?gameCode=<%=gameCode%>&sectionType=<%=sectionType%>&sectionNo=<%=sectionNo%>&seats=<%=seatNos%>&tradeId=<%=tradeId%>&point="+point+"&coupon="+coupon;
    }
</script>


</head>
<body>

<div class="container">
    <span>
        예매정보
    </span>
    <%=sectionType%> <%=sectionNo%> 구간 <%=seatNos%> 좌석을 선택 하였습니다. <%= seatno.length %> 매 예매

    <select id="coupon">
         <option value="">선택된 쿠폰이 없습니다.</option>
        <%
            for(Coupon coupon : coupons) {
                if(coupons != null){
        %>
            <option value="<%=coupon.getCouponNo()%>"><%=coupon.getCouponName()%></option>
        <%
                }
            }
        %>
    </select>
    <span>포인트</span><br>

    <form action="<%=request.getContextPath()%>/web/reservation" method="POST">
        <input type="number" id="point" name="point" value="0"> 사용<br>
        <span>보유 포인트 : <%=point%> P</span>
        <input type="hidden" name="gameCode" value="<%=gameCode%>">
        <input type="hidden" name="sectionType" value="<%=sectionType%>">
        <input type="hidden" name="section_no" value="<%=sectionNo%>">
        <input type="hidden" name="seatNo" value="<%=sectionNo%>">
        <input type="hidden" name="tradeId" value="<%=tradeId%>">
        <input type="submit" value="확인">
    </form>
    <button type="button" onclick="previous()"> 이전 단계 </button>
    <button type="button" onclick="return next()"> 다음 단계 </button>

</div>

</body>
</html>

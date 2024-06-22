<%@ page import="com.example.adminbaseball.service.MileageService2" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<%
    int userNo= (int)session.getAttribute("user_no");
    MileageService2 service2 = new MileageService2();
    String chargeType = (String)request.getParameter("paymentMethod");
    String chargeName;
    if(chargeType.equals("c")){
        chargeName = "신용카드";
    }else{
        chargeName = "휴대폰";
    }
%>

<html>
<head>
    <title></title>
    <style>
        .container{
            width:300px;
            height:300px;
            border: 1px solid black;
        }

    </style>
         <%
                float value = 70000;
                float commissionRate = 10;
                float chargeMile = value * (1-(commissionRate / 100));
                int chargeMile1 = (int)chargeMile;

            %>

    <script>
        function priceSelect(){
            console.log("here");
            
            const price = document.getElementsByName('price');
            const commissionRate = <%= 10 %>;


            price.forEach((node) => {
            if(node.checked)  {
                let chargeMile = node.value * (1 - (commissionRate / 100));
            document.getElementById('result').value = chargeMile;
            document.getElementById('result_txt').innerText = "실 충전 금액은 " + chargeMile +" 원";

            }
            }) 
            
        }

        function charge(){
             let payPrice = document.querySelector('input[name="price"]:checked').value;
            window.open("<%= request.getContextPath()%>/web/mypage/component/Charge.jsp?userNo=<%=userNo%>&paymentMethod=<%=chargeType%>&chargeMoney="+payPrice,"width=500,height=500")

            console.log(isCharge);
            if(isCharge) {
                alert("마일리지 충전 완료")
                window.close();
            }else{
                alert("마일리지 충전 실패")
            }

        }
    </script>

</head>
<body>
    <div class="container">
        <span> 마일리지 <%= chargeName%> 충전 금액 선택 </span>

        <form action="#" method="GET">
            <input type="radio" value="3000" name="price" onclick="priceSelect()">3,000원
            <input type="radio" value="5000" name="price" onclick="priceSelect()">4,000원
            <br>
            <input type="radio" value="10000" name="price" onclick="priceSelect()">10,000원
            <input type="radio" value="50000" name="price" onclick="priceSelect()">50,000원
            <br>
            <input type="radio" value="70000" name="price" onclick="priceSelect()">70,000원
            <input type="radio" value="100000" name="price" onclick="priceSelect()">100,000원

            <br>
            <input type="hidden" name="paymentMethod" value="<%=chargeType%>">
            <input type="hidden" id="result" name="chargeMile">
            <div id="result_txt"></div>
            <input type="button" value="확인" onclick="charge()">
            <input type="reset" value="취소">


        </form>

    </div>

</body>
</html>

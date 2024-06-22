<%@ page import="com.example.adminbaseball.model.MileageFillList" %>
<%@ page import="com.example.adminbaseball.service.MileageService2" %><%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2024-06-22
  Time: 오후 2:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>충전</title>
</head>
<body>
    <%
        MileageService2 mileageService = new MileageService2();
        int userNo = Integer.parseInt(request.getParameter("userNo"));
        String paymentMethod = request.getParameter("paymentMethod");
        int payMoney = Integer.parseInt(request.getParameter("chargeMoney"));
        float commission_rate = 0;
        String accountCode="";


//
        if(paymentMethod.equals("m")){
            commission_rate = 10;
            accountCode = "SA0101";


        }else if(paymentMethod.equals("c")){
            commission_rate = 5;
            accountCode = "SA0102";
        }

        int chargeMile = (int)(payMoney * (1-(commission_rate / 100)));
        int commissionPrice = payMoney - chargeMile;

        String tid = "PG1234567890";

        MileageFillList mileageFillList = new MileageFillList(accountCode,  userNo, payMoney, paymentMethod, chargeMile, commissionPrice, tid);

        boolean isChargeMile = mileageService.chargeMileage(mileageFillList);

        if(isChargeMile){
    %>
            <script>
                alert("마일리지 충전 완료 되었습니다.");
                window.close();
            </script>
    <%
        }else{
    %>
            <script>
                alert("마일리지 충전 실패 하였습니다.");
                window.close();
            </script>
    <%
        }
    %>
</body>
</html>

<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.adminbaseball.model.MileageChangeList" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
    int myMile = (int)request.getAttribute("mileage");
    List<MileageChangeList> mileageChangeLists = (List<MileageChangeList>)request.getAttribute("mileageChangeList");

%>

<!DOCTYPE html>
<html>
<head>
    <title>메인페이지</title>
    <style>
        .container{
            width:80%;
            max-width: 1550px;
            min-width: 800px;
            margin:0 auto;
            box-sizing: border-box;

        }
        .container > .section_wrap{
            display:flex;
            flex-direction: row;
            width:100%;
            padding:20px 50px;
            max-width: 100%;
            min-width: 750px;
            box-sizing: border-box;
        }



        .section_wrap > .menu_wrap{
            display:flex;
            position: sticky;
            flex-direction: row;
            justify-content: space-between;
            width:300px;
            height:300px;
            margin-top:30px;
            border:1px solid black;
            box-sizing: border-box;
            background-color: #ddd;
        }
        .section_wrap > .content_wrap{
            width:1200px;
            height:800px;
            margin-top:30px;
            border:1px solid black;
            box-sizing: border-box;
            background-color: #fff;
        }

        .myMileInfo{
            width:100%;
            height: 200px;
            border: 1px solid black;
        }

        .charge_wrap{
            display:flex;
            justify-content: space-around;
            width:100%;
            height: 200px;
            border: 1px solid black;
        }

        .charge_wrap > .charge_item{
            width:200px;
            height:80px;
            border:1px solid black;
        }

    </style>
    <script>
        function fnChargeMile(getValue){
            let chargeType;
            if(getValue == 1){
                chargeType = "c";
            }else if(getValue == 2){
                chargeType = "m";
            }else {

            }
            window.open("<%= request.getContextPath()%>/baseball/mypage/component/ChargeMile.jsp?paymentMethod="+chargeType,"_blank","width=500,height=500")



        }

    </script>
</head>
<body>
<%
    String message = (String)request.getAttribute("message");
   if (message != null && !message.trim().isEmpty()) {
%>
    <script type="text/javascript">
        alert("<%= message %>");
    </script>
<%
    }
%>

    <div class="container">
        <%@ include file="/baseball/_layout/Header.jsp"%>
        <div class="section_wrap">
            <div class="menu_wrap">
                <div id="sidebar">
                    <ul class="menu">
                        <li><a href="./reservation">예매 내역</a></li>
                        <li><a href="./mileage">마일리지</a></li>
                        <li><a href="./point">포인트</a></li>
                        <li><a href="./coupon">할인쿠폰</a></li>
                    </ul>
                </div>
            </div>
            <div class="content_wrap">

                <span>나의 마일리지</span>
                <div class="myMileInfo">
                    <%= myMile%> 원
                </div>

                <span>마일리지 충전</span>
                <div class="charge_wrap">
                    <div class="charge_item" onclick="fnChargeMile(1)">신용카드</div>
                    <div class="charge_item" onclick="fnChargeMile(2)">휴대폰</div>
                </div>

                <div class="mileage_info_list_wrap">
                        <table border="1" width="100%">
                            <thead>
                            <tr>
                              <th>날 짜</th>
                              <th>구 분</th>
                              <th>마일리지 변동 내역</th>
                              <th>변동후 마일리지</th>
                              <th>사용 및 전환 내역</th>
                            </tr>
                            </thead>
                            <tbody>

                            <%
                                if(mileageChangeLists == null){
                            %>

                                <td colspan="5"> 마일리지 이용 내역이 없습니다.</td>

                            <%
                                }else{
            // 날짜, 구분(충전,결제...), 마일리지 변동 내역, 변동후 마일리지, 사용 및 전환 내역
                                for(MileageChangeList mileageChangeList: mileageChangeLists){
                            %>
                                <tr>
                                  <td> <%= mileageChangeList.getRegDate()%>       </td>
                                  <td> <%= mileageChangeList.getChangeType()%>     </td>
                                  <td> <%= mileageChangeList.getMileage()%>  </td>
                                  <td> <%= mileageChangeList.getNextMileage()%>  </td>
                                  <td> <%= mileageChangeList.getChangeComment()%>  </td>
                                </tr>
                            <%
                                    }
                              }
                            %>
                            </tbody>
                          </table>
                </div>

            </div>
        </div>

    </div>

</body>
</html>

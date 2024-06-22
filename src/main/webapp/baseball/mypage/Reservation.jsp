<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.adminbaseball.model.Reservation" %>
<%@ page import="com.example.adminbaseball.common.Classify" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
    Classify classify = new Classify();
    List<Reservation> reservations = (List<Reservation>)request.getAttribute("reservations");
%>

<!DOCTYPE html>
<html>
<head>
    <title>마이페이지 - 예매</title>
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

        .reservation_wrap{
            display:flex;
            justify-content: space-between;
            align-items: center;
            width:900px;
            height:160px;
            border:1px solid black;
            border-radius: 5px;
            margin:14px 10px;
            padding:1px 14px;
        }
        .r_image{
            width:190px;
            height:120px;
            border:1px solid black;
            border-radius: 5px;
        }
        .r_content{
            width:490px;
            height:120px;
        }
        .r_content2{
            text-align:right;
            width:190px;
            height:120px;
        }

    </style>
    <script>


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
                <span>이용 완료 / 예매 취소 내역</span>

                <div class="reservation_list_wrap">
                    <%
                        if(reservations == null){
                    %>
                    <div class="reservation_wrap">
                        <span> 예매 내역이 없음</span>
                    </div>
                    <%
                        }else{
                            for(Reservation reservation : reservations){
                    %>
                    <div class="reservation_wrap">
                        <div class="r_image"></div>
                        <div class="r_content">
                            <span>경기명/경기일정 :</span>
                            <%= reservation.getHomeTeamName()%> vs <%= reservation.getAwayTeamName()%> / <%=reservation.getPlayDate()%>
                            <br>
                            <span>결제금액 / 결제 수단 :</span>
                            <%= reservation.getReservationPrice()%> / <%= classify.TransferPaymentMethod(reservation.getPaymentMethod())%>
                            <br>
                            <span>인원 :</span>
                            <%= reservation.getCountReservation()%>
                            <br>
                            <span>좌석 정보 :</span>
                            <%= reservation.getSeatInfo()%>
                        </div>
                        <div class="r_content2">
                            <span style="color:red"><%= classify.TransferReservationState(reservation.getReservationState())%></span>
                            <span><%= reservation.getTradeId()%></span>

                        </div>
                    </div>
                    <%
                            }
                        }
                    %>

                </div>

            </div>
        </div>

    </div>

</body>
</html>

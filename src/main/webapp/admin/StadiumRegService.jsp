<%@ page import="com.mysql.cj.xdevapi.JsonParser" %>
<%@ page import="com.example.adminbaseball.common.Section" %>
<%@ page import="com.example.adminbaseball.common.Value" %>
<%@ page import="com.example.adminbaseball.common.DataConverter" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.adminbaseball.common.ClassifyStadium" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<%
    ClassifyStadium classify = new ClassifyStadium();
    Section[] sections = DataConverter.convertJsonToModel(request.getParameter("rgData[]"));

    // 변환된 모델 객체 확인
//    for (Section section : sections) {
//        System.out.println("Section Type: " + section.getSection_type());
//        for (Value value : section.getValues()) {
//            System.out.println("Section No: " + value.getSection_no());
//            System.out.println("Seat Col: " + value.getSeat_col());
//            System.out.println("Seat Row: " + value.getSeat_row());
//        }
//    }

    // 모델 객체를 JSON 문자열로 변환
    String convertedJson = DataConverter.convertModelToJson(sections);
//    System.out.println("Converted JSON: " + convertedJson);

//    for (JsonModel section : sections) {
//            System.out.println("Section Type: " + section.getSection_type());
//            List<Value> values = section.getValues();
//            if (values.isEmpty()) {
//                continue; // 값이 없으면 다음 섹션으로 넘어감
//            }
//            for (Value value : values) {
//                System.out.println("Section No: " + value.getSection_no());
//                System.out.println("Seat Col: " + value.getSeat_col());
//                System.out.println("Seat Row: " + value.getSeat_row());
//            }
//    }



%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>경기장 만들기 2</h1>
<br>
    <h1><%= request.getParameter("stadiumName")%></h1>
    <table border="1" width="100%">
        <tr>
            <th>등급</th>
            <th>권종 여부</th>
            <th>주중 가격</th>
            <th>주말 가격</th>
        </tr>
    <%
        for (Section section : sections) {
            List<Value> values = section.getValues();
            if (values.isEmpty()) {
                continue; // 값이 없으면 다음 섹션으로 넘어감
            }
    %>
        <tr>
            <td>
                <input type="hidden" value="<%= section.getSection_type()%>">
                <%= classify.fnTransferSectionType(section.getSection_type())%>
            </td>
            <td><input type="checkbox" id="isAgeType"></td>
            <td><input type="number" placeholder="주중" id="nPriceWeek"></td>
            <td><input type="number" placeholder="주말" id="nPriceWeekend"></td>
        </tr>
    <%
        }
    %>
    </table>

    <form action="${pageContext.request.contextPath}/stadium/create" method="POST" id="form_a">
        <input type="hidden" name="stadium_name" value="<%= request.getParameter("stadiumName")%>">
        <input type="hidden" name="stadium_seat_image" value="<%=request.getParameter("stadiumImg")%>">
        <input type="hidden" name="rgPriceData[]" id="priceData" value="">
        <input type="hidden" name="rgData[]" id="form_rgData" value=<%= request.getParameter("rgData[]")%>>
        <input type="submit" value="완료" onclick="return successTicket()">
    </form>

    <%=request.getParameter("rgData[]")%>
<script>
    function successTicket(){
        let priceData = []; // 데이터 배열 초기화

        // 각 테이블 행을 순회하면서 데이터 수집
        let tableRows = document.querySelectorAll("table tr");
        for (let i = 1; i < tableRows.length; i++) { // 첫 번째 행은 헤더이므로 무시
            let row = tableRows[i];
            let sectionType = row.cells[0].querySelector("input[type='hidden']").value;
            let isAgeType = row.cells[1].querySelector("input[type='checkbox']").checked;
            let price1 = row.cells[2].querySelector("input[type='number']").value;
            let price2 = row.cells[3].querySelector("input[type='number']").value;

            // 데이터 객체 생성 및 배열에 추가
            let rowData = {
                section_type: sectionType,
                isAgeType: isAgeType,
                Price1: parseInt(price1), // 숫자로 변환하여 저장
                Price2: parseInt(price2) // 숫자로 변환하여 저장
            };
            priceData.push(rowData);
        }

        document.getElementById("priceData").value=JSON.stringify(priceData);

        console.log(priceData);
        // JSON 문자열로 변환하여 반환
        // return JSON.stringify(data);

    }

</script>
</body>
</html>

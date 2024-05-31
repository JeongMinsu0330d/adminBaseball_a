<%@ page import="java.util.*" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%
Map<String, Object> rgSeatInfo = new LinkedHashMap<>();

    if(rgSeatInfo.isEmpty()){
        for(int key_1 = 1; key_1 <= 3; key_1++){

            for(int key_2 = 1;key_2 <=20; key_2++ ){
                String key = "" + key_1 + key_2;
                if(key_2 < 10){
                    key = key_1 +"0"+ key_2;
                }
                rgSeatInfo.put(key,"");
            }
        }
    }

%>
<html>
<head>
    <title>경기장 등록</title>
    <script>
        let list;
        let selectSectionNo = [];

        function addTable(){
            // 등급(section_type)
            const selectElement = document.getElementById("section_type");
            const selectIndex = selectElement.selectedIndex;
            const section_type = selectElement.options[selectIndex].value;

            // const isCheckedValue = document.getElementById("isAgeType").checked;
            // 좌석 구간 번호
            const selectElement1 = document.getElementById("section_no");
            const selectIndex1 = selectElement1.selectedIndex;
            const section_no = selectElement1.options[selectIndex1].value;

            // 좌석 열 / 행
            let seatCol = document.getElementById("seatCol").value;
            let seatRow = document.getElementById("seatRow").value;

            for(let dupSectionNo in selectSectionNo){
                if(selectSectionNo[dupSectionNo] == section_no) {
                    alert("이미 중복된 값")
                    return;
                }
                console.log(dupSectionNo);
            }

            selectSectionNo.push(section_no);
            let dic = {
                'section_no': section_no,
                'seat_col': seatCol,
                'seat_row': seatRow
            }
            if(list == null){
                list = [
                    {section_type:'a',values:[]},
                    {section_type:'b',values:[]},
                    {section_type:'c',values:[]},
                    {section_type:'d',values:[]},
                    {section_type:'e',values:[]},
                    {section_type:'f',values:[]},
                    {section_type:'g',values:[]},
                    {section_type:'h',values:[]},
                    {section_type:'i',values:[]},
                    {section_type:'j',values:[]}
                ]
            }

            list.map((value, index, array)=>{
              if(value.section_type == section_type){
                  value.values.push(dic);
              }
            })

            let dynamicTable = document.getElementById("dynamicTable");
            let rowTag = document.createElement('tr')
            rowTag.innerHTML = "" +
                "<td>" + section_type + "</td>"+
                "<td>" + section_no + "</td>"+
                "<td>" + seatCol+ "</td>"+
                "<td>" + seatRow+ "</td>";

            dynamicTable.appendChild(rowTag);

        }
    </script>


</head>
<body>
<%--    <form action="">--%>
        <table border="1" width="100%">
            <colgroup>
                <col style="width: 20%;"/>
                <col style="width: 75%;"/>
            </colgroup>
           <tr>
               <th>경기장명</th>
               <td><input type="text" value="" placeholder="경기장 명을 입력 하세요." name="stadium_name" id="stadium_name"></td>
           </tr>
            <tr>
                <th>경기장 좌석 배치도</th>
                <td><input type="text" value="" placeholder="경기장 명을 입력 하세요." name="stadium_seat_img" id="stadium_seat_img"></td>
            </tr>
            <tr>
                <th>좌석 정보</th>
                <td>
                    <table id="calculator_table" border="1" width="90%">
                        <thead>
                        <tr>
                            <th>등급</th>
                            <th>권종</th>
                            <th>구역</th>
                            <th>추가하기</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>
                                <select id="section_type">
                                    <option name="section_type" value="a">프리미엄석</option>
                                    <option name="section_type" value="b">테이블석</option>
                                    <option name="section_type" value="c">익사이팅석</option>
                                    <option name="section_type" value="d">블루석</option>
                                    <option name="section_type" value="e">오렌지석</option>
                                    <option name="section_type" value="f">레드석</option>
                                    <option name="section_type" value="g">네이비석</option>
                                    <option name="section_type" value="h">외야석</option>
                                    <option name="section_type" value="i">휠체어블루석</option>
                                    <option name="section_type" value="j">휠체어레드석</option>
                                </select>
                            </td>
                            <td>
                                <select id="section_no">
                                    <%
                                        for(String key:rgSeatInfo.keySet()){
                                            System.out.println(key);
                                            if(rgSeatInfo.get(key).equals("")){

                                    %>
                                            <option name="section_no" value="<%= key%>"><%=key %></option>
                                    <%
                                            }
                                        }
                                    %>
                                </select>
                            <td>
                                <input type="number" placeholder="col" name="seat_col" id="seatCol">
                                x
                                <input type="number" placeholder="row" name="seat_row" id="seatRow">
                            </td>
                            <td><button class="tr_delete" onclick="addTable()">생성</button></td>
                        </tr>
                        </tbody>
                    </table>
                    <br>
                    <table border="1" width="90%" id="dynamicTable">
                            <tr>
                                <th>등급</th>
                                <th>구역</th>
                                <th>좌석 열</th>
                                <th>좌석 행</th>
                            </tr>
                    </table>
                </td>
            </tr>
        </table>
        <form action="${pageContext.request.contextPath}/admin/StadiumRegService.jsp" method="GET" id="form_a">
            <input type="hidden" name="stadiumName" id="form_stadium_name">
            <input type="hidden" name="stadiumImg" id="form_stadium_img">
            <input type="hidden" name="rgData[]" id="form_rgData">
            <input type="submit" value="다음" onclick="return nextPage()">
        </form>

<%--    </form>--%>
<script>
    function nextPage() {
        let stadium_name = document.getElementById("stadium_name").value;
        let stadium_image = document.getElementById("stadium_seat_img").value;

        document.getElementById("form_stadium_name").value = stadium_name;
        document.getElementById("form_stadium_img").value = stadium_image;
        document.getElementById("form_rgData").value = JSON.stringify(list);

        // 정합성 검사 함수 필요.

        //
        return true;
    }
</script>
</body>

</html>

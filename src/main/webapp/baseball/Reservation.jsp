<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
    int gameCode = Integer.parseInt(request.getParameter("gameCode"));
%>
<!DOCTYPE html>
<html lang="kor">
<head>
    <meta charset="UTF-8">
    <title>Seat Reservation Example</title>
    <style>
        body {
            display: flex;
            flex-direction: column;
        }
        .left-panel {
            width: 50%;
            border-right: 1px solid #ccc;
            padding: 20px;
            height: 100%;
        }
        .right-panel {
            width: 50%;
            position: relative;
            padding: 20px;
            height: 100%;
        }
        .details {
            position: absolute;
            top: 20px;
            left: 20px;
            background-color: #f9f9f9;
            border: 1px solid #ccc;
            padding: 20px;
            display: none;
        }
        .hidden {
            display: none;
        }
        .seat {
            margin: 5px;
        }
        .disabled {
            pointer-events: none;
            background-color: #ddd;
        }
        .seat-grid {
            display: grid;
            gap: 5px;
            margin-top: 20px;
            grid-template-columns: repeat(13, auto); /* 12 seats + 1 for row header */
        }
        .seat-header {
            font-weight: bold;
            text-align: center;
            padding: 5px;
        }
        .bottom-panel {
            width: 100%;
            padding: 20px;
            border-top: 1px solid #ccc;
            margin-top: 20px;
        }
    </style>
</head>
<body>
    <div style="display: flex; width: 100%;">
        <div class="left-panel">
            <h1>List Example</h1>
            <ul>
                <%-- Example list data --%>
                <%
                    String[][] listData = {
                        {"Title 1", "Subtitle 1.1", "Subtitle 1.2"},
                        {"Title 2", "Subtitle 2.1", "Subtitle 2.2"},
                        {"Title 3", "Subtitle 3.1", "Subtitle 3.2"}
                    };
                    for (int i = 0; i < listData.length; i++) {
                        String[] item = listData[i];
                %>
                <li>
                    <span class="title" onclick="toggleSubtitles(this)"><%= item[0] %></span>
                    <ul class="subtitles hidden">
                        <% for (int j = 1; j < item.length; j++) { %>
                        <li><span class="subtitle" onclick="showDetails('<%= item[0] %>', '<%= item[j] %>')"><%= item[j] %></span></li>
                        <% } %>
                    </ul>
                </li>
                <% } %>
            </ul>
        </div>
        <div class="right-panel">
            <div id="details" class="details"></div>
        </div>
    </div>
    <div class="bottom-panel">
        <div id="seat-info">
            Seat Information:
            <br>
            등급: <span id="seat-type"></span>
            좌석 구간: <span id="section-no"></span>
            좌석 번호: <span id="seat-no"></span>
        </div>

        <form id="seatForm" action="<%=request.getContextPath()%>/baseball/Reservation2.jsp" method="get">
            <input type="hidden"  name="gameCode" value="<%=gameCode%>">
            <input type="hidden" id="seatTypeInput" name="sectionType">
            <input type="hidden" id="sectionNoInput" name="sectionNo">
            <input type="hidden" id="seatNoInput" name="seatNo">
            <button type="submit">다음으로</button>
            <button type="button" onclick="window.close()">이전으로</button>
        </form>
    </div>

    <script>
        let selectedTitle = '';
        let selectedSubtitle = '';
        let selectedSeats = [];

        function toggleSubtitles(element) {
            let subtitleList = element.nextElementSibling;
            subtitleList.classList.toggle('hidden');
        }

        function showDetails(title, subtitle) {
            let detailsDiv = document.getElementById('details');
            detailsDiv.innerHTML = "Seats for " + title + " - " + subtitle + "<br><br>";

            selectedTitle = title;
            selectedSubtitle = subtitle;
            selectedSeats = [];

            let totalSeats = 60;
            let rows = 5;
            let cols = 12;
            let disabledSeats = [4, 6];
            let seatNumber = 1;

            let seatGrid = document.createElement("div");
            seatGrid.className = "seat-grid";

            seatGrid.appendChild(document.createElement("div"));
            for (let col = 1; col <= cols; col++) {
                let colHeader = document.createElement("div");
                colHeader.className = "seat-header";
                colHeader.textContent = col;
                seatGrid.appendChild(colHeader);
            }

            for (let i = 0; i < rows; i++) {

                let rowHeader = document.createElement("div");
                rowHeader.className = "seat-header";
                rowHeader.textContent = String.fromCharCode(65 + i); // 'A', 'B', 'C', ...
                seatGrid.appendChild(rowHeader);

                for (let j = 0; j < cols; j++) {
                    if (seatNumber > totalSeats) break;
                    let checkbox = document.createElement("input");
                    checkbox.type = "checkbox";
                    checkbox.id = "seat" + seatNumber;
                    checkbox.value = seatNumber;
                    checkbox.className = "seat";
                    checkbox.onclick = function() { updateSelectedSeats(this); };
                    if (disabledSeats.includes(seatNumber)) {
                        checkbox.disabled = true;
                        checkbox.classList.add("disabled");
                    }
                    seatGrid.appendChild(checkbox);
                    seatNumber++;
                }
            }

            detailsDiv.appendChild(seatGrid);
            detailsDiv.style.display = 'block';
            updateSeatInfo();

        }

        function updateSelectedSeats(checkbox) {
            if (checkbox.checked) {
                selectedSeats.push(checkbox.value);

            } else {
                let index = selectedSeats.indexOf(checkbox.value);

                if (index !== -1) {
                    selectedSeats.splice(index, 1);
                }

            }
            updateSeatInfo();
        }



        function updateSeatInfo() {
            document.getElementById('seat-type').innerText = selectedTitle;
            document.getElementById('section-no').innerText = selectedSubtitle;
            document.getElementById('seat-no').innerText = selectedSeats.join(', ');

            // Update hidden inputs
            document.getElementById('seatTypeInput').value = selectedTitle;
            document.getElementById('sectionNoInput').value = selectedSubtitle;
            document.getElementById('seatNoInput').value = selectedSeats.join(',');
        }

    </script>
</body>
</html>

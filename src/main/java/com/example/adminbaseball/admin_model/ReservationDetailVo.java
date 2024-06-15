package com.example.adminbaseball.admin_model;

public class ReservationDetailVo {
    private long seq; // 일련번호
    private int userNo; // 회원번호
    private long tradeId; // 거래번호
    private String ageType; // 나이 구분값 (a:일반, b:만 6세 이상 ~ 만 12세 미만, c:만 6세 미만)
    private int stadiumNo; // 경기장 번호
    private String stadiumName; // 경기장명
    private int homeTeamNo; // 홈팀 번호
    private String homeTeamName; // 홈팀 명
    private int awayTeamNo; // 어웨이팀 번호
    private String awayTeamName; // 어웨이팀 명
    private int gameListSeq; // 게임 내역 일련번호
    private int stadiumSeatListSeq; // 경기장 좌석 일련번호
    private int seatNo; // 좌석번호
    private String reservationState; // 예매 상태 (a:예매, b:예매중, c:예매 취소)
    private int objectSeq; // 보호자의 경우 보호대상 예매 일련번호
    private int totalPrice; // 최종 티켓 금액
    private String ticketType; // 권종 (a:일반, b:아동, c:유아)
    private int ticketPrice; // 티켓 금액
    private String discountCode; // 할인코드
    private int discountPrice; // 할인 금액
    private int adminNo; // 관리자번호
    private String regDate; // 등록일시

    // Getters and Setters

    public long getSeq() {
        return seq;
    }

    public void setSeq(long seq) {
        this.seq = seq;
    }

    public int getUserNo() {
        return userNo;
    }

    public void setUserNo(int userNo) {
        this.userNo = userNo;
    }

    public long getTradeId() {
        return tradeId;
    }

    public void setTradeId(long tradeId) {
        this.tradeId = tradeId;
    }

    public String getAgeType() {
        return ageType;
    }

    public void setAgeType(String ageType) {
        this.ageType = ageType;
    }

    public int getStadiumNo() {
        return stadiumNo;
    }

    public void setStadiumNo(int stadiumNo) {
        this.stadiumNo = stadiumNo;
    }

    public String getStadiumName() {
        return stadiumName;
    }

    public void setStadiumName(String stadiumName) {
        this.stadiumName = stadiumName;
    }

    public int getHomeTeamNo() {
        return homeTeamNo;
    }

    public void setHomeTeamNo(int homeTeamNo) {
        this.homeTeamNo = homeTeamNo;
    }

    public String getHomeTeamName() {
        return homeTeamName;
    }

    public void setHomeTeamName(String homeTeamName) {
        this.homeTeamName = homeTeamName;
    }

    public int getAwayTeamNo() {
        return awayTeamNo;
    }

    public void setAwayTeamNo(int awayTeamNo) {
        this.awayTeamNo = awayTeamNo;
    }

    public String getAwayTeamName() {
        return awayTeamName;
    }

    public void setAwayTeamName(String awayTeamName) {
        this.awayTeamName = awayTeamName;
    }

    public int getGameListSeq() {
        return gameListSeq;
    }

    public void setGameListSeq(int gameListSeq) {
        this.gameListSeq = gameListSeq;
    }

    public int getStadiumSeatListSeq() {
        return stadiumSeatListSeq;
    }

    public void setStadiumSeatListSeq(int stadiumSeatListSeq) {
        this.stadiumSeatListSeq = stadiumSeatListSeq;
    }

    public int getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(int seatNo) {
        this.seatNo = seatNo;
    }

    public String getReservationState() {
        return reservationState;
    }

    public void setReservationState(String reservationState) {
        this.reservationState = reservationState;
    }

    public int getObjectSeq() {
        return objectSeq;
    }

    public void setObjectSeq(int objectSeq) {
        this.objectSeq = objectSeq;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public int getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public String getDiscountCode() {
        return discountCode;
    }

    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
    }

    public int getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(int discountPrice) {
        this.discountPrice = discountPrice;
    }

    public int getAdminNo() {
        return adminNo;
    }

    public void setAdminNo(int adminNo) {
        this.adminNo = adminNo;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }
}

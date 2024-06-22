package com.example.adminbaseball.model;

import java.util.List;

public class Reservation {
    private long tradeId; // 거래번호
    private int userNo; // 회원번호
    private int stadiumNo; // 경기장 번호
    private String stadiumName; // 경기장 명
    private int homeTeamNo; // 홈팀 번호
    private String homeTeamName; // 홈팀 명
    private int awayTeamNo; // 어웨이팀 번호
    private String awayTeamName; // 어웨이팀 명
    private String paymentMethod; // 결제 방식 (m:마일리지, c:카드, p:휴대전화)
    private String reservationState; // 예매 상태 (a:예매, b:예매중, c:예매 취소)
    private int reservationPrice; // 예매 금액
    private String successDate; // 예매 성공 일시
    private String cancelDate; // 취소일시
    private int adminNo; // 관리자번호
    private String regDate; // 등록일시
    private int gameListSeq; // 게임 내역 일련번호
    private int countReservation;
    private String seatInfo;
    private String playDate;

    public Reservation() {
    }

    public Reservation(long tradeId, int userNo, int stadiumNo, String stadiumName, int homeTeamNo, String homeTeamName, int awayTeamNo, String awayTeamName, String paymentMethod, String reservationState, int reservationPrice, String successDate, String cancelDate, int adminNo, String regDate, int gameListSeq, int countReservation, String seatInfo, String playDate) {
        this.tradeId = tradeId;
        this.userNo = userNo;
        this.stadiumNo = stadiumNo;
        this.stadiumName = stadiumName;
        this.homeTeamNo = homeTeamNo;
        this.homeTeamName = homeTeamName;
        this.awayTeamNo = awayTeamNo;
        this.awayTeamName = awayTeamName;
        this.paymentMethod = paymentMethod;
        this.reservationState = reservationState;
        this.reservationPrice = reservationPrice;
        this.successDate = successDate;
        this.cancelDate = cancelDate;
        this.adminNo = adminNo;
        this.regDate = regDate;
        this.gameListSeq = gameListSeq;
        this.countReservation = countReservation;
        this.seatInfo = seatInfo;
        this.playDate = playDate;
    }

    public long getTradeId() {
        return tradeId;
    }

    public void setTradeId(long tradeId) {
        this.tradeId = tradeId;
    }

    public int getUserNo() {
        return userNo;
    }

    public void setUserNo(int userNo) {
        this.userNo = userNo;
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

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getReservationState() {
        return reservationState;
    }

    public void setReservationState(String reservationState) {
        this.reservationState = reservationState;
    }

    public int getReservationPrice() {
        return reservationPrice;
    }

    public void setReservationPrice(int reservationPrice) {
        this.reservationPrice = reservationPrice;
    }

    public String getSuccessDate() {
        return successDate;
    }

    public void setSuccessDate(String successDate) {
        this.successDate = successDate;
    }

    public String getCancelDate() {
        return cancelDate;
    }

    public void setCancelDate(String cancelDate) {
        this.cancelDate = cancelDate;
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

    public int getGameListSeq() {
        return gameListSeq;
    }

    public void setGameListSeq(int gameListSeq) {
        this.gameListSeq = gameListSeq;
    }

    public int getCountReservation() {
        return countReservation;
    }

    public void setCountReservation(int countReservation) {
        this.countReservation = countReservation;
    }

    public String getSeatInfo() {
        return seatInfo;
    }

    public void setSeatInfo(String seatInfo) {
        this.seatInfo = seatInfo;
    }

    public String getPlayDate() {
        return playDate;
    }

    public void setPlayDate(String playDate) {
        this.playDate = playDate;
    }
}
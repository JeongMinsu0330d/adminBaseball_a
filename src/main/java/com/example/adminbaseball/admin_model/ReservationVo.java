package com.example.adminbaseball.admin_model;

import java.util.List;

public class ReservationVo {
    private int tradeId;
    private int userNo;
    private int gameCode;
    private String stadiumName;
    private int stadiumNo;
    private String homeTeamName;
    private int homeTeamNo;
    private String awayTeamName;
    private int awayTeamNo;
    private String paymentMethod;
    private char reservationState;
    private String reservationStateKor;
    private int reservationPrice;
    private String successDate;
    private String cancelDate;
    private char userCancelPolicyAgreeFlag;
    private String userCancelPolicyAgreeDate;
    private char userAgreePrivateInfoSaveFlag;
    private String userAgreePrivateInfoSaveDate;
    private char userAgreeMarketingFlag;
    private String userAgreeMarketingDate;
    private char paymentAgencyAgreeFlag;
    private String paymentAgreeAgreeDate;
    private char paymentAgreePrivateInfoSaveFlag;
    private String paymentAgreePrivateInfoSaveDate;
    private int adminNo;
    private String regDate;
    private List<ReservationDetailVo> reservationDetailVoList;
    public ReservationVo() {
    }

    public ReservationVo(int tradeId, int userNo, int gameCode, String stadiumName, int stadiumNo, String homeTeamName, int homeTeamNo, String awayTeamName, int awayTeamNo, String paymentMethod, char reservationState, int reservationPrice) {
        this.tradeId = tradeId;
        this.userNo = userNo;
        this.gameCode = gameCode;
        this.stadiumName = stadiumName;
        this.stadiumNo = stadiumNo;
        this.homeTeamName = homeTeamName;
        this.homeTeamNo = homeTeamNo;
        this.awayTeamName = awayTeamName;
        this.awayTeamNo = awayTeamNo;
        this.paymentMethod = paymentMethod;
        this.reservationState = reservationState;
        this.reservationPrice = reservationPrice;
    }

    public ReservationVo(int tradeId, int userNo, int gameCode, String stadiumName, int stadiumNo, String homeTeamName, int homeTeamNo, String awayTeamName, int awayTeamNo, String paymentMethod, char reservationState, String reservationStateKor, int reservationPrice, String successDate, String cancelDate, char userCancelPolicyAgreeFlag, String userCancelPolicyAgreeDate, char userAgreePrivateInfoSaveFlag, String userAgreePrivateInfoSaveDate, char userAgreeMarketingFlag, String userAgreeMarketingDate, char paymentAgencyAgreeFlag, String paymentAgreeAgreeDate, char paymentAgreePrivateInfoSaveFlag, String paymentAgreePrivateInfoSaveDate, int adminNo, String regDate, List<ReservationDetailVo> reservationDetailVoList) {
        this.tradeId = tradeId;
        this.userNo = userNo;
        this.gameCode = gameCode;
        this.stadiumName = stadiumName;
        this.stadiumNo = stadiumNo;
        this.homeTeamName = homeTeamName;
        this.homeTeamNo = homeTeamNo;
        this.awayTeamName = awayTeamName;
        this.awayTeamNo = awayTeamNo;
        this.paymentMethod = paymentMethod;
        this.reservationState = reservationState;
        this.reservationStateKor = reservationStateKor;
        this.reservationPrice = reservationPrice;
        this.successDate = successDate;
        this.cancelDate = cancelDate;
        this.userCancelPolicyAgreeFlag = userCancelPolicyAgreeFlag;
        this.userCancelPolicyAgreeDate = userCancelPolicyAgreeDate;
        this.userAgreePrivateInfoSaveFlag = userAgreePrivateInfoSaveFlag;
        this.userAgreePrivateInfoSaveDate = userAgreePrivateInfoSaveDate;
        this.userAgreeMarketingFlag = userAgreeMarketingFlag;
        this.userAgreeMarketingDate = userAgreeMarketingDate;
        this.paymentAgencyAgreeFlag = paymentAgencyAgreeFlag;
        this.paymentAgreeAgreeDate = paymentAgreeAgreeDate;
        this.paymentAgreePrivateInfoSaveFlag = paymentAgreePrivateInfoSaveFlag;
        this.paymentAgreePrivateInfoSaveDate = paymentAgreePrivateInfoSaveDate;
        this.adminNo = adminNo;
        this.regDate = regDate;
        this.reservationDetailVoList = reservationDetailVoList;
    }

    public List<ReservationDetailVo> getReservationDetailVoList() {
        return reservationDetailVoList;
    }

    public void setReservationDetailVoList(List<ReservationDetailVo> reservationDetailVoList) {
        this.reservationDetailVoList = reservationDetailVoList;
    }

    public int getTradeId() {
        return tradeId;
    }

    public void setTradeId(int tradeId) {
        this.tradeId = tradeId;
    }
    public int getGameCode() {
        return gameCode;
    }
    public void setGameCode(int gameCode) {
        this.gameCode = gameCode;
    }
    public int getUserNo() {
        return userNo;
    }

    public void setUserNo(int userNo) {
        this.userNo = userNo;
    }

    public String getStadiumName() {
        return stadiumName;
    }

    public void setStadiumName(String stadiumName) {
        this.stadiumName = stadiumName;
    }

    public int getStadiumNo() {
        return stadiumNo;
    }

    public void setStadiumNo(int stadiumNo) {
        this.stadiumNo = stadiumNo;
    }

    public String getHomeTeamName() {
        return homeTeamName;
    }

    public void setHomeTeamName(String homeTeamName) {
        this.homeTeamName = homeTeamName;
    }

    public int getHomeTeamNo() {
        return homeTeamNo;
    }

    public void setHomeTeamNo(int homeTeamNo) {
        this.homeTeamNo = homeTeamNo;
    }

    public String getAwayTeamName() {
        return awayTeamName;
    }

    public void setAwayTeamName(String awayTeamName) {
        this.awayTeamName = awayTeamName;
    }

    public int getAwayTeamNo() {
        return awayTeamNo;
    }

    public void setAwayTeamNo(int awayTeamNo) {
        this.awayTeamNo = awayTeamNo;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public char getReservationState() {
        return reservationState;
    }

    public void setReservationState(char reservationState) {
        this.reservationState = reservationState;
        if(reservationState == 'a'){
            this.reservationStateKor = "예약완료";
        }else if(reservationState == 'b'){
            this.reservationStateKor = "예약 중";
        }else if(reservationState == 'c'){
            this.reservationStateKor = "예약취소";
        }

    }

    public String getReservationStateKor() {
        return reservationStateKor;
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

    public char getUserCancelPolicyAgreeFlag() {
        return userCancelPolicyAgreeFlag;
    }

    public void setUserCancelPolicyAgreeFlag(char userCancelPolicyAgreeFlag) {
        this.userCancelPolicyAgreeFlag = userCancelPolicyAgreeFlag;
    }

    public String getUserCancelPolicyAgreeDate() {
        return userCancelPolicyAgreeDate;
    }

    public void setUserCancelPolicyAgreeDate(String userCancelPolicyAgreeDate) {
        this.userCancelPolicyAgreeDate = userCancelPolicyAgreeDate;
    }

    public char getUserAgreePrivateInfoSaveFlag() {
        return userAgreePrivateInfoSaveFlag;
    }

    public void setUserAgreePrivateInfoSaveFlag(char userAgreePrivateInfoSaveFlag) {
        this.userAgreePrivateInfoSaveFlag = userAgreePrivateInfoSaveFlag;
    }

    public String getUserAgreePrivateInfoSaveDate() {
        return userAgreePrivateInfoSaveDate;
    }

    public void setUserAgreePrivateInfoSaveDate(String userAgreePrivateInfoSaveDate) {
        this.userAgreePrivateInfoSaveDate = userAgreePrivateInfoSaveDate;
    }

    public char getUserAgreeMarketingFlag() {
        return userAgreeMarketingFlag;
    }

    public void setUserAgreeMarketingFlag(char userAgreeMarketingFlag) {
        this.userAgreeMarketingFlag = userAgreeMarketingFlag;
    }

    public String getUserAgreeMarketingDate() {
        return userAgreeMarketingDate;
    }

    public void setUserAgreeMarketingDate(String userAgreeMarketingDate) {
        this.userAgreeMarketingDate = userAgreeMarketingDate;
    }

    public char getPaymentAgencyAgreeFlag() {
        return paymentAgencyAgreeFlag;
    }

    public void setPaymentAgencyAgreeFlag(char paymentAgencyAgreeFlag) {
        this.paymentAgencyAgreeFlag = paymentAgencyAgreeFlag;
    }

    public String getPaymentAgreeAgreeDate() {
        return paymentAgreeAgreeDate;
    }

    public void setPaymentAgreeAgreeDate(String paymentAgreeAgreeDate) {
        this.paymentAgreeAgreeDate = paymentAgreeAgreeDate;
    }

    public char getPaymentAgreePrivateInfoSaveFlag() {
        return paymentAgreePrivateInfoSaveFlag;
    }

    public void setPaymentAgreePrivateInfoSaveFlag(char paymentAgreePrivateInfoSaveFlag) {
        this.paymentAgreePrivateInfoSaveFlag = paymentAgreePrivateInfoSaveFlag;
    }

    public String getPaymentAgreePrivateInfoSaveDate() {
        return paymentAgreePrivateInfoSaveDate;
    }

    public void setPaymentAgreePrivateInfoSaveDate(String paymentAgreePrivateInfoSaveDate) {
        this.paymentAgreePrivateInfoSaveDate = paymentAgreePrivateInfoSaveDate;
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

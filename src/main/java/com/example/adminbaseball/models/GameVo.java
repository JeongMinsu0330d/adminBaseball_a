package com.example.adminbaseball.models;

public class GameVo {
    private int seq;
    private String dtPlayDate;
    private int nStadiumNo;
    private String strStadiumName;
    private int nHomeTeamNo;
    private int nAwayTeamNo;
    private String strHomeTeamName;
    private String strAwayTeamName;
    private String dtRegDate;

    public GameVo() {
    }

    public GameVo(int seq, String dtPlayDate, int nStadiumNo, String strStadiumName, int nHomeTeamNo, int nAwayTeamNo, String strHomeTeamName, String strAwayTeamName, String dtRegDate) {
        this.seq = seq;
        this.dtPlayDate = dtPlayDate;
        this.nStadiumNo = nStadiumNo;
        this.strStadiumName = strStadiumName;
        this.nHomeTeamNo = nHomeTeamNo;
        this.nAwayTeamNo = nAwayTeamNo;
        this.strHomeTeamName = strHomeTeamName;
        this.strAwayTeamName = strAwayTeamName;
        this.dtRegDate = dtRegDate;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public String getDtPlayDate() {
        return dtPlayDate;
    }

    public void setDtPlayDate(String dtPlayDate) {
        this.dtPlayDate = dtPlayDate;
    }

    public int getnStadiumNo() {
        return nStadiumNo;
    }

    public void setnStadiumNo(int nStadiumNo) {
        this.nStadiumNo = nStadiumNo;
    }

    public String getStrStadiumName() {
        return strStadiumName;
    }

    public void setStrStadiumName(String strStadiumName) {
        this.strStadiumName = strStadiumName;
    }

    public int getnHomeTeamNo() {
        return nHomeTeamNo;
    }

    public void setnHomeTeamNo(int nHomeTeamNo) {
        this.nHomeTeamNo = nHomeTeamNo;
    }

    public int getnAwayTeamNo() {
        return nAwayTeamNo;
    }

    public void setnAwayTeamNo(int nAwayTeamNo) {
        this.nAwayTeamNo = nAwayTeamNo;
    }

    public String getStrHomeTeamName() {
        return strHomeTeamName;
    }

    public void setStrHomeTeamName(String strHomeTeamName) {
        this.strHomeTeamName = strHomeTeamName;
    }

    public String getStrAwayTeamName() {
        return strAwayTeamName;
    }

    public void setStrAwayTeamName(String strAwayTeamName) {
        this.strAwayTeamName = strAwayTeamName;
    }

    public String getDtRegDate() {
        return dtRegDate;
    }

    public void setDtRegDate(String dtRegDate) {
        this.dtRegDate = dtRegDate;
    }
}

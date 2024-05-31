package com.example.adminbaseball;

public class TeamVo {

    private int nTeamNo;
    private String strTeamName;
    private int nStadiumNo;
    private String strStadiumName;
    private String strTeamImage;
    private String dtRegDate;

    public TeamVo() {}

    public TeamVo(int nTeamNo, String strTeamName, int nStadiumNo, String dtRegDate, String strTeamImage) {
        this.nTeamNo = nTeamNo;
        this.strTeamName = strTeamName;
        this.nStadiumNo = nStadiumNo;
        this.dtRegDate = dtRegDate;
        this.strTeamImage = strTeamImage;
    }

    public TeamVo(int nTeamNo, String strTeamName, int nStadiumNo, String strStadiumName, String strTeamImage, String dtRegDate) {
        this.nTeamNo = nTeamNo;
        this.strTeamName = strTeamName;
        this.nStadiumNo = nStadiumNo;
        this.strStadiumName = strStadiumName;
        this.strTeamImage = strTeamImage;
        this.dtRegDate = dtRegDate;
    }

    public String getStrStadiumName() {
        return strStadiumName;
    }

    public void setStrStadiumName(String strStadiumName) {
        this.strStadiumName = strStadiumName;
    }

    public String getStrTeamImage() {
        return strTeamImage;
    }

    public void setStrTeamImage(String strTeamImage) {
        this.strTeamImage = strTeamImage;
    }

    public String getDtRegDate() {
        return dtRegDate;
    }

    public void setDtRegDate(String dtRegDate) {
        this.dtRegDate = dtRegDate;
    }

    public int getnTeamNo() {
        return nTeamNo;
    }

    public void setnTeamNo(int nTeamNo) {
        this.nTeamNo = nTeamNo;
    }

    public String getStrTeamName() {
        return strTeamName;
    }

    public void setStrTeamName(String strTeamName) {
        this.strTeamName = strTeamName;
    }

    public int getnStadiumNo() {
        return nStadiumNo;
    }

    public void setnStadiumNo(int nStadiumNo) {
        this.nStadiumNo = nStadiumNo;
    }
}

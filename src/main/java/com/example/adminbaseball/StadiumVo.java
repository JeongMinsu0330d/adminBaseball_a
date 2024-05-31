package com.example.adminbaseball;

public class StadiumVo {
    private int nStadiumNo;
    private String strStadiumName;
    private String dtRegdate;

    public StadiumVo(){}

    public StadiumVo(int nStadiumNo, String strStadiumName) {
        this.nStadiumNo = nStadiumNo;
        this.strStadiumName = strStadiumName;
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

    public String getDtRegdate() {
        return dtRegdate;
    }

    public void setDtRegdate(String dtRegdate) {
        this.dtRegdate = dtRegdate;
    }
}

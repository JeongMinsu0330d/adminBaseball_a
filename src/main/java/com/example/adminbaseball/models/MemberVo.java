package com.example.adminbaseball.models;

public class MemberVo {

    private int nUserNo;
    private String dtRegDate;
    private String strUserEmail;

    public MemberVo(){}

    public MemberVo(int nUserNo, String dtRegDate, String strUserEmail) {
        this.nUserNo = nUserNo;
        this.dtRegDate = dtRegDate;
        this.strUserEmail = strUserEmail;
    }

    public int getnUserNo() {
        return nUserNo;
    }

    public void setnUserNo(int nUserNo) {
        this.nUserNo = nUserNo;
    }

    public String getDtRegDate() {
        return dtRegDate;
    }

    public void setDtRegDate(String dtRegDate) {
        this.dtRegDate = dtRegDate;
    }

    public String getStrUserEmail() {
        return strUserEmail;
    }

    public void setStrUserEmail(String strUserEmail) {
        this.strUserEmail = strUserEmail;
    }
}

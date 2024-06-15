package com.example.adminbaseball.admin_model;

public class StadiumPriceInfo {
    private int nStadiumNo;
    private String strSectionType;
    private String strAgeType;
    private String strDateType;
    private int nTicketPrice;
    private String section_no_list;

    public StadiumPriceInfo() {
    }

    public StadiumPriceInfo(int nStadiumNo, String strSectionType, String strAgeType, String strDateType, int nTicketPrice, String section_no_list) {
        this.nStadiumNo = nStadiumNo;
        this.strSectionType = strSectionType;
        this.strAgeType = strAgeType;
        this.strDateType = strDateType;
        this.nTicketPrice = nTicketPrice;
        this.section_no_list = section_no_list;
    }

    public int getnStadiumNo() {
        return nStadiumNo;
    }

    public void setnStadiumNo(int nStadiumNo) {
        this.nStadiumNo = nStadiumNo;
    }

    public String getStrSectionType() {
        return strSectionType;
    }

    public void setStrSectionType(String strSectionType) {
        this.strSectionType = strSectionType;
    }

    public String getStrAgeType() {
        return strAgeType;
    }

    public void setStrAgeType(String strAgeType) {
        this.strAgeType = strAgeType;
    }

    public String getStrDateType() {
        return strDateType;
    }

    public void setStrDateType(String strDateType) {
        this.strDateType = strDateType;
    }

    public int getnTicketPrice() {
        return nTicketPrice;
    }

    public void setnTicketPrice(int nTicketPrice) {
        this.nTicketPrice = nTicketPrice;
    }

    public String getSection_no_list() {
        return section_no_list;
    }

    public void setSection_no_list(String section_no_list) {
        this.section_no_list = section_no_list;
    }
}



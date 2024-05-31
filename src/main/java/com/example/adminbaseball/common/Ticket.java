package com.example.adminbaseball.common;

public class Ticket {
    private String section_type;
    private boolean isAgeType;
    private int Price1; // 주중
    private int Price2; // 주말

    public Ticket() {
    }

    public Ticket(String section_type, boolean isAgeType, int price1, int price2) {
        this.section_type = section_type;
        this.isAgeType = isAgeType;
        Price1 = price1;
        Price2 = price2;
    }

    public String getSection_type() {
        return section_type;
    }

    public void setSection_type(String section_type) {
        this.section_type = section_type;
    }

    public boolean isAgeType() {
        return isAgeType;
    }

    public void setAgeType(boolean ageType) {
        isAgeType = ageType;
    }

    public int getPrice1() {
        return Price1;
    }

    public void setPrice1(int price1) {
        Price1 = price1;
    }

    public int getPrice2() {
        return Price2;
    }

    public void setPrice2(int price2) {
        Price2 = price2;
    }
}
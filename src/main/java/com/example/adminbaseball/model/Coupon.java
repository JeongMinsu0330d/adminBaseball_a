package com.example.adminbaseball.model;

public class Coupon {
    private int seq;
    private String couponNo;
    private String couponName;
    private int discountPrice;

    public Coupon(){

    }
    public Coupon(String couponNo, String couponName, int discountPrice) {
        this.couponNo = couponNo;
        this.couponName = couponName;
        this.discountPrice = discountPrice;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public String getCouponNo() {
        return couponNo;
    }

    public void setCouponNo(String couponNo) {
        this.couponNo = couponNo;
    }

    public String getCouponName() {
        return couponName;
    }

    public void setCouponName(String couponName) {
        this.couponName = couponName;
    }

    public int getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(int discountPrice) {
        this.discountPrice = discountPrice;
    }
}

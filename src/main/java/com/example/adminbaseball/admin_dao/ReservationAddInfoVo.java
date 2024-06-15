package com.example.adminbaseball.admin_dao;

public class ReservationAddInfoVo {
    private int tradeId;
    private int TotalReservationTicket;
    private int commissionPrice;
    private int discountCouponPrice;
    private int pointPrice;
    private int totalPrice;
    private int realPrice;

    public ReservationAddInfoVo() {
    }

    public ReservationAddInfoVo(int tradeId, int totalReservationTicket, int commissionPrice, int discountCouponPrice, int pointPrice, int totalPrice, int realPrice) {
        this.tradeId = tradeId;
        TotalReservationTicket = totalReservationTicket;
        this.commissionPrice = commissionPrice;
        this.discountCouponPrice = discountCouponPrice;
        this.pointPrice = pointPrice;
        this.totalPrice = totalPrice;
        this.realPrice = realPrice;
    }

    public int getTradeId() {
        return tradeId;
    }

    public void setTradeId(int tradeId) {
        this.tradeId = tradeId;
    }

    public int getTotalReservationTicket() {
        return TotalReservationTicket;
    }

    public void setTotalReservationTicket(int totalReservationTicket) {
        TotalReservationTicket = totalReservationTicket;
    }

    public int getCommissionPrice() {
        return commissionPrice;
    }

    public void setCommissionPrice(int commissionPrice) {
        this.commissionPrice = commissionPrice;
    }

    public int getDiscountCouponPrice() {
        return discountCouponPrice;
    }

    public void setDiscountCouponPrice(int discountCouponPrice) {
        this.discountCouponPrice = discountCouponPrice;
    }

    public int getPointPrice() {
        return pointPrice;
    }

    public void setPointPrice(int pointPrice) {
        this.pointPrice = pointPrice;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getRealPrice() {
        return realPrice;
    }

    public void setRealPrice(int realPrice) {
        this.realPrice = realPrice;
    }
}

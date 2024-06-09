package com.example.adminbaseball.models;

public class MileageVo {

    private int seq;
    private int account_code;
    private int charge_object_seq;
    private int user_no;
    private int pay_price;
    private String mileage_type;
    private int fill_mileage;
    private int pay_commission;
    private int tid;
    private int mileage_cancel_flag;

    public MileageVo() {
    }



    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public int getAccount_code() {
        return account_code;
    }

    public void setAccount_code(int account_code) {
        this.account_code = account_code;
    }

    public int getCharge_object_seq() {
        return charge_object_seq;
    }

    public void setCharge_object_seq(int charge_object_seq) {
        this.charge_object_seq = charge_object_seq;
    }

    public int getUser_no() {
        return user_no;
    }

    public void setUser_no(int user_no) {
        this.user_no = user_no;
    }

    public int getPay_price() {
        return pay_price;
    }

    public void setPay_price(int pay_price) {
        this.pay_price = pay_price;
    }

    public String getMileage_type() {
        return mileage_type;
    }

    public void setMileage_type(String mileage_type) {
        this.mileage_type = mileage_type;
    }

    public int getFill_mileage() {
        return fill_mileage;
    }

    public void setFill_mileage(int fill_mileage) {
        this.fill_mileage = fill_mileage;
    }

    public int getPay_commission() {
        return pay_commission;
    }

    public void setPay_commission(int pay_commission) {
        this.pay_commission = pay_commission;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public int getMileage_cancel_flag() {
        return mileage_cancel_flag;
    }

    public void setMileage_cancel_flag(int mileage_cancel_flag) {
        this.mileage_cancel_flag = mileage_cancel_flag;
    }
}

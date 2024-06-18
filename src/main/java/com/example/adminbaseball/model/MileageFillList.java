package com.example.adminbaseball.model;

public class MileageFillList {
    private int seq;                        // 일련번호
    private String accountCode;             // 전자장부코드
    private int chargeObjectSeq;            // PG 충전 일련번호
    private int userNo;                     // 회원번호
    private int payPrice;                   // 결제금액
    private String mileageType;             // 마일리지 타입(m: 마일리지, p:포인트)
    private int fillMileage;                // 충전마일리지
    private int payCommission;              // 충전수수료
    private String tid;                     // PG상점 거래번호
    private String mileageCancelFlag;       // 마일리지 삭감 여부 (y:여, n:부)
    private String regDate;                 // 등록일시

    // 기본 생성자
    public MileageFillList() {
    }

    // 매개변수가 있는 생성자
    public MileageFillList(int seq, String accountCode, int chargeObjectSeq, int userNo, int payPrice, String mileageType, int fillMileage, int payCommission, String tid, String mileageCancelFlag, String regDate) {
        this.seq = seq;
        this.accountCode = accountCode;
        this.chargeObjectSeq = chargeObjectSeq;
        this.userNo = userNo;
        this.payPrice = payPrice;
        this.mileageType = mileageType;
        this.fillMileage = fillMileage;
        this.payCommission = payCommission;
        this.tid = tid;
        this.mileageCancelFlag = mileageCancelFlag;
        this.regDate = regDate;
    }

    // getter 및 setter 메소드
    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public String getAccountCode() {
        return accountCode;
    }

    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }

    public int getChargeObjectSeq() {
        return chargeObjectSeq;
    }

    public void setChargeObjectSeq(int chargeObjectSeq) {
        this.chargeObjectSeq = chargeObjectSeq;
    }

    public int getUserNo() {
        return userNo;
    }

    public void setUserNo(int userNo) {
        this.userNo = userNo;
    }

    public int getPayPrice() {
        return payPrice;
    }

    public void setPayPrice(int payPrice) {
        this.payPrice = payPrice;
    }

    public String getMileageType() {
        return mileageType;
    }

    public void setMileageType(String mileageType) {
        this.mileageType = mileageType;
    }

    public int getFillMileage() {
        return fillMileage;
    }

    public void setFillMileage(int fillMileage) {
        this.fillMileage = fillMileage;
    }

    public int getPayCommission() {
        return payCommission;
    }

    public void setPayCommission(int payCommission) {
        this.payCommission = payCommission;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getMileageCancelFlag() {
        return mileageCancelFlag;
    }

    public void setMileageCancelFlag(String mileageCancelFlag) {
        this.mileageCancelFlag = mileageCancelFlag;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    // toString 메소드
    @Override
    public String toString() {
        return "MileageFillList{" +
                "seq=" + seq +
                ", accountCode='" + accountCode + '\'' +
                ", chargeObjectSeq=" + chargeObjectSeq +
                ", userNo=" + userNo +
                ", payPrice=" + payPrice +
                ", mileageType='" + mileageType + '\'' +
                ", fillMileage=" + fillMileage +
                ", payCommission=" + payCommission +
                ", tid='" + tid + '\'' +
                ", mileageCancelFlag='" + mileageCancelFlag + '\'' +
                ", regDate='" + regDate + '\'' +
                '}';
    }
}

package com.example.adminbaseball.model;

public class MileageTransferList {
    private int seq;                        // 일련번호
    private int userNo;                     // 출금 일련번호
    private String accountCode;             // 전자장부코드
    private String transferType;            // 전환 상태(a:진행중, s:완료, f:실패)
    private String reciveType;              // 사이트 타입 (a:극장, b:콘서트, c:야구, d:숙박, e:기차)
    private String reciveUserEmail;         // 전환 유저 이메일
    private String mileageType;             // 마일리지 타입(m: 마일리지, p:포인트)
    private int mileage;                    // 결제마일리지
    private int transferMileage;            // 전환금액
    private int commission;                 // 결제수수료
    private int adminNo;                    // 관리자번호
    private String regDate;                 // 등록일시

    // 기본 생성자
    public MileageTransferList() {
    }

    // 매개변수가 있는 생성자
    public MileageTransferList(int seq, int userNo, String accountCode, String transferType, String reciveType, String reciveUserEmail, String mileageType, int mileage, int transferMileage, int commission, int adminNo, String regDate) {
        this.seq = seq;
        this.userNo = userNo;
        this.accountCode = accountCode;
        this.transferType = transferType;
        this.reciveType = reciveType;
        this.reciveUserEmail = reciveUserEmail;
        this.mileageType = mileageType;
        this.mileage = mileage;
        this.transferMileage = transferMileage;
        this.commission = commission;
        this.adminNo = adminNo;
        this.regDate = regDate;
    }

    // getter 및 setter 메소드
    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public int getUserNo() {
        return userNo;
    }

    public void setUserNo(int userNo) {
        this.userNo = userNo;
    }

    public String getAccountCode() {
        return accountCode;
    }

    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }

    public String getTransferType() {
        return transferType;
    }

    public void setTransferType(String transferType) {
        this.transferType = transferType;
    }

    public String getReciveType() {
        return reciveType;
    }

    public void setReciveType(String reciveType) {
        this.reciveType = reciveType;
    }

    public String getReciveUserEmail() {
        return reciveUserEmail;
    }

    public void setReciveUserEmail(String reciveUserEmail) {
        this.reciveUserEmail = reciveUserEmail;
    }

    public String getMileageType() {
        return mileageType;
    }

    public void setMileageType(String mileageType) {
        this.mileageType = mileageType;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public int getTransferMileage() {
        return transferMileage;
    }

    public void setTransferMileage(int transferMileage) {
        this.transferMileage = transferMileage;
    }

    public int getCommission() {
        return commission;
    }

    public void setCommission(int commission) {
        this.commission = commission;
    }

    public int getAdminNo() {
        return adminNo;
    }

    public void setAdminNo(int adminNo) {
        this.adminNo = adminNo;
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
        return "MileageTransferList{" +
                "seq=" + seq +
                ", userNo=" + userNo +
                ", accountCode='" + accountCode + '\'' +
                ", transferType='" + transferType + '\'' +
                ", reciveType='" + reciveType + '\'' +
                ", reciveUserEmail='" + reciveUserEmail + '\'' +
                ", mileageType='" + mileageType + '\'' +
                ", mileage=" + mileage +
                ", transferMileage=" + transferMileage +
                ", commission=" + commission +
                ", adminNo=" + adminNo +
                ", regDate='" + regDate + '\'' +
                '}';
    }
}

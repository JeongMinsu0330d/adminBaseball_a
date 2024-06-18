package com.example.adminbaseball.model;

public class MileageDetailList {
    private int seq;                        // 일련번호
    private int userNo;                     // 회원번호
    private String accountCode;             // 전자장부코드
    private long objectSeq;                 // 적립 일련번호 (BIGINT : 거래번호, INT : PG 충전)
    private String mileageType;             // 마일리지 타입(m: 마일리지, p:포인트)
    private int mileage;                    // 마일리지
    private int remainMileage;              // 잔여 마일리지
    private String activeDate;              // 최근 변동 일시 (지급 및 사용 일시)
    private String usedAllFlag;             // 마일리지 모두 사용 여부 (y:여, n:부)
    private int adminNo;                    // 관리자번호
    private String regDate;                 // 등록일시

    // 기본 생성자
    public MileageDetailList() {
    }

    // 매개변수가 있는 생성자
    public MileageDetailList(int seq, int userNo, String accountCode, long objectSeq, String mileageType, int mileage, int remainMileage, String activeDate, String usedAllFlag, int adminNo, String regDate) {
        this.seq = seq;
        this.userNo = userNo;
        this.accountCode = accountCode;
        this.objectSeq = objectSeq;
        this.mileageType = mileageType;
        this.mileage = mileage;
        this.remainMileage = remainMileage;
        this.activeDate = activeDate;
        this.usedAllFlag = usedAllFlag;
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

    public long getObjectSeq() {
        return objectSeq;
    }

    public void setObjectSeq(long objectSeq) {
        this.objectSeq = objectSeq;
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

    public int getRemainMileage() {
        return remainMileage;
    }

    public void setRemainMileage(int remainMileage) {
        this.remainMileage = remainMileage;
    }

    public String getActiveDate() {
        return activeDate;
    }

    public void setActiveDate(String activeDate) {
        this.activeDate = activeDate;
    }

    public String getUsedAllFlag() {
        return usedAllFlag;
    }

    public void setUsedAllFlag(String usedAllFlag) {
        this.usedAllFlag = usedAllFlag;
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
        return "MileageDetailList{" +
                "seq=" + seq +
                ", userNo=" + userNo +
                ", accountCode='" + accountCode + '\'' +
                ", objectSeq=" + objectSeq +
                ", mileageType='" + mileageType + '\'' +
                ", mileage=" + mileage +
                ", remainMileage=" + remainMileage +
                ", activeDate='" + activeDate + '\'' +
                ", usedAllFlag='" + usedAllFlag + '\'' +
                ", adminNo=" + adminNo +
                ", regDate='" + regDate + '\'' +
                '}';
    }
}

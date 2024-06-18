package com.example.adminbaseball.model;
public class MileageChangeList {
    private int seq;                // 일련번호
    private long objectSeq;         // 적립 일련번호 (BIGINT : 거래번호, INT : 사용 일련번호 (충전, 출금, 발행 등))
    private int userNo;             // 회원번호
    private String changeType;      // 마일리지 변동 분류 ([증가] = a:충전, b:적립, c:환불, d:전환 / [감소] =  e:구매, f:전환)
    private String accountCode;     // 전자장부코드
    private int previousMileage;    // 이전 마일리지
    private int mileage;            // 변동 마일리지
    private int nextMileage;        // 이후 마일리지
    private String changeComment;   // 변동내역
    private String changeState;     // 변동 상태 (i:진행중, s:완료, c:취소)
    private int adminNo;            // 관리자 번호
    private String regDate;         // 등록일시

    // 기본 생성자
    public MileageChangeList() {
    }

    // 매개변수가 있는 생성자
    public MileageChangeList(int seq, long objectSeq, int userNo, String changeType, String accountCode, int previousMileage, int mileage, int nextMileage, String changeComment, String changeState, int adminNo, String regDate) {
        this.seq = seq;
        this.objectSeq = objectSeq;
        this.userNo = userNo;
        this.changeType = changeType;
        this.accountCode = accountCode;
        this.previousMileage = previousMileage;
        this.mileage = mileage;
        this.nextMileage = nextMileage;
        this.changeComment = changeComment;
        this.changeState = changeState;
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

    public long getObjectSeq() {
        return objectSeq;
    }

    public void setObjectSeq(long objectSeq) {
        this.objectSeq = objectSeq;
    }

    public int getUserNo() {
        return userNo;
    }

    public void setUserNo(int userNo) {
        this.userNo = userNo;
    }

    public String getChangeType() {
        return changeType;
    }

    public void setChangeType(String changeType) {
        this.changeType = changeType;
    }

    public String getAccountCode() {
        return accountCode;
    }

    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }

    public int getPreviousMileage() {
        return previousMileage;
    }

    public void setPreviousMileage(int previousMileage) {
        this.previousMileage = previousMileage;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public int getNextMileage() {
        return nextMileage;
    }

    public void setNextMileage(int nextMileage) {
        this.nextMileage = nextMileage;
    }

    public String getChangeComment() {
        return changeComment;
    }

    public void setChangeComment(String changeComment) {
        this.changeComment = changeComment;
    }

    public String getChangeState() {
        return changeState;
    }

    public void setChangeState(String changeState) {
        this.changeState = changeState;
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
        return "MileageChangeList{" +
                "seq=" + seq +
                ", objectSeq=" + objectSeq +
                ", userNo=" + userNo +
                ", changeType='" + changeType + '\'' +
                ", accountCode='" + accountCode + '\'' +
                ", previousMileage=" + previousMileage +
                ", mileage=" + mileage +
                ", nextMileage=" + nextMileage +
                ", changeComment='" + changeComment + '\'' +
                ", changeState='" + changeState + '\'' +
                ", adminNo=" + adminNo +
                ", regDate='" + regDate + '\'' +
                '}';
    }
}

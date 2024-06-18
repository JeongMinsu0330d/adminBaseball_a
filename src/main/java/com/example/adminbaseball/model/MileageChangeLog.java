package com.example.adminbaseball.model;

public class MileageChangeLog {
    private int seq;                         // 일련번호
    private int mileageDetailLogSeq;         // 마일리지 상세 로그 일련번호
    private int mileageChangeListSeq;        // 회원 마일리지 변동 리스트 일련번호
    private String changeType;               // 마일리지 변동 분류 ([증가] = a:충전, b:적립, c:환불, d:전환 / [감소] = e:구매, f:전환)
    private String accountCode;              // 전자장부코드
    private int userNo;                      // 회원번호
    private int mileage;                     // 마일리지
    private String manualFlag;               // 수동처리 여부 (y:관리자, n:시스템)
    private int adminNo;                     // 관리자번호
    private String regDate;                  // 등록일시

    // 기본 생성자
    public MileageChangeLog() {
    }

    // 매개변수가 있는 생성자
    public MileageChangeLog(int seq, int mileageDetailLogSeq, int mileageChangeListSeq, String changeType, String accountCode, int userNo, int mileage, String manualFlag, int adminNo, String regDate) {
        this.seq = seq;
        this.mileageDetailLogSeq = mileageDetailLogSeq;
        this.mileageChangeListSeq = mileageChangeListSeq;
        this.changeType = changeType;
        this.accountCode = accountCode;
        this.userNo = userNo;
        this.mileage = mileage;
        this.manualFlag = manualFlag;
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

    public int getMileageDetailLogSeq() {
        return mileageDetailLogSeq;
    }

    public void setMileageDetailLogSeq(int mileageDetailLogSeq) {
        this.mileageDetailLogSeq = mileageDetailLogSeq;
    }

    public int getMileageChangeListSeq() {
        return mileageChangeListSeq;
    }

    public void setMileageChangeListSeq(int mileageChangeListSeq) {
        this.mileageChangeListSeq = mileageChangeListSeq;
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

    public int getUserNo() {
        return userNo;
    }

    public void setUserNo(int userNo) {
        this.userNo = userNo;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public String getManualFlag() {
        return manualFlag;
    }

    public void setManualFlag(String manualFlag) {
        this.manualFlag = manualFlag;
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
        return "MileageChangeLog{" +
                "seq=" + seq +
                ", mileageDetailLogSeq=" + mileageDetailLogSeq +
                ", mileageChangeListSeq=" + mileageChangeListSeq +
                ", changeType='" + changeType + '\'' +
                ", accountCode='" + accountCode + '\'' +
                ", userNo=" + userNo +
                ", mileage=" + mileage +
                ", manualFlag='" + manualFlag + '\'' +
                ", adminNo=" + adminNo +
                ", regDate='" + regDate + '\'' +
                '}';
    }
}

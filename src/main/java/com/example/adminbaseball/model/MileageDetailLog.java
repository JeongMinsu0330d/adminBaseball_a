package com.example.adminbaseball.model;

public class MileageDetailLog {
    private int seq;                        // 일련번호
    private int mileageDetailListSeq;       // 마일리지 적립 리스트 일련번호
    private long objectSeq;                 // 적립 일련번호 (BIGINT : 거래번호, INT : 사용 일련번호 (충전, 전환))
    private String accountCode;             // 전자장부코드
    private int userNo;                     // 회원번호
    private String detailLogType;           // 상세로그 분류(a:적립, b:사용)
    private int mileage;                    // 적립 및 사용 마일리지
    private String detailLogState;          // 마일리지 상세 상태 (i:진행중, s:완료, c:취소)
    private String regDate;                 // 등록일시

    // 기본 생성자
    public MileageDetailLog() {
    }

    // 매개변수가 있는 생성자
    public MileageDetailLog(int seq, int mileageDetailListSeq, long objectSeq, String accountCode, int userNo, String detailLogType, int mileage, String detailLogState, String regDate) {
        this.seq = seq;
        this.mileageDetailListSeq = mileageDetailListSeq;
        this.objectSeq = objectSeq;
        this.accountCode = accountCode;
        this.userNo = userNo;
        this.detailLogType = detailLogType;
        this.mileage = mileage;
        this.detailLogState = detailLogState;
        this.regDate = regDate;
    }

    // getter 및 setter 메소드
    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public int getMileageDetailListSeq() {
        return mileageDetailListSeq;
    }

    public void setMileageDetailListSeq(int mileageDetailListSeq) {
        this.mileageDetailListSeq = mileageDetailListSeq;
    }

    public long getObjectSeq() {
        return objectSeq;
    }

    public void setObjectSeq(long objectSeq) {
        this.objectSeq = objectSeq;
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

    public String getDetailLogType() {
        return detailLogType;
    }

    public void setDetailLogType(String detailLogType) {
        this.detailLogType = detailLogType;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public String getDetailLogState() {
        return detailLogState;
    }

    public void setDetailLogState(String detailLogState) {
        this.detailLogState = detailLogState;
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
        return "MileageDetailLog{" +
                "seq=" + seq +
                ", mileageDetailListSeq=" + mileageDetailListSeq +
                ", objectSeq=" + objectSeq +
                ", accountCode='" + accountCode + '\'' +
                ", userNo=" + userNo +
                ", detailLogType='" + detailLogType + '\'' +
                ", mileage=" + mileage +
                ", detailLogState='" + detailLogState + '\'' +
                ", regDate='" + regDate + '\'' +
                '}';
    }
}

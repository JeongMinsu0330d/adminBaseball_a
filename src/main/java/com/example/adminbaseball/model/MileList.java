package com.example.adminbaseball.model;

public class MileList {
    private int userNo;        // 회원번호
    private int mileage;       // 마일리지
    private String mileageType; // 마일리지 타입 (m:마일리지, p:포인트)
    private String updateDate; // 최종 변경시간

    // 기본 생성자
    public MileList() {
    }

    // 매개변수가 있는 생성자
    public MileList(int userNo, int mileage, String mileageType, String updateDate) {
        this.userNo = userNo;
        this.mileage = mileage;
        this.mileageType = mileageType;
        this.updateDate = updateDate;
    }

    // getter 및 setter 메소드
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

    public String getMileageType() {
        return mileageType;
    }

    public void setMileageType(String mileageType) {
        this.mileageType = mileageType;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    // toString 메소드
    @Override
    public String toString() {
        return "MileageList{" +
                "userNo=" + userNo +
                ", mileage=" + mileage +
                ", mileageType='" + mileageType + '\'' +
                ", updateDate='" + updateDate + '\'' +
                '}';
    }
}

package com.example.adminbaseball.common;

public class ClassifyStadium {

    // section type -> section name
    public String fnTransferSectionType(String chrSectionType){
        String strSectionName="";
        switch (chrSectionType){
            case "a":
                strSectionName = "프리미엄";
                break;
            case "b":
                strSectionName = "테이블";
                break;
            case "c":
                strSectionName = "익사이팅";
                break;
            case "d":
                strSectionName = "블루";
                break;
            case "e":
                strSectionName = "오렌지";
                break;
            case "f":
                strSectionName = "레드";
                break;
            case "g":
                strSectionName = "네이비";
                break;
            case "h":
                strSectionName = "외야석";
                break;
            case "i":
                strSectionName = "휠체어 블루";
                break;
            case "j":
                strSectionName = "휠체어 레드";
                break;
            default:
                strSectionName = "존재하지 않는 타입";
                break;

        }

        return strSectionName;
    }




}

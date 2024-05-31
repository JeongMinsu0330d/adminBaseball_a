package com.example.adminbaseball.common;
import com.google.gson.Gson;

public class DataConverter {

    // JSON 문자열을 모델 객체로 변환하는 메서드
    public static Section[] convertJsonToModel(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, Section[].class);
    }

    // 모델 객체를 JSON 문자열로 변환하는 메서드
    public static String convertModelToJson(Section[] sections) {
        Gson gson = new Gson();
        return gson.toJson(sections);
    }

    public static Ticket[] convertJsonToModelToTicket(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, Ticket[].class);
    }
    public static String convertModelToJsonToTicket(Ticket[] tickets) {
        Gson gson = new Gson();
        return gson.toJson(tickets);
    }

}
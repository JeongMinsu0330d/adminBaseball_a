package com.example.adminbaseball.common;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class DateFunction {

    public String[] fnGetWeekly() {
        // 현재 날짜 가져오기
        LocalDate today = LocalDate.now();

        // 현재 주의 일요일 날짜 구하기
        LocalDate sunday = today.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));

        // 결과 출력
        System.out.println("Today: " + today);
        System.out.println("Sunday: " + sunday);

        String date1 = today.toString();
        String date2 = sunday.toString();
        String[] date = {date1,date2};

        return date;
    }

    public void fnGetWeekType(){
         LocalDate today = LocalDate.now();

        // 오늘의 요일 가져오기
        DayOfWeek dayOfWeek = today.getDayOfWeek();

        // 결과 출력
        System.out.println("Today: " + today);
        System.out.println("Day of the Week: " + dayOfWeek);


    }


}

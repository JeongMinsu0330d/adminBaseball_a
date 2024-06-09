package com.example.adminbaseball.models;

public class ReservationDetailVo {
    private int seq;
    private int userNo;
    private int tradeId;
    private String ageType;
    private int stadiumNo;
    private String stadiumName;





}

// `seq` int unsigned NOT NULL AUTO_INCREMENT COMMENT '일련번호',
//  `user_no` int unsigned NOT NULL COMMENT '회원번호',
//  `trade_id` bigint unsigned NOT NULL COMMENT '거래번호',
//  `age_type` char(1) NOT NULL COMMENT '나이 구분값 (a:일반, b:만 6세 이상 ~ 만 12세 미만, c:만 6세 미만)',
//  `stadium_no` int unsigned NOT NULL COMMENT '경기장 번호',
//  `stadium_name` varchar(30) NOT NULL COMMENT '경기장명',
//  `home_team_no` int unsigned NOT NULL COMMENT '홈팀 번호',
//  `home_team_name` varchar(15) NOT NULL COMMENT '홈팀 명',
//  `away_team_no` int unsigned NOT NULL COMMENT '어웨이팀 번호',
//  `away_team_name` varchar(15) NOT NULL COMMENT '어웨이팀 명',
//  `game_list_seq` int unsigned NOT NULL COMMENT '게임 내역 일련번호',
//  `stadium_seat_list_seq` int unsigned NOT NULL COMMENT '경기장 좌석 일련번호',
//  `seat_no` tinyint unsigned NOT NULL COMMENT '좌석번호',
//  `reservation_state` char(1) NOT NULL DEFAULT 'b' COMMENT '예매 상태 (a:예매, b:예매중, c:예매 취소)',
//  `object_seq` int unsigned NOT NULL DEFAULT '0' COMMENT '보호자의 경우 보호대상 예매 일련번호',
//  `total_price` int unsigned NOT NULL COMMENT '최종 티켓 금액',
//  `ticket_type` char(1) NOT NULL COMMENT '권종 (a:일반, b:아동, c:유아)',
//  `ticket_price` int unsigned NOT NULL COMMENT '티켓 금액',
//  `discount_code` char(3) NOT NULL DEFAULT '' COMMENT '할인코드',
//  `discount_price` int unsigned NOT NULL DEFAULT '0' COMMENT '할인 금액',
//  `admin_no` int unsigned NOT NULL DEFAULT '0' COMMENT '관리자번호',
//  `reg_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '등록일시',

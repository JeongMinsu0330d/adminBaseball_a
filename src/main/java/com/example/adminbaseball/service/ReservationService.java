package com.example.adminbaseball.service;

import com.example.adminbaseball.common.JDBCconnection;
import com.example.adminbaseball.model.Reservation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReservationService {

    public List<Reservation> fnGetReservationList(int userNo){
        System.out.println("예매내역 조회");
        JDBCconnection jdbc = new JDBCconnection();
        Connection conn = jdbc.CBaseBallMaster;

        PreparedStatement pstmt = null;
        PreparedStatement pstmt1 = null;
        PreparedStatement pstmt2 = null;

        ResultSet rs = null;
        ResultSet rs1 = null;
        ResultSet rs2 = null;

        List<Reservation> reservations = new ArrayList<>();

        String qrySELECTReservation = "SELECT a.trade_id, a.stadium_name, a.home_team_name, a.away_team_name, a.reservation_state, a.reservation_price, a.payment_method, g.play_date   FROM baseball_reservation_list as a LEFT JOIN baseball_game_list as g on(a.game_list_seq = g.seq) WHERE a.user_no = ? order by a.reg_date desc;";

        try{
            pstmt = conn.prepareStatement(qrySELECTReservation);
            pstmt.setInt(1,userNo);
            rs = pstmt.executeQuery();

            while(rs.next()){
                Reservation reservation = new Reservation();

                reservation.setTradeId(rs.getLong("trade_id"));
                reservation.setStadiumName(rs.getString("stadium_name"));
                reservation.setHomeTeamName(rs.getString("home_team_name"));
                reservation.setAwayTeamName(rs.getString("away_team_name"));
                reservation.setReservationState(rs.getString("reservation_state"));
                reservation.setPaymentMethod(rs.getString("payment_method"));
                reservation.setReservationPrice(rs.getInt("reservation_price"));
                reservation.setPlayDate(rs.getString("play_date"));

                String qrySelectReservationDetail = "SELECT count(*) as cnt_reservation, stadium_seat_section_no as section_no, GROUP_CONCAT(seat_no SEPARATOR ', ') as seat_no FROM baseball_reservation_detail_list WHERE trade_id = ? GROUP BY trade_id, stadium_no, stadium_seat_section_no ";

                pstmt1 = conn.prepareStatement(qrySelectReservationDetail);
                pstmt1.setLong(1,reservation.getTradeId());

                rs1 = pstmt1.executeQuery();
                String seatInfo = "";
                int countReservation = 0;
                while(rs1.next()){
                    countReservation += rs1.getInt("cnt_reservation");
                    seatInfo += rs1.getString("section_no") + " : " + rs1.getString("seat_no") + "  ";

                }
                reservation.setCountReservation(countReservation);
                reservation.setSeatInfo(seatInfo);


                reservations.add(reservation);
            }

            return reservations;
        }catch(SQLException e){
            e.printStackTrace();

            return null;
        }
    }



}

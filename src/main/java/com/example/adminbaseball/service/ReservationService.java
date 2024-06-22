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
        Connection CBaseballDbMaster = jdbc.CBaseBallMaster;

        PreparedStatement pstmtReservation = null;
        PreparedStatement pstmReservationDetail = null;

        ResultSet rsReservation = null;
        ResultSet rsReservationDetail = null;

        List<Reservation> reservations = new ArrayList<>();

        String qrySelectReservation = "SELECT a.trade_id, a.stadium_name, a.home_team_name, a.away_team_name, a.reservation_state, a.reservation_price, a.payment_method, g.play_date   FROM baseball_reservation_list as a LEFT JOIN baseball_game_list as g on(a.game_list_seq = g.seq) WHERE a.user_no = ? order by a.reg_date desc;";

        try{
            pstmtReservation = CBaseballDbMaster.prepareStatement(qrySelectReservation);
            pstmtReservation.setInt(1,userNo);
            rsReservation = pstmtReservation.executeQuery();

            while(rsReservation.next()){
                Reservation reservation = new Reservation();

                reservation.setTradeId(rsReservation.getLong("trade_id"));
                reservation.setStadiumName(rsReservation.getString("stadium_name"));
                reservation.setHomeTeamName(rsReservation.getString("home_team_name"));
                reservation.setAwayTeamName(rsReservation.getString("away_team_name"));
                reservation.setReservationState(rsReservation.getString("reservation_state"));
                reservation.setPaymentMethod(rsReservation.getString("payment_method"));
                reservation.setReservationPrice(rsReservation.getInt("reservation_price"));
                reservation.setPlayDate(rsReservation.getString("play_date"));

                String qrySelectReservationDetail = "SELECT count(*) as cnt_reservation, stadium_seat_section_no as section_no, GROUP_CONCAT(seat_no SEPARATOR ', ') as seat_no FROM baseball_reservation_detail_list WHERE trade_id = ? GROUP BY trade_id, stadium_no, stadium_seat_section_no ";

                pstmReservationDetail = CBaseballDbMaster.prepareStatement(qrySelectReservationDetail);
                pstmReservationDetail.setLong(1,reservation.getTradeId());

                rsReservationDetail = pstmReservationDetail.executeQuery();
                String seatInfo = "";
                int countReservation = 0;

                while(rsReservationDetail.next()){
                    countReservation += rsReservationDetail.getInt("cnt_reservation");
                    seatInfo += rsReservationDetail.getString("section_no") + " : " + rsReservationDetail.getString("seat_no") + "  ";

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

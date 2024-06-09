package com.example.adminbaseball.DAO;

import com.example.adminbaseball.common.JDBCconnection;
import com.example.adminbaseball.models.GameVo;
import com.example.adminbaseball.models.ReservationDetailVo;
import com.example.adminbaseball.models.ReservationVo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReservationDAO extends JDBCconnection {
    public List<ReservationVo> getAllReservation() throws SQLException {
        List<ReservationVo> reservations = new ArrayList<>();
        String qrySelectReservation = "SELECT trade_id, user_no, game_list_seq, stadium_no, stadium_name, home_team_no, home_team_name, away_team_no, away_team_name, payment_method, reservation_state, reservation_price, reg_date FROM baseball_reservation_list";

        psmt = CBaseBallMaster.prepareStatement(qrySelectReservation);
        rs = psmt.executeQuery();

        while(rs.next()){
            ReservationVo reservationVo = new ReservationVo();
            reservationVo.setTradeId(rs.getInt("trade_id"));
            reservationVo.setUserNo(rs.getInt("user_no"));
            reservationVo.setGameCode(rs.getInt("game_list_seq"));
            reservationVo.setStadiumNo(rs.getInt("stadium_no"));
            reservationVo.setStadiumName(rs.getString("stadium_name"));
            reservationVo.setHomeTeamNo(rs.getInt("home_team_no"));
            reservationVo.setHomeTeamName(rs.getString("home_team_name"));
            reservationVo.setAwayTeamNo(rs.getInt("away_team_no"));
            reservationVo.setAwayTeamName(rs.getString("away_team_name"));
            reservationVo.setPaymentMethod(rs.getString("payment_method"));
            reservationVo.setReservationState(rs.getString("reservation_state").charAt(0));
            reservationVo.setReservationPrice(rs.getInt("reservation_price"));
            reservationVo.setRegDate(rs.getString("reg_date"));

            reservations.add(reservationVo);
        }

        return reservations;
    }

    public List<ReservationDetailVo> getAllReservationDetail(int tradeId){
        String message = "";
        List<ReservationDetailVo> reservationDetails = new ArrayList<>();
        String qrySelectReservationDetailByTradeId =
                "SELECT * FROM baseball_reservation_detail WHERE trade_id = ?";

        try{
            psmt = CBaseBallMaster.prepareStatement(qrySelectReservationDetailByTradeId);
            psmt.setInt(1,tradeId);

            rs = psmt.executeQuery();
            while(rs.next()){


            }

        }catch(SQLException e){
            message = "마일리지 상세 정보 조회 실패 \n 거래 번호 : " + tradeId;
            e.printStackTrace();
        }catch(Exception e){

        }

        return null;
    }





}

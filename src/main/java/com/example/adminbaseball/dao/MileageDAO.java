package com.example.adminbaseball.dao;

import com.example.adminbaseball.common.ResultModel;
import com.example.adminbaseball.model.MileList;
import com.example.adminbaseball.model.MileageFillList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MileageDAO {

    ResultModel resultModel;

    private Connection conn;
    private PreparedStatement psmt;
    private ResultSet rs;

    public MileageDAO(Connection conn) {
        this.conn = conn;
    }
// mileage_list (for_lock)
    public MileList getMileageList(int userNo, String mileType){
        String qrySelectMileageList = "select user_no, mileage from mileage_list WHERE user_no = ? AND mileage_type = ? FOR UPDATE";
        MileList mileageList = new MileList();

        try{
            psmt = conn.prepareStatement(qrySelectMileageList);
            psmt.setInt(1, userNo);
            psmt.setString(2, mileType);

            if(rs.next()){
//                현재 보유 마일리지
                mileageList.setUserNo(rs.getInt("user_no"));
                mileageList.setMileage(rs.getInt("mileage"));
            }

            return mileageList;
        }catch(SQLException e){
            try{
                conn.rollback();
            }catch(SQLException e2){
                e2.printStackTrace();
            }finally {
                return null;
            }
        }catch(Exception e){
            return null;
        }

    }

    public ResultModel setMileageFill(MileageFillList mileageFlFillList){
        String qryInsertMileageFill = "INSERT INTO `mileage_fill_list` (`account_code`, `charge_object_seq`, `user_no`, `pay_price`, `mileage_type`, `fill_mileage`, `pay_commission`, `tid`, `mileage_cancel_flag`) " +
                "VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ? );";

        ResultModel resultModel = new ResultModel();

        try{
            psmt = conn.prepareStatement(qryInsertMileageFill);
            psmt.setString(1, mileageFlFillList.getAccountCode());
            psmt.setInt(2, mileageFlFillList.getChargeObjectSeq());
            psmt.setInt(3, mileageFlFillList.getUserNo());
            psmt.setInt(4, mileageFlFillList.getPayPrice());
            psmt.setString(5, mileageFlFillList.getMileageType());
            psmt.setInt(6, mileageFlFillList.getFillMileage());
            psmt.setInt(7, mileageFlFillList.getPayCommission());
            psmt.setString(8, mileageFlFillList.getTid());
            psmt.setString(9, mileageFlFillList.getMileageCancelFlag());

            int affectedRow = psmt.executeUpdate();
            if(affectedRow <= 0){
                throw new SQLException("[mileage_fill]생성 에러");
            }
            resultModel.setCode("1");
            resultModel.setMessage("마일리지 충전 성공");

            return resultModel;
        }catch(SQLException e){
            resultModel.setCode("ERR01");
            resultModel.setMessage("마일리지 충전 실패");

            return resultModel;
        }

    }


}

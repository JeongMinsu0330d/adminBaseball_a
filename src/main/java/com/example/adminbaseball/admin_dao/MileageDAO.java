package com.example.adminbaseball.admin_dao;

import com.example.adminbaseball.common.JDBCconnection;
import com.example.adminbaseball.admin_model.MileageVo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MileageDAO extends JDBCconnection {

    List<MileageVo> mileage = new ArrayList<>();

    public MileageVo getMileage(int userNo) {

        String qrySelectMileageByUserNo = "SELECT * FROM mileage_fill_list WHERE user_no = ? ";

        try{
        psmt = CBaseBallMaster.prepareStatement(qrySelectMileageByUserNo);
        psmt.setInt(1,userNo);

        rs = psmt.executeQuery();

        while(rs.next()){


        }

        }catch(SQLException e){
            System.out.println("DB_Error: 마일리지 조회 실패");
            e.printStackTrace();
        }

        return null;
    }

    public MileageVo fnInsertMileage(MileageVo mileage) {
        String qryInsertMileage = "INSERT INTO mileage_fill_list (account_code, charge_object_seq, user_no, pay_price, mileage_type, fill_mileage, pay_commission, tid, mileage_cancel_flag)" +
                " VALUES (?,?,?,?,?,?,?,?,?)";

        MileageVo mileageVo = mileage;
        //마일리지 충전


//         포인트 충전 정합성

        try{
            if(mileageVo.getMileage_type().equals('m')){
                System.out.println(mileageVo.getMileage_type());
            }else if(mileageVo.getMileage_type().equals('p')){

            }else {
                throw new Exception("e");
            }



            psmt = CBaseBallMaster.prepareStatement(qryInsertMileage);



            rs = psmt.executeQuery();

            while(rs.next()){


            }

        }catch(SQLException e){
            System.out.println("DB_Error: 마일리지 조회 실패");
            e.printStackTrace();


        }catch(Exception e){
            e.printStackTrace();
        }



        return null;
    }

}

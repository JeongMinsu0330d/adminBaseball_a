package com.example.adminbaseball.service;

import com.example.adminbaseball.common.JDBCconnection;
import com.example.adminbaseball.common.ResultModel;
import com.example.adminbaseball.dao.MileageDAO;
import com.example.adminbaseball.model.MileageFillList;

import java.sql.SQLException;

public class MileageService {

    public void chargeMileage(){
        JDBCconnection jdbc = new JDBCconnection();
        ResultModel resultModel = new ResultModel();
        String accountCode = "";
        int payPrice;  // 결제 금액
        String mileageType = "m"; // 마일리지 타입 m: 마일리지, p: 포인트
        int fillMileage = 0; // 충전 마일리지
        int commissionPrice = 0; // 수수료 금액

        MileageFillList mileageFillList = new MileageFillList();
        // 정합성 체크
        try {
            jdbc.CBaseBallMaster.setAutoCommit(false);
            // 보유 마일리지 체크
            MileageDAO mileageDao = new MileageDAO(jdbc.CBaseBallMaster);
            // mileage_fill 충전
            mileageDao.setMileageFill(mileageFillList);

            // mileage

            // mileageFill -> mileage_list -> mileageDetailList -> mileageDetailLog -> mileageChangeList -> mileageChangeLog


            jdbc.CBaseBallMaster.commit();
        }catch(SQLException e) {
            try{
                jdbc.CBaseBallMaster.rollback();
            }catch(SQLException e1){
                e1.printStackTrace();
            }
        }catch(Exception e){

        }

    }



}

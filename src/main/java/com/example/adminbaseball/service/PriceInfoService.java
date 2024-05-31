package com.example.adminbaseball.service;

import com.example.adminbaseball.common.JDBCconnection;
import com.example.adminbaseball.models.StadiumPriceInfo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PriceInfoService extends JDBCconnection {

    public List<StadiumPriceInfo> getAllPriceInfoToStadiumNo(int nStadiumNo){
        List<StadiumPriceInfo> priceInfos = new ArrayList<>();

        String qrySelectPriceInfo = "SELECT a.stadium_no,a.section_type, a.ticket_age_type,a.ticket_date_type, a.ticket_price, b.section_no_list FROM stadium_seat_price_info as a JOIN (SELECT stadium_no,section_type,group_concat(distinct section_no) as section_no_list FROM stadium_seat_list WHERE stadium_no = ? GROUP BY section_type ) as b USING(stadium_no,section_type) WHERE a.stadium_no = ?;";
        try{
            psmt = CBaseBallMaster.prepareStatement(qrySelectPriceInfo);
            psmt.setInt(1,nStadiumNo);
            psmt.setInt(2,nStadiumNo);

            rs = psmt.executeQuery();

            while(rs.next()){
                StadiumPriceInfo price = new StadiumPriceInfo();
                price.setnStadiumNo(rs.getInt("stadium_no"));
                price.setStrSectionType(rs.getString("section_type"));
                price.setStrAgeType(rs.getString("ticket_age_type"));
                price.setStrDateType(rs.getString("ticket_date_type"));
                price.setnTicketPrice(rs.getInt("ticket_price"));
                price.setSection_no_list(rs.getString("section_no_list"));
                priceInfos.add(price);
            }
            return priceInfos;
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }






}

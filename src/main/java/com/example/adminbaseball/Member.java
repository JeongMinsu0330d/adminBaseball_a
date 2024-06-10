package com.example.adminbaseball;

import com.example.adminbaseball.common.JDBCconnection;
import com.example.adminbaseball.models.MemberVo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Member extends JDBCconnection {

    public List<MemberVo> getReservationList(int page) throws SQLException {
        int nUserNo;
        String dtRegDate;
        String strUserEmail;

        List<MemberVo> members = new ArrayList<>();


        String qry = "SELECT a.user_no as user_no,a.user_reg_date as reg_date,b.user_email as user_email FROM user_general_info as a JOIN user_private_info as b USING(user_no) limit ?, 20;";

        psmt=CBaseBallMaster.prepareStatement(qry);
        psmt.setInt(1,20*page);
        rs = psmt.executeQuery();
        while(rs.next()){
            nUserNo = rs.getInt("user_no");
            dtRegDate = rs.getString("reg_date");
            strUserEmail = rs.getString("user_email");
            MemberVo mem = new MemberVo(nUserNo,dtRegDate,strUserEmail);

            members.add(mem);
        }

        return members;
    }

}

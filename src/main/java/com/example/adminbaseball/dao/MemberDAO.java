package com.example.adminbaseball.dao;

import com.example.adminbaseball.common.JDBCconnection;
import com.example.adminbaseball.model.Member;

import java.sql.SQLException;

public class MemberDAO extends JDBCconnection {

    public MemberDAO() {

    }

    public boolean getIsCheckMember(String userEmail){
        String qrySelectMember = "SELECT COUNT(*) as result FROM user_general_info WHERE user_email = ? limit 1";
        Member member = new Member();
        int result = 0;
        String message = "";
        try{
            psmt = CBaseBallMaster.prepareStatement(qrySelectMember);
            psmt.setString(1,userEmail);

            rs = psmt.executeQuery();

            while(rs.next()){
                result = rs.getInt("result");
            }

            if(result > 0 ){
                return false;
            }

        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }


    //회원가입
    // general_info 생성
    public int setMember(){
        int userNo = 0;
        String qryInsertMember = "INSERT INTO user_general_info(user_login_type) values ('a')";

        try{
            psmt = CBaseBallMaster.prepareStatement(qryInsertMember);
            psmt.executeUpdate();
            int affectedRows = psmt.executeUpdate();

            if(affectedRows == 0){
                throw new SQLException("Creating FAiled, no rows affected");
            }

            rs = psmt.getGeneratedKeys();

            while(rs.next()){
                userNo = rs.getInt("user_no");
            }

            return userNo;
        }catch(SQLException e){
            e.printStackTrace();
            System.out.print("user_general_info 회원가입 실패");
            try{
                CBaseBallMaster.close();
            }catch (SQLException e1){
                e1.printStackTrace();
            }

            return 0;
        }catch(Exception e){
            System.out.print("user_general_info 회원가입 실패");
            try{
                CBaseBallMaster.rollback();
            }catch (SQLException e1){
                e1.printStackTrace();
            }
            return 0;
        }

    }
    // agree_info

    // private_info
    public boolean setMemberPrivate(Member member){
        String qryInsertMemberPrivate = "INSERT INTO user_private_info(user_no,user_email,user_salt, user_name,user_gender, user_birth_date,user_ci,user_private_info_save_type, user_private_info_save_date)" +
                "VALUES (?,?,?,?,?,?,?,?,?,?)";

        try{
            psmt = CBaseBallMaster.prepareStatement(qryInsertMemberPrivate);
            psmt.setInt(1, member.getUserNo());
            psmt.setString(2, member.getUserEmail());
            psmt.setString(3, "123131fi");
            psmt.setString(4, member.getUserName());
            psmt.setString(5, "m");
            psmt.setString(6, member.getUserBirthDate());
            psmt.setString(7, "x15c1d12r2");
            psmt.setString(8,"1");
            psmt.setString(9,"NOW()");

            int affectedRows = psmt.executeUpdate();

            if(affectedRows == 0){
                throw new SQLException("Creating FAiled, no rows affected");
            }

            return true;
        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("private 실패");
            try{
                CBaseBallMaster.rollback();
            }catch(SQLException e1){
                e1.printStackTrace();
            }

            return false;
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("private 실패");

            return false;
        }



    }

    //




}

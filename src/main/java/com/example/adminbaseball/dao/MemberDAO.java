package com.example.adminbaseball.dao;

import com.example.adminbaseball.common.JDBCconnection;
import com.example.adminbaseball.model.Member;

import java.sql.SQLException;
import java.sql.Statement;

public class MemberDAO extends JDBCconnection {

    public MemberDAO() {

    }

    public boolean getIsCheckMember(String userEmail){
        String qrySelectMember = "SELECT COUNT(*) as result FROM user_private_info WHERE user_email = ? limit 1";
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
        String qryInsertMember = "INSERT INTO user_general_info(user_login_type) values ('0')";

        try{
            psmt = CBaseBallMaster.prepareStatement(qryInsertMember, Statement.RETURN_GENERATED_KEYS);
            int affectedRows = psmt.executeUpdate();

            if(affectedRows == 0){
                throw new SQLException("Creating FAiled, no rows affected");
            }

            rs = psmt.getGeneratedKeys();

            if(rs.next()){
                userNo = rs.getInt(1);
                System.out.println(userNo);
            }

            return userNo;
        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("user_general_info 회원가입 실패");
            try{
                CBaseBallMaster.close();
            }catch (SQLException e1){
                e1.printStackTrace();
            }

            return 0;
        }catch(Exception e){
            System.out.print("user_general_info 회원가입 실패");
            return 0;
        }

    }
    // agree_info

    // private_info
    public boolean setMemberPrivate(Member member){
        String qryInsertMemberPrivate = "INSERT INTO user_private_info(user_no,user_email,user_password, user_salt, user_name,user_gender, user_birth_date,user_ci,user_private_info_save_type, user_private_info_save_date)" +
                "VALUES (?,?,?,?,?,?,?,?,?,NOW())";

        try{
            psmt = CBaseBallMaster.prepareStatement(qryInsertMemberPrivate, Statement.RETURN_GENERATED_KEYS);
            psmt.setInt(1, member.getUserNo());
            psmt.setString(2, member.getUserEmail());
            psmt.setString(3, member.getPassword());
            psmt.setString(4, "123131fi");
            psmt.setString(5, member.getUserName());
            psmt.setString(6, "m");
            psmt.setString(7, member.getUserBirthDate());
            psmt.setString(8, "x15c1d12r2");
            psmt.setString(9,"1");

            int affectedRows = psmt.executeUpdate();

            if(affectedRows == 0){
                throw new SQLException("Creating FAiled, no rows affected");
            }

            return true;
        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("private 실패");
            return false;
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("private 실패");
            return false;
        }



    }

    // agree
    public boolean setMemberAgree(Member member){
        String qryInsertAgree = "INSERT INTO user_agree_info (user_no, user_agree_service_flag, user_agree_date, user_agree_private_info_save_flag, user_agree_private_info_save_date)" +
                "VALUES (?,'Y',NOW(),'Y',NOW())";

        try{
            psmt = CBaseBallMaster.prepareStatement(qryInsertAgree, Statement.RETURN_GENERATED_KEYS);
            psmt.setInt(1, member.getUserNo());

            int affectedRows = psmt.executeUpdate();
            if(affectedRows == 0){
                throw new SQLException("Creating FAiled, no rows affected");
            }

            return true;
        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("agree 실패");
            return false;
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("agree 실패");
            return false;
        }
    }

    public Member getMember(Member member){
        String qrySelectMember = "SELECT user_no, user_email FROM user_private_info WHERE user_email = ? AND user_password = ? limit 1";

        try{
            System.out.println(member.getUserEmail());
            System.out.println(member.getPassword());
            psmt= CBaseBallMaster.prepareStatement(qrySelectMember);
            psmt.setString(1, member.getUserEmail());
            psmt.setString(2,member.getPassword());

            rs = psmt.executeQuery();

            if(rs.next()){
                member.setUserNo(rs.getInt("user_no"));
                member.setUserEmail(rs.getString("user_email"));
            }
            System.out.println(member.getUserEmail());

            return member;
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }



}

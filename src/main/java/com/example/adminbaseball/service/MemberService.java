package com.example.adminbaseball.service;

import com.example.adminbaseball.model.Member;
import com.example.adminbaseball.dao.MemberDAO;

import java.sql.SQLException;

public class MemberService {

    public boolean fnCheckedUserEmail(String userEmail){
        MemberDAO memberDao = new MemberDAO();

        boolean isCheckedEmail = memberDao.getIsCheckMember(userEmail);

        return isCheckedEmail;
    }

    public boolean fnInsertMember(Member member) {

        MemberDAO memberDao = new MemberDAO();
        try {
            if (fnCheckedUserEmail(member.getUserEmail()) == false) {
                throw new Exception();
            }

            memberDao.startTransaction();
            //user_general_info 생성
            int userNo = memberDao.setMember();
            if (userNo <= 0) {
                throw new SQLException();
            }
            //user_private_info 생성
            member.setUserNo(userNo);

            boolean setMemberPrivate = memberDao.setMemberPrivate(member);
            if (setMemberPrivate == false) {
                throw new SQLException();
            }
            if(!memberDao.setMemberAgree(member)){
                throw new SQLException();
            }

            memberDao.commit();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                memberDao.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    public Member fnLogin(Member member){
        MemberDAO memberDao = new MemberDAO();

        try{
            member = memberDao.getMember(member);

            if(member == null){
                return null;
            }

            return member;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

}

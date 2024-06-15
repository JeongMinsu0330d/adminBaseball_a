package com.example.adminbaseball.service;

import com.example.adminbaseball.model.Member;
import com.example.adminbaseball.dao.MemberDAO;

public class MemberService {

    public boolean fnCheckedUserEmail(String userEmail){
        MemberDAO memberDao = new MemberDAO();

        boolean isCheckedEmail = memberDao.getIsCheckMember(userEmail);

        return isCheckedEmail;
    }

    public boolean fnInsertMember(Member member){

        try{
            if(fnCheckedUserEmail(member.getUserEmail()) == false){
                throw new Exception();
            }

            MemberDAO memberDao = new MemberDAO();
            memberDao.startTransaction();
            //user_general_info 생성
            int userNo = memberDao.setMember();
            //user_private_info 생성
            member.setUserNo(userNo);

            memberDao.setMemberPrivate(member);
            //user_agree

            memberDao.commit();

            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }


    }




}

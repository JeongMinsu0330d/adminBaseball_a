package com.example.adminbaseball.model;

public class Member {
   private int userNo;
   private String userEmail;
   private String password;
   private String userSalt;
   private String userName;
   private String userGender;
   private String userBirthDate;
   private String userCi;
   private String user_private_save_type;
   private String getUser_private_save_type;
   private String getUser_private_save_date;



   public Member() {

   }

   public Member(String userEmail, String password, String userName, String userGender, String userBirthDate, String user_private_save_type, String getUser_private_save_type) {
      this.userEmail = userEmail;
      this.password = password;
      this.userName = userName;
      this.userGender = userGender;
      this.userBirthDate = userBirthDate;
      this.user_private_save_type = user_private_save_type;
      this.getUser_private_save_type = getUser_private_save_type;
   }

   public int getUserNo() {
      return userNo;
   }

   public void setUserNo(int userNo) {
      this.userNo = userNo;
   }

   public String getUserEmail() {
      return userEmail;
   }

   public void setUserEmail(String userEmail) {
      this.userEmail = userEmail;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public String getUserSalt() {
      return userSalt;
   }

   public void setUserSalt(String userSalt) {
      this.userSalt = userSalt;
   }

   public String getUserName() {
      return userName;
   }

   public void setUserName(String userName) {
      this.userName = userName;
   }

   public String getUserGender() {
      return userGender;
   }

   public void setUserGender(String userGender) {
      this.userGender = userGender;
   }

   public String getUserBirthDate() {
      return userBirthDate;
   }

   public void setUserBirthDate(String userBirthDate) {
      this.userBirthDate = userBirthDate;
   }

   public String getUserCi() {
      return userCi;
   }

   public void setUserCi(String userCi) {
      this.userCi = userCi;
   }

   public String getUser_private_save_type() {
      return user_private_save_type;
   }

   public void setUser_private_save_type(String user_private_save_type) {
      this.user_private_save_type = user_private_save_type;
   }

   public String getGetUser_private_save_type() {
      return getUser_private_save_type;
   }

   public void setGetUser_private_save_type(String getUser_private_save_type) {
      this.getUser_private_save_type = getUser_private_save_type;
   }
   public String getGetUser_private_save_date() {
   return getUser_private_save_date;
   }

   public void setGetUser_private_save_date(String getUser_private_save_date) {
   this.getUser_private_save_date = getUser_private_save_date;
   }

}
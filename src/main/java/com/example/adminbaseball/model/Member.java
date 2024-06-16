package com.example.adminbaseball.model;

public class Member {
   private int userNo;
   private String userEmail;
   private String password;
   private String userSalt;
   private String userName;
   private String userGender;
   private String userBirthDate;
   private String address;
   private String userCi;
   private String user_private_save_type;
   private String user_private_save_date;
   private String user_service_save_type;
   private String user_service_save_date;


   public Member() {}

   public Member(String userEmail, String password, String userName, String userBirthDate, String address, String user_private_save_type, String user_service_save_type) {
      this.userEmail = userEmail;
      this.password = password;
      this.userName = userName;
      this.userBirthDate = userBirthDate;
      this.address = address;
      this.user_private_save_type = user_private_save_type;
      this.user_service_save_type = user_service_save_type;
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

   public String getAddress() {
      return address;
   }

   public void setAddress(String address) {
      this.address = address;
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

   public String getUser_private_save_date() {
      return user_private_save_date;
   }

   public void setUser_private_save_date(String user_private_save_date) {
      this.user_private_save_date = user_private_save_date;
   }

   public String getUser_service_save_type() {
      return user_service_save_type;
   }

   public void setUser_service_save_type(String user_service_save_type) {
      this.user_service_save_type = user_service_save_type;
   }

   public String getUser_service_save_date() {
      return user_service_save_date;
   }

   public void setUser_service_save_date(String user_service_save_date) {
      this.user_service_save_date = user_service_save_date;
   }
}
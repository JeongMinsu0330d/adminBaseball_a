package com.example.adminbaseball.common;

import java.sql.*;

public class JDBCconnection {

    public Connection CBaseBallMaster;
    public Statement stmt;
    public PreparedStatement psmt;
    public ResultSet rs;


    public JDBCconnection(){
        try{
            String msg ="";
            String url = "jdbc:mysql://192.168.0.31:3306/baseballdb";
            String user = "mncvc";
            String pwd = "wjdalstn12@A";
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.CBaseBallMaster = DriverManager.getConnection(url,user,pwd);
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Error");
        }

    }

    public boolean startTransaction() throws SQLException{
        try {
            CBaseBallMaster.setAutoCommit(false);
            return true;
        }catch(SQLException e){
            return false;
        }
    }

    public void commit() throws SQLException{
        CBaseBallMaster.commit();
    }

    public void rollback() throws SQLException{
        if(CBaseBallMaster != null) {
            CBaseBallMaster.rollback();
        }
    }

    public void close() throws SQLException{
        CBaseBallMaster.close();
        stmt.close();
        psmt.close();
        rs.close();
    }





}

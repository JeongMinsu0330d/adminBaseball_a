package com.example.adminbaseball.DAO;

import com.example.adminbaseball.StadiumVo;
import com.example.adminbaseball.common.JDBCconnection;
import com.example.adminbaseball.common.Section;
import com.example.adminbaseball.common.Value;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StadiumDAO extends JDBCconnection {

    public StadiumDAO(){
    }
    public StadiumVo getStadiumInfoByStadiumNo(int stadiumNo) throws SQLException {
        StadiumVo stadium = new StadiumVo();

        String qrySelectStadium = "SELECT stadium_no, stadium_name FROM stadium_info WHERE stadium_no = ?";
        psmt=CBaseBallMaster.prepareStatement(qrySelectStadium);
        psmt.setInt(1,stadiumNo);
        rs = psmt.executeQuery();
        while(rs.next()){

            int nStadiumNo = rs.getInt("stadium_no");
            String strStadiumName = rs.getString("stadium_name");
            stadium = new StadiumVo(nStadiumNo, strStadiumName);
        }


        return stadium;
    }
    public List<StadiumVo> getAllStadium() throws SQLException {
        List<StadiumVo> stadiums = new ArrayList<>();

        String qrySelectStadium = "SELECT stadium_no, stadium_name FROM stadium_info";

        psmt=CBaseBallMaster.prepareStatement(qrySelectStadium);
        rs = psmt.executeQuery();

        while(rs.next()){

            int nStadiumNo = rs.getInt("stadium_no");
            String strStadiumName = rs.getString("stadium_name");

            StadiumVo stadium = new StadiumVo(nStadiumNo, strStadiumName);

            stadiums.add(stadium);
        }

        return stadiums;
    }

    public int createStadium(String strStadiumName, String pathStadiumImage) throws SQLException{
        String qryInsertStadium = "INSERT INTO stadium_info(stadium_name,stadium_seat_image, admin_no) VALUES (?,?,0)";
        int nStadiumNo =0;
        try {
            System.out.print(strStadiumName);

            psmt = CBaseBallMaster.prepareStatement(qryInsertStadium, Statement.RETURN_GENERATED_KEYS);
            psmt.setString(1, strStadiumName); // 경기장 명
            psmt.setString(2, pathStadiumImage); // 이미지 경로
            int affectedRows = psmt.executeUpdate();

            if(affectedRows == 0){
                throw new SQLException("Creating FAiled, no rows affected");
            }
            rs = psmt.getGeneratedKeys();

            while(rs.next()){
                nStadiumNo = rs.getInt(1);
            }

        }catch(SQLException e){
            rollback();
            System.out.print("here");
            e.printStackTrace();
        }

        return nStadiumNo;
    }
    public void setStadiumSeatInfo(int nStadiumNo, Section section, Value value){
        System.out.println(nStadiumNo);
        System.out.println(Integer.parseInt(value.getSection_no()));
        String qryInsertStadiumSeatInfo = "INSERT INTO stadium_seat_list (stadium_no, section_type,section_no,  seat_col, seat_row, admin_no) VALUES (?,?,?,?,?,0)";
        System.out.println(qryInsertStadiumSeatInfo);
        try {
            psmt = CBaseBallMaster.prepareStatement(qryInsertStadiumSeatInfo);
            psmt.setInt(1,nStadiumNo);                                  // 경기장 번호
            psmt.setString(2,section.getSection_type());                // 경기장 좌석 타입
            psmt.setInt(3, Integer.parseInt(value.getSection_no()));    // 경기장 좌석 구간
            psmt.setInt(4, Integer.parseInt(value.getSeat_col()));      // 경기장 좌석 구간 열 값
            psmt.setInt(5, Integer.parseInt(value.getSeat_row()));      // 경기장 좌석 구간 행 값

            int affectedRows = psmt.executeUpdate();
            System.out.print("좌석 생성 : " + affectedRows);
            if(affectedRows == 0){
                throw new SQLException("Creating FAiled, no rows affected");
            }

        }catch(SQLException e){
            e.printStackTrace();
            try{
                rollback();
            }catch(Exception e2){
                e2.printStackTrace();
            }
        }

    }

    public void setStadiumTicket(int nStadiumNo, String strSectionType, String strAgeType, int nWeekPrice, int nWeekendPrice){
        String qryInsertStadiumTicket="INSERT INTO stadium_seat_price_info(stadium_no, section_type, ticket_age_type,ticket_date_type,ticket_price,admin_no)" +
                " VALUES (?,?,?,'a',?,0),(?,?,?,'b',?,0)";

        try {
            psmt = CBaseBallMaster.prepareStatement(qryInsertStadiumTicket);
//주중
            psmt.setInt(1,nStadiumNo);
            psmt.setString(2,strSectionType);
            psmt.setString(3,strAgeType);
            psmt.setInt(4,nWeekPrice);
// 주말
            psmt.setInt(5,nStadiumNo);
            psmt.setString(6,strSectionType);
            psmt.setString(7,strAgeType);
            psmt.setInt(8,nWeekendPrice);

            int affectedRows = psmt.executeUpdate();
            if(affectedRows != 2){
                throw new SQLException("failed Affected Row");
            }

        }catch(SQLException e){
            try {
                System.out.println("here1");
                e.printStackTrace();
                rollback();
            }catch(Exception e2){
                System.out.println("here2");
                e2.printStackTrace();
            }
        }


    }

}

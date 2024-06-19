package com.example.adminbaseball.service;

import com.example.adminbaseball.common.JDBCconnection;

import java.sql.*;

public class MileageService2 {

    public boolean chargeMileage() {
        boolean isResult = false;
        int userNo = 12345;
        String accountCode = "ABCDE";
        int chargeObjectSeq = 1;
        int payPrice = 10000;
        int fillMileage = 1000;
        int payCommission = 500;
        String tid = "PG1234567890";

        JDBCconnection jdbc = new JDBCconnection();
        Connection conn = jdbc.CBaseBallMaster;
        PreparedStatement pstmt1 = null;
        PreparedStatement pstmt2 = null;
        PreparedStatement pstmt3 = null;
        PreparedStatement pstmt4 = null;

        try {
            // JDBC 드라이버 로드


            // 자동 커밋 비활성화 (트랜잭션 시작)
            conn.setAutoCommit(false);

            // 1. mileage_fill_list에 데이터 삽입
            String sql1 = "INSERT INTO mileage_fill_list (account_code, charge_object_seq, user_no, pay_price, mileage_type, fill_mileage, pay_commission, tid, mileage_cancel_flag) " +
                    "VALUES (?, ?, ?, ?, 'm', ?, ?, ?, 'n')";
            pstmt1 = conn.prepareStatement(sql1, Statement.RETURN_GENERATED_KEYS);
            pstmt1.setString(1, accountCode);
            pstmt1.setInt(2, chargeObjectSeq);
            pstmt1.setInt(3, userNo);
            pstmt1.setInt(4, payPrice);
            pstmt1.setInt(5, fillMileage);
            pstmt1.setInt(6, payCommission);
            pstmt1.setString(7, tid);

            // 쿼리 실행 및 일련번호(seq) 가져오기
            int affectedRows1 = pstmt1.executeUpdate();
            if (affectedRows1 == 0) {
                throw new SQLException("마일리지 충전 정보 삽입 실패, no rows affected.");
            }
            ResultSet generatedKeys1 = pstmt1.getGeneratedKeys();
            int mileageFillSeq = -1;
            if (generatedKeys1.next()) {
                mileageFillSeq = generatedKeys1.getInt(1);
            } else {
                throw new SQLException("마일리지 충전 정보 삽입 실패, no ID obtained.");
            }

            // 2. mileage_detail_list에 데이터 삽입
            String sql2 = "INSERT INTO mileage_detail_list (user_no, account_code, object_seq, mileage_type, mileage, remain_mileage, active_date, used_all_flag, admin_no) " +
                    "VALUES (?, ?, ?, 'm', ?, ?, NOW(), 'n', 0)";
            pstmt2 = conn.prepareStatement(sql2);
            pstmt2.setInt(1, userNo);
            pstmt2.setString(2, accountCode);
            pstmt2.setInt(3, mileageFillSeq); // mileage_fill_list의 seq를 사용
            pstmt2.setInt(4, fillMileage);
            pstmt2.setInt(5, fillMileage); // 첫 적립이므로 remain_mileage도 fill_mileage와 동일하게 설정

            // 쿼리 실행
            int affectedRows2 = pstmt2.executeUpdate();
            if (affectedRows2 == 0) {
                throw new SQLException("마일리지 적립 정보 삽입 실패, no rows affected.");
            }

            // 3. mileage_detail_log에 데이터 삽입
            String sql3 = "INSERT INTO mileage_detail_log (mileage_detail_list_seq, object_seq, account_code, user_no, detail_log_type, mileage, detail_log_state) " +
                    "VALUES (?, ?, ?, ?, 'a', ?, 's')";
            pstmt3 = conn.prepareStatement(sql3);
            pstmt3.setInt(1, mileageFillSeq); // mileage_detail_list의 seq를 사용
            pstmt3.setInt(2, mileageFillSeq); // mileage_fill_list의 seq를 사용
            pstmt3.setString(3, accountCode);
            pstmt3.setInt(4, userNo);
            pstmt3.setInt(5, fillMileage);

            // 쿼리 실행
            int affectedRows3 = pstmt3.executeUpdate();
            if (affectedRows3 == 0) {
                throw new SQLException("마일리지 상세 로그 정보 삽입 실패, no rows affected.");
            }

            // 4. mileage_change_list에 데이터 삽입
            String sql4 = "INSERT INTO mileage_change_list (object_seq, user_no, change_type, account_code, previous_mileage, mileage, next_mileage, change_comment, change_state, admin_no) " +
                    "VALUES (?, ?, 'a', ?, ?, ?, ?, '마일리지 충전', 's', 0)";
            pstmt4 = conn.prepareStatement(sql4);
            pstmt4.setInt(1, mileageFillSeq); // mileage_fill_list의 seq를 사용
            pstmt4.setInt(2, userNo);
            pstmt4.setString(3, accountCode);
            pstmt4.setInt(4, 0); // 이전 마일리지가 적용되지 않으므로 0으로 설정
            pstmt4.setInt(5, fillMileage);
            pstmt4.setInt(6, fillMileage); // 충전 후 마일리지를 다음 마일리지로 설정

            // 쿼리 실행
            int affectedRows4 = pstmt4.executeUpdate();
            if (affectedRows4 == 0) {
                throw new SQLException("마일리지 변동 정보 삽입 실패, no rows affected.");
            }

            // 모든 작업이 성공적으로 완료되었으므로 커밋
            conn.commit();
            System.out.println("마일리지 충전 및 관련 데이터 삽입 트랜잭션 완료.");

            isResult = true;
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                // 오류 발생 시 롤백
                if (conn != null) {
                    conn.rollback();
                    System.out.println("트랜잭션 롤백 완료.");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }finally {
                return false;
            }
        } finally {
            // 리소스 해제
            if (pstmt1 != null) {
                try {
                    pstmt1.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (pstmt2 != null) {
                try {
                    pstmt2.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (pstmt3 != null) {
                try {
                    pstmt3.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (pstmt4 != null) {
                try {
                    pstmt4.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return isResult;
    }
}

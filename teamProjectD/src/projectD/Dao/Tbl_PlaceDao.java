package projectD.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import projectD.Vo.*;

/**
 * 여기 있는 메소드
 * 
 * 삭제
 * deletePlace
 * 
 * 평점변경
 * modifyRate
 * 
 * 랜덤 맛집 선정
 * randomRestorant
 * 
 * 이름별 맛집 찾기
 * findName
 * 
 * 평점별 맛집 찾기
 * showRate
 */

public class Tbl_PlaceDao {
    public static final String URL = "jdbc:oracle:thin:@//localhost:1521/xe";
    public static final String USERNAME = "c##idev";
    private static final String PASSWORD = "1234";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    public List<PlaceVo> findName(String name) {
        List<PlaceVo> list = new ArrayList<>();
        String sql = "SELECT tp.*\r\n" + //
                "FROM TBL_PLACE tp , TBL_MENU tm \r\n" + //
                "WHERE tp.PLACE_SEQ =tm.PLACE_SEQ \r\n" + //
                "AND tp.NAME LIKE '%'||?||'%'" ;
        try (Connection connection = getConnection();
                PreparedStatement pstmt = connection.prepareStatement(sql);) {
            pstmt.setString(1, "%" + name + "%");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                list.add(new PlaceVo(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7)));
            }
        } catch (SQLException e) {
            System.out.println("예외 발생 :" + e.getMessage());
        }
    
        return list;
    }// 이름으로 찾기

    public List<PlaceVo> showRate(double rate) {
        List<PlaceVo> list = new ArrayList<>();
        String sql = "SELECT tp.PLACE_SEQ, tp.NAME, open_time , close_time\r\n" + //
                "        , tpa.address, tp.rate\r\n" + //
                "FROM  tbl_place tp\r\n" + //
                "   , tbl_place_address tpa\r\n" + //
                "WHERE tp.place_seq = tpa.place_seq\r\n" + //
                "AND tp.RATE >= ?\r\n" + //
                "ORDER BY tp.rate DESC";

        try (Connection connection = getConnection();
                PreparedStatement pstmt = connection.prepareStatement(sql);) {
            pstmt.setDouble(1, rate);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                list.add(new PlaceVo(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7)));
            }

        } catch (SQLException e) {
            System.out.println("예외 발생 :" + e.getMessage());
        }

        return list;
    } //평점 순위 보기

    public List<PlaceVo> randomRestorant(String place, int time) {
        List<PlaceVo> randomlist = new ArrayList<>();
        String sql = "SELECT * \r\n" + //
                "FROM\r\n" + //
                "   (SELECT * \r\n" + //
                "   FROM TBL_PLACE tp, \r\n" + //
                "   TBL_PLACE_ADDRESS tpa \r\n" + //
                "   WHERE ADDRESS like '%'||?||'%'\r\n" + //
                "   ORDER BY DBMS_RANDOM.VALUE) \r\n" + //
                "WHERE ROWNUM <= ?";
        try (
                Connection connection = getConnection();
                PreparedStatement pstmt = connection.prepareStatement(sql);) {
            pstmt.setString(1, place);
            pstmt.setInt(2, time);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                randomlist.add(new PlaceVo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),
                        rs.getString(6), rs.getString(7)));
            }
        } catch (SQLException e) {
            System.out.println("randomRestorant 실행 예외 발생: " + e.getMessage());
        }
        return randomlist;
    }// randomRestorant //랜덤

    public void deletePlace(PlaceVo pv) {
        String sql = "DELETE\r\n" + "FROM TBL_PLACE_ADDRESS tpa\r\n" + "WHERE PLACE_SEQ = ?";
        try (Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);) {
            pstmt.setInt(1, pv.getPlace_seq());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("[place] 삭제 예외 발생: " + e.getMessage());
        }
    }// deletePlace //맛집삭제

    public void modifyRate(String name, double newRate) {
        String sql = "UPDATE tbl_place SET RATE = ? WHERE place_seq = ?";
        try (
                Connection connection = getConnection();
                PreparedStatement pstmt = connection.prepareStatement(sql);) {
            pstmt.setString(1, name);
            pstmt.setDouble(2, newRate);
            pstmt.executeUpdate();
            System.out.println("가게 평점이 수정되었습니다.");
        } catch (SQLException e) {
            System.out.println("가게 평점 변경 실행 예외 발생: " + e.getMessage());
        }
    }// modifyRate //평점수정

    public void deletePlace(int placeSeq) {
        String sql = "DELETE\r\n" + "FROM TBL_Place \r\n" + "WHERE PLACE_SEQ = ?";
        try (Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);) {
            pstmt.setInt(1, placeSeq);
            pstmt.executeUpdate();
            System.out.println("가게가 성공적으로 삭제되었습니다.");
        } catch (SQLException e) {
            System.out.println("[메뉴] 삭제 예외 발생: " + e.getMessage());
        }
    }// deletePlace
}
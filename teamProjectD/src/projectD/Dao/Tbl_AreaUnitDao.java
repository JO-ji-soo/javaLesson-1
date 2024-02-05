package projectD.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import projectD.Vo.*;

/* 
 *   여기에 있는 메소드
 *   지역 번호(코드 ex) 02, 031.. ) 지우기
 *  deleteAreaUnit :
 * 
 */

public class Tbl_AreaUnitDao {
    public static final String URL = "jdbc:oracle:thin:@//localhost:1521/xe";
    public static final String USERNAME = "c##idev";
    private static final String PASSWORD = "1234";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    public void deleteAreaUnit(AreaUnitVo av) {
        String sql = "DELETE\r\n" + "FROM TBL_AREA_UNIT \r\n" + "WHERE area_unit_code = ?";
        try (Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);) {
            pstmt.setInt(1, av.getArea_unit_code());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("[메뉴] 삭제 예외 발생: " + e.getMessage());
        }
    }// deleteAreaUnit
}

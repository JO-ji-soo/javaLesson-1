package projectD.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import projectD.Vo.*;

/**
 * 여기에 있는 메소드
 * 
 * 삭제
 * void deleteMenu(int paVo)
 * 
 */
public class Tbl_MenuDao {
    public static final String URL = "jdbc:oracle:thin:@//localhost:1521/xe";
    public static final String USERNAME = "c##idev";
    private static final String PASSWORD = "1234";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    public void deleteMenu(MenuVo mv) {
        String sql = "DELETE\r\n" + "FROM TBL_MENU \r\n" + "WHERE PLACE_SEQ = ?";
        try (Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);) {
            pstmt.setInt(1, mv.getPlace_seq());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("[메뉴] 삭제 예외 발생: " + e.getMessage());
        }
    }// deleteMenu

}


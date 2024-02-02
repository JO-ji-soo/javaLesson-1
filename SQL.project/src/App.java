import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}


    public void modifyPlace(int placeSeq, double newRate) {
    String sql = "UPDATE tbl_place SET rate = ? WHERE place_seq = ?";

    try (
        Connection connection = getConnection();
        PreparedStatement pstmt = connection.prepareStatement(sql);
    ) {
        pstmt.setDouble(1, newRate);
        pstmt.setInt(2, placeSeq);
        pstmt.executeUpdate();
        System.out.println("가게 평점이 수정되었습니다.");
    } catch (SQLException e) {
        System.out.println("가게 평점 변경 실행 예외 발생: " + e.getMessage());
    }
}


package jdbc.day1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertDMLTestTecher {
    
    public static void main(String[] args) {
    }   //main end
    

    //insert SQL에 리터럴 값이 아닌 매개변수로 전달 받습니다.
    public static void param_data(){
        Connection conn = OracleConnectionUtil.getConnection();
        if (conn != null) System.out.println("데이터베이스 연결 성공!!");
        
        String sql = "insert into tbl_custom(custom_id , name, email,age,reg_date)\n" +
                      "values (?,?,?,?,sysdate)";
        // PreparedStatement 는 매개변수를 ? 로 표기하고 sql을 미리 컴파일 합니다.
        //            매개변수 ? 에 대입되는(바인딩) 값은 sql execute메소드 이전에 설정 합니다.

        try (
                //auto close 위한 try 형식 - pstmt.close() 필요하므로 try -with -resources 사용
                PreparedStatement pstmt = conn.prepareStatement(sql)
        ) {
                //매개변수 바인딩 ? 는 순서대로 인덱스를 갖습니다. 시작값1
                //        응용프로그램에서 매개변수에 저장될 값은 사용자 입력값 입니다.
                pstmt.setString(1, "sana");
                pstmt.setString(2, "최사나");
                pstmt.setString(3, "sana@naver.com");
                pstmt.setInt(4, 26);
                 
                pstmt.executeUpdate();      // 리턴값 int 는 반영된 행의 개수를 리턴.
        } catch (SQLException e) {
            System.out.println("SQL 실행 예외 발생 : " + e.getMessage());
        } finally {
            OracleConnectionUtil.close(conn);
        }

    }

    //insert 데이터 값이 고정된 예시
    public static void fixed_data() {
        Connection conn = OracleConnectionUtil.getConnection();
        if (conn != null) System.out.println("데이터베이스 연결 성공!!");
        
        String sql = "insert into tbl_custom(custom_id , name, email,age,reg_date)\n" +
                      "values ('nayeon33','박나연3','na3@gmail.com',25,sysdate)";
        
        try (
                //auto close 위한 try 형식 - pstmt.close() 필요하므로 try -with -resources 사용
                PreparedStatement pstmt = conn.prepareStatement(sql)
        ) {
           //     pstmt.execute();          //sql 실행 메소드      
                pstmt.executeUpdate();      // 리턴값 int 는 반영된 행의 개수를 리턴.
        } catch (SQLException e) {
            System.out.println("SQL 실행 예외 발생 : " + e.getMessage());
        } finally {
            OracleConnectionUtil.close(conn);
        }
    }
}

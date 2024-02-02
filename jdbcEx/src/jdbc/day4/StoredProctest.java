package jdbc.day4;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

import jdbc.day1.OracleConnectionUtil;

public class StoredProctest {
    public static void main(String[] args) {
        //esec_max_customer();
        exec_money_of_day2();
    }

    private static void esec_max_customer(){
        Connection connection = OracleConnectionUtil.getConnection();
        String sql= "{call max_custom(?,?)}"; //프로시저 sql 전달 - >"{call 프로시저 이름(매개변수)}"

        //프로시저 실행 및 관리 인터페이스 CallableStatement의 메소드 prepareCal()로 실행하기
        try (CallableStatement cstmt = connection.prepareCall(sql)
        ){  //프로시저 실행결과 out 파라미터 1번 인덱스의 타입 지정하기 - 고객이름
            cstmt.registerOutParameter(1, Types.VARCHAR); //Types.VARCHAR ->DBMS의 타입
            //프로시저 실행결과 out 파라미터 2번 인덱스의 타입 지정하기 - 고객나이
            cstmt.registerOutParameter(2, Types.NUMERIC);
            cstmt.executeUpdate();
            //프로시저 실행결과 OUT 파라미터 값은 cstmt 객체에 저장
            //쇼핑몰 관리자(일반사용자)가 원하는 정보
            System.out.println("구매 수량이 가장 많은 고객 정보를 조회한 결과입니다.");
            //인덱스 1번 out 실행 결과값 가져오기
            System.out.println("고객 이름: " +cstmt.getString(1));
            System.out.println("고객 나이: "+cstmt.getInt(2) );
        } catch (Exception e) {
            System.out.println("max customer 프로시저 실행 예외: "+e.getMessage());
        } 
    }
    private static void exec_money_of_day2(){
        System.out.println("고객 ID와 날짜를 입력하면 총 구매금액을 조회합니다.");
        System.out.println("고객 ID 입력");
        String customid = System.console().readLine();
        System.out.println("날짜 입력");
        String buydate = System.console().readLine(); //입력형식 yyyy-mm-dd

        Connection connection = OracleConnectionUtil.getConnection();
        String sql = "{call money_of_day2(?,?,?)}";
        try (CallableStatement cstmt = connection.prepareCall(sql)){
            cstmt.setString(1, customid);
            cstmt.setString(2, buydate);
            cstmt.registerOutParameter(3, Types.NUMERIC);
            cstmt.executeUpdate();
            String result = String.format("%s 고객님이 %s에 구매한 총 구매금액: %,8d",customid,buydate, cstmt.getInt(3));
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("money 프로시저 예외"+e.getMessage());
        }
    }
}

package project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import project.vo.BuyVo;
import project.vo.CustomerBuyVo;

public class TblBuyDao {
    public static final String URL ="jdbc:oracle:thin:@//localhost:1521/xe";
    public static final String USERNAME = "c##idev";
    private static final String PASSWORD = "1234";

    private Connection getConnection() throws SQLException {
    return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
    //tbl_buy 테이블을 대상으로 insert, update, delete 할 수 있는 dao 클래스 만들기 -TblBuyDao.java
    //테이블 컬럼과 1:1 대응되는 BuyVo.java 만들기 
    //테이블의 pk 컬럼은 BUY_IDX :  update, delete 할때 조건 컬럼으로 사용됨 (행을 식별) -> 모든 조건은 pk

    //장바구니 담기  - insert
    public void buy(BuyVo bv, String userId){
        String sql = "insert into tbl_buy(BUY_IDX, CUSTOMID, PCODE, QUANTITY, BUY_DATE) " 
                            +"VALUES(buy_pk_seq.nextval, ?, ?, ? , sysdate)" ;

        try (Connection connection = getConnection();       //auto close
            PreparedStatement pstmt = connection.prepareStatement(sql);
            )
            {   //2. 매개변수 바인딩 (매개변수 타입에 맞는 메소드를 실행)
                pstmt.setString(1, userId);
                pstmt.setString(2, bv.getPcode());
                pstmt.setInt(3, bv.getQuantity());
                pstmt.executeUpdate();
                
        } catch (SQLException e) {
            System.out.println("구매 실행 예외 발생 : " + e.getMessage());
        }
        //customid 와 pcode는 참조테이블에 존재하는 값으로 안하면 무결성 위반오류
    }


    //executeUpdate 메소드의 result 반영
    public int buy(BuyVo bv){
        String sql = "insert into tbl_buy(BUY_IDX, CUSTOMID, PCODE, QUANTITY, BUY_DATE) " +
        "VALUES(buy_pk_seq.nextval, ?, ?, ? , sysdate) " ;
        int result=0;

        try (Connection connection = getConnection();       //auto close
            PreparedStatement pstmt = connection.prepareStatement(sql);
            )
            {   //2. 매개변수 바인딩 (매개변수 타입에 맞는 메소드를 실행)
                pstmt.setString(2, bv.getPcode());
                pstmt.setInt(3, bv.getQuantity());
                result = pstmt.executeUpdate();
                
        } catch (SQLException e) {
            System.out.println("구매 실행 예외 발생 : " + e.getMessage());
        }return result;
        //customid 와 pcode는 참조테이블에 존재하는 값으로 안하면 무결성 위반오류
    }

    //executeUpdate 메소드의 result 반영 - 구매 취소 
    public int delete(int buyidx){
        int result=0;
        String sql = "delete from tbl_buy where BUY_IDX =?" ;
        try (Connection connection = getConnection();      
            PreparedStatement pstmt = connection.prepareStatement(sql);)
            {pstmt.setInt(1, buyidx);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("구매취소 실행 예외 발생 : " + e.getMessage());
        }return result;
    }

    //[2] 구매 취소   
    public void delete(BuyVo bv){
        String sql = "delete from tbl_buy where BUY_IDX =?" ;
        try (Connection connection = getConnection();      
            PreparedStatement pstmt = connection.prepareStatement(sql);)
            {pstmt.setInt(1, bv.getBuy_idx());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("구매취소 실행 예외 발생 : " + e.getMessage());
    }
}
    //executeUpdate 메소드는 insert,update, delete가 정상실행(반영된 행이 있으면)되면 1을 리턴
    //특히 update나 delete는 조건에 맞는 행이 없어 반영되지 않으면 0을 리턴
    //[3] 구매 수량 변경 -pk로 행을 식별 
    public void modify(BuyVo bv,int changeidx, int number){
        String sql ="UPDATE TBL_BUY SET QUANTITY = ? WHERE BUY_IDX = ?";
        try (Connection connection = getConnection();      
            PreparedStatement pstmt = connection.prepareStatement(sql);){
            pstmt.setInt(1, number);
            pstmt.setInt(2, bv.getBuy_idx());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("구매수량변경 실행 예외 발생 : " + e.getMessage());
        }
    }
    //MAP 으로 넣기
    public int modify(Map<String ,Integer> arg){
        String sql ="UPDATE TBL_BUY SET QUANTITY = ? WHERE BUY_IDX = ?";
        int result =0;
        try (Connection connection = getConnection();      
            PreparedStatement pstmt = connection.prepareStatement(sql);){
            pstmt.setInt(1, arg.get("quantity"));
            pstmt.setInt(2, arg.get("buyidx"));
            result=pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("구매수량변경 실행 예외 발생 : " + e.getMessage());
        } return result;

    }
    //buyidx에 없는 값이면 오류는 아니고 update반영한 행의 개수가 0이 됨

    //mypage 기능의 메소드
    public List<CustomerBuyVo> selectCustomerBuyList(String costumerId){
        List<CustomerBuyVo> list = new ArrayList<>();
        String sql = "SELECT BUY_IDX, TB.PCODE, PNAME,PRICE,QUANTITY ,BUY_DATE \r\n" + 
            "FROM TBL_BUY TB \r\n" + 
            "JOIN TBL_PRODUCT TP \r\n" + 
            "ON TB.PCODE = TP.PCODE \r\n" + 
            "WHERE TB.CUSTOMID =? \r\n"+
            "ORDER by BUY_DATE desc";
            try (Connection connection = getConnection();      
                PreparedStatement pstmt = connection.prepareStatement(sql);)    
                {pstmt.setString(1, costumerId);
                 ResultSet rs = pstmt.executeQuery();
                //pstmt.executeQuery();//executeUpdate() write용 executeQuery() read용- 잘못됨
                while (rs.next()) {
                list.add(new CustomerBuyVo(rs.getInt("BUY_IDX"),
                                            rs.getString("PCODE"), 
                                            rs.getString("PNAME"), 
                                            rs.getInt("PRICE"),
                                            rs.getInt("QUANTITY"),
                                            rs.getTimestamp("BUY_DATE")));
                }
            } catch (SQLException e) {
            System.out.println("고객별 구매내역 실행 예외 발생 : " + e.getMessage());
            }return list;
    }

     //장바구니 모두 구매
     // ㄴbatch(배치) 는 일괄처리 : 실행할 insert,update,delete등의 데이터 저장 DML을 여러개 모아 두었다가
     //                            한번에 실행시킵니다.
     // ㄴ 트랜잭션 : 특정 요구사항에 대한 '하나의 기능'을 실행할 '여러  SQL 명령들'로 구성된 '작업단위'
     //                 ㄴ예시 : cart에 저장된 상품 중 하나라도 참조값이 없는 pcode가 있으면 rollback
     //                                                                   모두 정상이면 commit
     //                          트랜잭션 commit 모드가 auto에서 수동으로 변경
     public int insertMany(List<BuyVo> cart){ //여러번의 (cart크기)의 insert를 실행합니다
        String sql = "INSERT INTO TBL_BUY(BUY_IDX, CUSTOMID, PCODE, QUANTITY, BUY_DATE) \r\n" 
                    +"VALUES(buy_pk_seq.nextval, ?, ?, ? , sysdate)";
        Connection connection = null;
        PreparedStatement pstmt = null;
        int count = 0;
            try {
                connection = getConnection();      
                pstmt = connection.prepareStatement(sql);
                connection.setAutoCommit(false);  //※ auto 커밋 해제
                for(BuyVo vo : cart)
                {
                    pstmt.setString(1, vo.getCustomId());
                    pstmt.setString(2, vo.getPcode());
                    pstmt.setInt(3, vo.getQuantity());
                    pstmt.addBatch();                       
                    //※ sql을 메모리에 모아두기. insert sql에  대입되는 매개변수값은 매번 다릅니다.
                      count++;
                }
                pstmt.executeBatch();                       //※ 모아둔 sql을 일괄 실행하기. 실행 중에 무결성 오류가 생기면
                                                            //      catch에서 rollback
                connection.commit();                        // 정상이면 commit
            } catch (SQLException e) {  //예외발생 : 트랜잭션 처리
                try {
                    connection.rollback();
                } catch (SQLException e1) {  }
                count=-1;
                System.out.println("구매 불가능한 상품이 있습니다.");
                System.out.println("장바구니 구매 실행 예외 발생 : " + e.getMessage());
            }finally{               //정상실행과 예외 모두에 대해 자원 해제
                try {               //트랜잭션 처리를 위해 connection을 사용해야 하므로 직접 close했습니다.
                    pstmt.close();
                    connection.close();
                } catch (SQLException e1) {  }
            }
            return count;
    }

}
package project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import project.vo.BuyVo;
import project.vo.CustomerBuyVo;

public class TblBuyDao {
    public static final String URL ="jdbc:oracle:thin:@//localhost:1521/xe";
    public static final String USERNAME = "c##idev";
    private static final String PASSWORD = "1234";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    //구매하기
    public void Buy(BuyVo vo){
        String sql="insert into tbl_buy(buy_idx, customId,pcode,quantity,buy_date)" + 
                    //insert into tbl_buy \r\n
        "values (Buy_pk_seq.nextval, ?, ?, ?, sysdate)";
        try( //auto close
            Connection connection = getConnection();  
            PreparedStatement pstmt = connection.prepareStatement(sql);  
        ){ 
            pstmt.setString(1, vo.getCustomId());
            pstmt.setString(2, vo.getPcode());
            pstmt.setInt(3, vo.getQuantity());

            pstmt.executeUpdate();                  
        }catch(SQLException e){
            System.out.println("Buy 실행 예외 발생 :"+e.getMessage());
        }
    }

    //구매 수량 수정 - PK는 행 식별합니다. 특정 행을 수정하려면 where조건 컬럼은 buy_idx
    public void modify(BuyVo vo){
        String sql="update tbl_buy set quantity = ? where buy_idx = ?";
    
        try(
            Connection connection = getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql);
        ){
            pstmt.setInt(1, vo.getQuantity());
            pstmt.setInt(2, vo.getBuy_idx());

            pstmt.executeUpdate(); //실행
        }catch(SQLException e){
            System.out.println("Buy 실행 예외 발생 :"+e.getMessage());
        }
    
    }

    //구매 수량 변경
    public void update(BuyVo vo){
        String sql="update tbl_buy set quantity = ? where buy_idx = ?";
    
        try(
            Connection connection = getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql);
        ){
            pstmt.setInt(1, vo.getQuantity());
            pstmt.setInt(2, vo.getBuy_idx());

            pstmt.executeUpdate(); //실행
        }catch(SQLException e){
                System.out.println("Buy 실행 예외 발생 :"+e.getMessage());
        }
    }

    //구매 취소 - PK는 행 식별합니다. 특정 행을 삭제하려면 where조건 컬럼은 buy_idx
    public void delect(BuyVo vo){
        String sql="delect from tbl_buy where buy_idx = ?"; 
        try( //auto close
            Connection connection = getConnection();  
            PreparedStatement pstmt = connection.prepareStatement(sql);  
        ){ 
            pstmt.setInt(1, vo.getBuy_idx());

            pstmt.executeUpdate();                  
        }catch(SQLException e){
            System.out.println("Buy 실행 예외 발생 :"+e.getMessage());
        }
    }

    //mypage 기능의 메소드.
    public List<CustomerBuyVo> selectCustomerBuyList(String category) {
        List<CustomerBuyVo> list = new ArrayList<>();
        String sql = "SELECT BUY_IDX, tb.PCODE, PNAME, PRICE, QUANTITY, BUY_DATE \r\n"
                    +"FROM TBL_BUY tb\r\n"
                    +"JOIN TBL_PRODUCT tp\r\n"
                    +"ON tb.PCODE = tp.PCODE\r\n"
                    +"WHERE tb.CUSTOMID = ?\r\n" 
                    +"ORDER BY BUY_DATE DESC";
        try (
            Connection connection = getConnection();
            PreparedStatement psmt = connection.prepareStatement(sql);
        ) {
            psmt.setString(1, category); 
            ResultSet rs = psmt.executeQuery();
            
            while (rs.next()) { //조회 결과는 N행 가능성 예측
                list.add(new CustomerBuyVo(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getTimestamp(6)));
            }rs.close();
        } catch (SQLException e) {
            System.out.println("selectByCategory 실행 예외 발생: " + e.getMessage());
        }
        return list;
    }
}

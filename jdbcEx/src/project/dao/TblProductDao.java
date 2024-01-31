package project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import project.vo.ProductVo;

public class TblProductDao {
    public static final String URL ="jdbc:oracle:thin:@//localhost:1521/xe";
    public static final String USERNAME = "c##idev";
    private static final String PASSWORD = "1234";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    //카테고리 목록
    public List<ProductVo> allProducts(){
        List<ProductVo> list = new ArrayList<>();
        String sql = "SELECT * FROM TBL_PRODUCT" ;
        try(
            Connection connection = getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql);
        ){
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                list.add(new ProductVo (rs.getString(1), 
                                        rs.getString(2),
                                        rs.getString(3),
                                        rs.getInt(4)));
            }

        }catch (SQLException e) {
            System.out.println("allProducts 실행 예외 발생 :"+e.getMessage());
        }
         return list;
    }
    // 2. 카테고리에 대한 상품 목록
    public List<ProductVo> selectByCategory(String category) {
        List<ProductVo> list = new ArrayList<>();
        String sql = "SELECT * FROM TBL_PRODUCT tp "
                    +"WHERE CATEGORY = ? "
                    +"ORDER BY PNAME ";
        try (
            Connection connection = getConnection();
            PreparedStatement psmt = connection.prepareStatement(sql);
        ) {
            psmt.setString(1, category); 
            ResultSet rs = psmt.executeQuery();
            
            while (rs.next()) { //조회 결과는 N행 가능성 예측
                list.add(new ProductVo(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4)));
            }
        } catch (SQLException e) {
            System.out.println("selectByCategory 실행 예외 발생: " + e.getMessage());
        }
        return list;
    }
    
    //상품명 유사 검색
    public List<ProductVo> selectByPname(String pname) {
        List<ProductVo> list = new ArrayList<>();
        String sql = "SELECT * FROM TBL_PRODUCT tp \r\n "
                    +"WHERE PNAME LIKE '%'|| '사과' || '%'\r\n "
                    +"ORDER BY CATEGORY" ;
        try (
            Connection connection = getConnection();
            PreparedStatement psmt = connection.prepareStatement(sql);
        ) {
            psmt.setString(1, pname); 
            ResultSet rs = psmt.executeQuery();
            
            while (rs.next()) { //조회 결과는 N행 가능성 예측
                list.add(new ProductVo(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4)));
            }
        } catch (SQLException e) {
            System.out.println("selectByPname 실행 예외 발생: " + e.getMessage());
        }
        return list;
    }

    //상품 가격표 Map에 저장하기
    public Map<String, Integer> getPriceTable(){
        Map<String, Integer> map = new HashMap<>();
        String sql = "select pcode,pric fron tbl_product";
        try (
            Connection connection = getConnection();
            PreparedStatement psmt = connection.prepareStatement(sql))
        {
            ResultSet rs = psmt.executeQuery();
            while (rs.next()){
                map.put(rs.getString(1),
                rs.getInt(2));
            }

        }catch (SQLException e) {
            System.out.println("getPriceTable 실행 예외 발생: " + e.getMessage());
        }
        return map;
    }

}

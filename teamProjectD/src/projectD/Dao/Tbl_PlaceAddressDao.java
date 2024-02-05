package projectD.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import projectD.Vo.PlaceAddressVo;
import projectD.Vo.PlaceVo;

public class Tbl_PlaceAddressDao {
    public static final String URL = "jdbc:oracle:thin:@//localhost:1521/xe";
    public static final String USERNAME = "c##idev";
    private static final String PASSWORD = "1234";

private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
public List<PlaceVo> findName(String name) {
        List<PlaceVo> namelist = new ArrayList<>();
        String sql = "SELECT * \r\n" +
                "FROM  tbl_place tp\r\n" +
                "   , tbl_menu tm\r\n" +
                "WHERE tp.place_seq = tm.place_seq\r\n" +
                "   -- 이름으로 찾으면 실행\r\n" +
                "   AND tp.name LIKE '%' || ?  ||'%'\r\n" +
                "   \r\n" +
                "   -- 평점으로 몇점이상인 맛집 찾으면 실행\r\n" +
                "   AND tp.rate >= 4.5\r\n" +
                "   -- 메뉴로 찾으면 실행\r\n" +
                "   AND tm.menu_name LIKE '%' || ?  ||'%'";
        try (Connection connection = getConnection();
                PreparedStatement pstmt = connection.prepareStatement(sql);) {
            pstmt.setString(1, "%" + name + "%");
            pstmt.setString(2, "%" + name + "%");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                namelist.add(new PlaceVo(rs.getInt(1),
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

        return namelist;
    } // 이름으로 찾기

    public List<PlaceAddressVo> findArea(String areaName) {
    List<PlaceAddressVo> addressList = new ArrayList<>();
    String sql = "SELECT tp.place_seq, tp.name, tp.open_time, tp.close_time, tpa.address\r\n" + //
            "FROM tbl_place tp, tbl_place_address tpa, tbl_area_unit au\r\n" + //
            "WHERE tp.place_seq = tpa.place_seq\r\n" + //
            "AND substr(tpa.address, 0, 2) = au.unit_name\r\n" + //
            "AND au.unit_name = ?";
    
    try (Connection connection = getConnection();
         PreparedStatement pstmt = connection.prepareStatement(sql);) {
        pstmt.setString(1, areaName);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            addressList.add(new PlaceAddressVo(
                rs.getInt("place_seq"),
                rs.getString("name"),
                rs.getString("open_time"),
                rs.getString("close_time"),
                rs.getString("address")
            ));
        }
    } catch (SQLException e) {
        System.out.println("지역별 맛집 검색 중 오류 발생: " + e.getMessage());
    }
    
    return addressList;
}


    
      public void deletePlaceAddress(int PlaceVo){
        String sql = "DELETE\r\n" + "FROM TBL_PLACE_ADDRESS tpa\r\n" + "WHERE PLACE_SEQ = ?";
        try(Connection conn = getConnection();
            PreparedStatement pstmt = conn. prepareStatement(sql);){
                pstmt.setInt(1,PlaceVo);
                pstmt.executeUpdate();
            }catch (SQLException e){
                System.out.println("삭제 예외 발생" + e.getMessage());

            }
    
    
    }
    
}

package jdbc.day2;

import java.util.List;

import project.dao.TblBuyDao;
import project.vo.CustomerBuyVo;

public class CartApp {
    public static void main(String[] args) {
        
        System.out.println("구매할 사용자 간편 로그인 필요합니다.");
        System.out.print("아이디 입력 __");
        String custumerId = System.console().readLine();
        TblBuyDao dao = new TblBuyDao();
        List<CustomerBuyVo> list = dao.selectCustomerBuyList(custumerId);
        for (CustomerBuyVo customerBuyVo : list) {
            System.out.println(customerBuyVo);
        }


        System.out.println("[1]구매하기 [2]구매 취소 [3]구매 수량 변경 [4]구매 종료");
        int select = Integer.parseInt(System.console().readLine());
        boolean run = true;

        while (run) { //메뉴 선택 반복
           switch (select) {
            case 1: //[1] 장바구니 담기 - buy 테이블에 insert (1행)
                
                break;
                //[2] 구매 취소 - delete
                //[3] 구매 수량 변경 - update
           
            default:
                break;
           } 
        }
    }
}   //tbl_buy 테이블을 대상으로 insert, update, delete할 수 있는 dao 클래스 만들기
    //        테이블 컬럼과 1:1 대응되는 BuyVo.java
    //        테이블 PK컬럼은 buy_idx -> update, delete의 조건컬럼입니다.
    //        insert에서 시퀀스는 sql 실행할 때와 동일하게 사용합니다.

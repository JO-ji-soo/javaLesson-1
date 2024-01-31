package jdbc.day3;

import java.util.ArrayList;
import java.util.List;

import project.dao.TblBuyDao;
import project.dao.TblProductDao;
import project.vo.BuyVo;

//CartApp_3 클래스는 오직 개발 프로그램을 실행하는 main 메소드를 중심으로 이것에 필요한
//                   메소드를 static 특성으로 만들었습니다.
public class CartApp_3 {


    private static void showMenu() {
        System.out.println(".".repeat(50));
        System.out.println("[C] 카테고리별 상품 조회      [P] 상품명 검색     [M]나의 구매내역");
        System.out.println("[B] 구매하기   [D] 구매 취소  [Q] 구매 수량 변경  [X] 구매 종료");
        System.out.println("::장바구니::[A] 담기  [L] 목록  [R] 삭제   [Y] 모두 구매 ");
        System.out.println(".".repeat(50));
    }

    private static void showMyPage(String customerid) {
        TblBuyDao buyDao = new TblBuyDao();
        
    }

    private static void showProductListByCategory() {
        TblProductDao productDao = new TblProductDao();
        System.out.println("카테고리 : A1-과일 A2-수입과일  B1-인스턴스  B2-선물세트 C1-과자류");
        System.out.print("카테고리 입력__");
       
    }

    public static void searchProductListByPname() {
        TblProductDao productDao = new TblProductDao();
        System.out.print("상품명 검색어 입력__");
       
    }                    

    private static void addCartItem(List<BuyVo> cart, String customerid) {
        System.out.println(".................. 장바구니 :: 물품 담기 ...................");
        System.out.println("구매할 상품코드 입력하세요.__");
    
        System.out.println("구매할 수량 입력하세요.__");
       
     }

    private static void showCartList(List<BuyVo> cart) {
        System.out.println(".................. 장바구니 :: 목록 보기...................");
       
    }

    private static void removeCartItem(List<BuyVo> cart) {
        System.out.println(".................. 장바구니 :: 물품 삭제 ...................");
        
    }

    private static void buyCartItems(List<BuyVo> cart) {
        System.out.println(".................. 장바구니 :: 물품 모두 구매 ...................");
       
    }

       //상품 목록을 선택한 카테고리에 대해 보여주기  (구매할 상품 조회)
       //또는 상품명으로 검색 (구매할 상품 조회)
       //또는 입력한 아이디로 구매한 구매내역 보여주기 (구매수량 변경 또는 구매 취소 buy_idx 조회)
    public static void main(String[] args) {
      
        List<BuyVo> cart = new ArrayList<>();
        System.out.println("구매할 사용자 간편 로그인 필요합니다.");
        System.out.print("아이디 입력 __");
        String customerid = System.console().readLine();
        System.out.println(customerid + " 님 환영합니다.♡");
        boolean run = true;
        while (run) {       //메뉴 선택 반복
            showMenu();
            System.out.print("선택 >>> ");    
           // int select = Integer.parseInt(System.console().readLine());
           String select = System.console().readLine();
            switch (select) {
                case "M","m":   // 나의 구매내역
                    showMyPage(customerid);
                    break;
                case "C","c":
                    showProductListByCategory();
                    break;  
                case "P","p":
                    searchProductListByPname();    
                    break;
                case "A","a":
                    addCartItem(cart,customerid);
                    break;
                case "L","l":
                    showCartList(cart);
                    break;
                case "R","r":
                    removeCartItem(cart);
                    break;    
                case "Y","y":
                    buyCartItems(cart);     //여러번의 insert를 실행시키는 메소드
                    break;
                case "X","x":
                    run=false;
                    break;                
                default:
                    break;
            }
        }

    }






}   
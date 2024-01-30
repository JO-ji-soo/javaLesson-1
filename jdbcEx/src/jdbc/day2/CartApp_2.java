package jdbc.day2;

import java.util.List;

import project.dao.TblBuyDao;
import project.dao.TblProductDao;
import project.vo.CustomerBuyVo;
import project.vo.ProductVo;

//static 이 많아지면 상속의 특징을 사용할 수 없습니다. 멀티 스레드 환경에 적합하지 않습니다.
//    -> 여기서는 테스트를 위해 static 사용 중입니다.
public class CartApp_2 {

    public static void showMenu() {
        System.out.println(".".repeat(50));
        System.out.println("[C] 카테고리별 상품 조회     [P] 상품명 검색");
        System.out.println("[B] 구매하기   [D] 구매 취소   [Q] 구매 수량 변경  [X] 구매 종료");
        System.out.println(".".repeat(50));
    }

    //상품 목록을 선택한 카테고리에 대해 보여주기 (구매할 상품 조회)
    //또는 상품명으로 검색 (구매할 상품 조회)
    //또는 입력한 아이디로 구매한 구매내역 보여주기 (구매수량 변경 또는 구매 취소 buy_idx 조회)

    public static void main(String[] args) {
        CartApp_2 app = new CartApp_2();
        TblBuyDao dao = new TblBuyDao();
        TblProductDao productDao = new TblProductDao();
        System.out.println("구매할 사용자 간편 로그인 필요합니다.");
        System.out.print("아이디 입력 __");
        String customerId = System.console().readLine();
        System.out.println(customerId+"님 환영합니다.♡");
        boolean run = true;

        while (run) {       //메뉴 선택 반복
            showMenu();
            System.out.print("선택>>>>");
            //int select = Integr.parseInt(System.console().readLine());
            String select = System.console().readLine();
            switch (select) {
                case "M","m":   //[1] 장바구니 담기 - buy 테이블에 insert (1행)
                    List<CustomerBuyVo> result = dao.selectCustomerBuyList(customerId);
                    for(CustomerBuyVo vo : result)
                        System.out.println(vo);
                    break;
                case "C","c":
                    System.out.println("카테고리: A1-과일 A2-수입과일 B1-인스턴스 B2-선물세트 C1-과자류");
                    System.out.println("카테고리 입력____");
                    String category = System.console().readLine();
                    List<ProductVo> productList = productDao.selectByCategory(category);
                    for( ProductVo vo : productList)
                                System.out.println(vo);
                    break;     
                case "P","p":
                    System.out.print("상품명 검색어 입력___");
                    String pname = System.console().readLine();
                    productList = productDao.selectByPname(pname);
                    for( ProductVo vo : productList)
                                System.out.println(vo);
                    break;
                case "B","b":
                    System.out.print("구매하기");
                    System.out.print("상품 목록을 선택하세요:______");
                    productList = productDao.getAllProducts();
                    for (ProductVo vo : productList) 
                        System.out.println(vo);
                    break; 
                case "D","d":
                    

                case "X","x":
                    run=false;
                    break;    
                default:
                    break;
            }
        }

    }
}   // tbl_buy 테이블을 대상을 insert, update, delete 할수 있는 dao 클래스 TblBuyDao.java 
    //         테이블 컬럼과 1:1 대응되는 BuyVo.java  
    //         테이블 PK 컬럼은 buy_idx -> update,delete 의 조건 컬럼입니다.     
    //         insert 에서 시퀀스는 sql 실행할 때와 동일하게 사용합니다.      

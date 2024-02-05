package App;

import dao.*;
import vo.*;

public class RestaurantApp {
    private TblPlaceDao placeDao = new TblPlaceDao();
    private TblPlaceAdressDao placeAdressDao = new TblPlaceAdressDao();
    private TblAreaUnitDao AreaUnitDao = new TblAreaUnitDao();
    private TblMenuDao menuDao = new TblMenuDao();
    private MenuVo menuVo = new MenuVo(0, 0, null, 0);
    private AreaUnitVo areaUnitVo = new AreaUnitVo(0, null);
    private JoinColumnVo joinColumnVo = new JoinColumnVo();
    private PlaceAddressVo placeAddressVo = new PlaceAddressVo(0, null, 0);
    private PlaceVo placeVo = new PlaceVo(0, null, null, 0, null, null, null);

    // private void showRestaurant(String address);//주인찾아요~~ 주석어디갔나요?
    // System.out.println("지역을 입력해주세요. [1. 서울 2. 인천 3. 경기 4. 대구 5. 광주 6. 제주 ]");
    // System.out.print("지역 입력__");
    // String customerid = System.console().readLine();

    public static void main(String[] args) {
        RestaurantApp app = new RestaurantApp();
        app.start();

    }// main

    public void start() {
        boolean run = true;
        while (run) { // 메뉴 선택 반복
            joinAdressBook();
            System.out.print("선택 >>> ");
            // int select = Integer.parseInt(System.console().readLine());
            String select = System.console().readLine();
            switch (select) {
                case "A", "a":
                    findName();
                    break;

                case "B", "b":
                    System.out.println("[B]지역 별로 맛집 찾기");
                    findArea();
                    break;

                case "C", "c":
                    System.out.println("[C]평점 순위 보기");
                    showRate();
                    break;

                case "D", "d":
                    System.out.println("[D] 랜덤 맛집 뽑기");
                    randomFind();
                    break;

                case "E", "e":
                    System.out.println("[E] 맛집 추가");
                    addRasturant();
                    break;

                case "F", "f":
                    System.out.println("[F]맛집 수정");
                    modifyResturant();
                    break;

                case "G", "g":
                    System.out.println("[G]삭제");
                    removeAdressBook();
                    break;

                case "H", "h":
                    System.out.println("[H]종료");
                    System.out.println("프로그램을 종료합니다");
                    run = false;
                    break;

                default:
                    System.out.println("잘못된 번호 입력입니다. 다시확인하시고 입력해주세요.");
                    break;
            }// switch
        } // while
    }// start

    public static void joinAdressBook() {
        System.out.println(".".repeat(50));
        System.out.println("[A] 이름으로 맛집 찾기     [B]지역 별로 맛집 찾기   [C]평점 순위 보기   [D] 랜덤 맛집 뽑기 ");
        System.out.println("[E] 맛집 추가                [F]맛집 수정               [G]삭제                [H]종료");
        System.out.println(".".repeat(50));
    }// joinAdressBook

    public void findName() {
        System.out.println("[A] 이름으로 맛집 찾기");
        String name = System.console().readLine();
       
        System.out.println(placeDao.findName(name));
    }// findName

    public void findArea() {
        System.out.println("[B] 지역으로 맛집 찾기");
        String address = System.console().readLine();
        
        System.out.println(placeAdressDao.findArea(address));
    }// findArea

    public static void showRate() {

    }// showRate

    public static void randomFind() {

    }// randomFind

    public static void addRasturant() {

    }// addRasturant

    public static void modifyResturant() {

    }// modifyResturant

    public void removeAdressBook() {
        System.out.println(".".repeat(50));
        System.out.println("추방할 맛집 ID를 알려주세요");
        System.out.println(".".repeat(50));
        System.out.print("ID >>>");
        int place_seq = Integer.parseInt(System.console().readLine());
        if (place_seq != 0) {
            placeAdressDao.deletePlaceAddress(place_seq);
            System.out.println("맛집이 추방되었습니다. 새로운 맛집을 탐방해주세요");
        }
    }// removeAdressBook

}

package projectD.App;

import java.util.ArrayList;
import java.util.List;

import projectD.Dao.*;
import projectD.Vo.*;

public class RestaurantApp {
    private Tbl_PlaceDao placeDao = new Tbl_PlaceDao();
    private Tbl_PlaceAddressDao placeAddressDao = new Tbl_PlaceAddressDao();
    private Tbl_AreaUnitDao areaUnitDao = new Tbl_AreaUnitDao();
    private Tbl_MenuDao menuDao = new Tbl_MenuDao();
    private MenuVo menuVo = new MenuVo(0, 0, null, 0);
    private AreaUnitVo areaUnitVo = new AreaUnitVo(0, null);
    
    private PlaceVo placeVo = new PlaceVo(0, null, null, 0, null, null, null);
    
    public static void main(String[] args) {
        RestaurantApp app = new RestaurantApp();
        app.start();
    
    }
    public static void joinAddressBook(){
        System.out.println(".".repeat(50));
        System.out.println("[A]이름으로 맛집 찾기  [B]지역 별로 맛집 찾기  [C]평점 순위 보기  [D] 랜덤 맛집 뽑기");
        System.out.println("[E]맛집 추가          [F]평점 수정            [G]종료");
        System.out.println(".".repeat(50));
    }


    public void start () {
        boolean run = true;
        while (run){
            joinAddressBook();
            System.out.println("선택 >>> ");
            String select = System.console().readLine();
            switch(select){
                case "A","a":
                System.out.println("[A]이름으로 맛집 찾기");
                System.out.println("찾으시는 맛집 이름을 입력해주세요__");
                String name = System.console().readLine();
                List<PlaceVo> resultList = placeDao.findName(name); // 결과를 저장
                for (PlaceVo vo : resultList) {
                    System.out.println(vo);
                }
                break;

                case"B","b":
                System.out.println("[B] 지역 별로 맛집 찾기");
                System.out.println("맛집 목록[1.서울 2.인천 3. 경기 4. 대구 5. 광주 6. 제주]");
                System.out.println("찾는 맛집의 지역명을 입력해주세요__");
                String address = System.console().readLine();
                List<PlaceAddressVo> addressList = placeAddressDao.findArea(address);
                for(PlaceAddressVo vo : addressList){
                System.out.println(vo);}
                break;
                
                case"C","c":
                System.out.println("[C] 평점 순위 보기");
                List<PlaceVo> list = placeDao.showRate(3.0);
                for (PlaceVo vo : list) {
                    System.out.println(vo);}
                break;

                case"D","d":
                System.out.println("[D] 랜덤 맛집 뽑기");
                System.out.println("지역을 입력해주세요");
                String place = System.console().readLine();
                System.out.println("리스트 몇개를 출력할지 알려주세요");
                int time = Integer.parseInt(System.console().readLine());
                List<PlaceVo> random = placeDao.randomRestorant(place, time);
                if(random.size()>0){
                    for(PlaceVo vo : random){
                        System.out.println(vo.getName() + "\t" + vo.getOpen_time() + "\t" + vo.getClose_time());
                    }
                }
                break;

                case"E","e":
                System.out.println("[E] 맛집 추가");
                System.out.println("맛집을 추가합니다.");
                System.out.println("추가할 맛집이름을 입력해주세요.");
                String NameE = System.console().readLine();
                break;

                case "F", "f":
                System.out.println("[F] 평점 수정");
                System.out.println("가게명을 입력해주세요");
                String NameF = System.console().readLine();
                System.out.println("수정할 평점을 입력해주세요");
                double newRate = Double.parseDouble(System.console().readLine());
                if (newRate != 0) {
                    placeDao.modifyRate(NameF, newRate);
                    System.out.println("가게 평점이 수정되었습니다.");
                }
                break;

                case "G","g":
                System.out.println("[G] 종료");
                System.out.println("프로그램을 종료합니다");
                run = false;
                break;

                default :
                System.out.println("잘못된 알파벳 입력입니다. 다시 확인하고 입력하세요");
                break;
            }
        }
    }
  
}

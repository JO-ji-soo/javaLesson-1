package collection.day11;

import java.util.ArrayList;
import java.util.List;

import collection.myapp.JavaWord;

//1월14일 저녁 9시까지 제출해주세요. -공유 구글 드라이브
public class CustomerManageApp {
    //JavaWordApp V2 형식으로 하세요.
    private List<Customer> customers = new ArrayList<>();

    private void start() {
        //메뉴 선택 : 등록,검색(이름/그룹), 삭제, 수정, 전체출력(조회)
        System.out.println("메뉴 선택 시작합니다"+"_".repeat(30));
        while (true) {
            System.out.println("\t메뉴를 선택하세요");
            System.out.println("\t 1. 등록 해주세요");
            System.out.println("\t 2. 검색 해주세요");
            System.out.println("\t 3. 삭제 해주세요");
            System.out.println("\t 4. 수정 해주세요");
            System.out.println("\t 5. 전체출력합니다.");
            System.out.println("\t 0. 종료합니다. ");
            System.out.print("선택>> ");

            int select = Integer.parseInt(System.console().readLine());
            switch (select) {
                case 1:
                    addCustomer();
                    break;
                case 2:
                    searchCustomer();
                    break;
                case 3:
                    removeCustomer();
                    break;
                case 4:
                    modifyCustomer();
                    break;
                case 5:
                    printAllCustomers();
                    break;
                case 0:
                    System.out.println("프로그램을 종료합니다.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("유효하지 않은 선택입니다. 다시 선택해주세요.");
            } //switch end
        }//while end
    }//start end

    private void addCustomer(){System.out.println("등록할 고객 정보를 입력하세요.");
        System.out.println("이름: ");
        String name = System.console().readLine();
        System.out.println("전화번호: ");
        String phone = System.console().readLine();
        System.out.print("그룹(1: 일반, 2: VIP, 3: 기타): ");
        int group = Integer.parseInt(System.console().readLine());

        customers.add(new Customer(name,phone,group));
        System.out.println("고객이 등록되었습니다.");
    }//addcustomer end

    private void searchCustomer(){
        System.out.println("::고객 검색 합니다.::");
        System.out.println("검색할 고객 정보를 입력하세요.");
        System.out.print("이름 또는 그룹(1: 일반, 2: VIP, 3: 기타): ");
        String find = System.console().readLine();

        for (Customer customer : customers) {
            if (customer.getName().equalsIgnoreCase(find)){
                System.out.println("검색 결과 : " +customer.getName()
                                +"="+customer.getPhone()+"레벨"+customer.getGroup());
                return;
            }
        }
        System.out.println("찾는 정보가 없습니다.");
        }//searchcustomer end 

    private void removeCustomer(){
        System.out.println("::고객 정보 삭제합니다::");
        System.out.println("고객의 이름을 입력하세요._");
        String find = System.console().readLine();
        boolean isFind =false;                     //단어 존재 유무 확인
        for(int i=0;i<customers.size();i++){
            if(customers.get(i).getName().equals(find)){
                isFind = true;
                System.out.println("인덱스"+ i +"에서 단어를 찾았습니다.");
                System.out.println("삭제하려면 엔터, 취소는 n을 입력하세요.");
                if(System.console().readLine().equals("n"))
                   continue;
                else{
                        //고객 정보 삭제.
                   customers.remove(i); System.out.println("단어 삭제 완료!!");
                }
            } //단어 비교 if end
        } //for end
        if(!isFind)            //isfind==false
            System.out.println("삭제할 단어는 단어장에 없습니다.");
        }//removecustomer end

    private static void modifyCustomer() {
        System.out.println("수정할 고객의 이름을 입력하세요.");
        String nameToModify = System.console().readLine();
    
        for (Customer customer : customers) {
            if (customer.getName().equals()) {
                System.out.println("새로운 전화번호를 입력하세요:");
                String newPhone = System.console().readLine();
                System.out.println("새로운 그룹을 입력하세요(1: 일반, 2: VIP, 3: 기타):");
                int newGroup =Integer.parseInt(System.console().readLine());

                customer.modify(newPhone, newGroup);
                System.out.println("고객 정보가 수정되었습니다.");
                    return;
                }
            }
        }//modifycustomer end    

        private static void printAllCustomers() {
            System.out.println("::고객 목록 출력합니다.::");
            System.out.println(String.format("%20s %22s %22s", 
                                                "name","phone","group"));
            for (Customer customer : customers) {
                System.out.println(String.format("%20s %20s %20d", 
                                        customer.getName(),customer.getPhone(),customer.getGroup()));
            }
        }

    public static void main(String[] args) {
       CustomerManageApp app = new CustomerManageApp();
       app.start();
   }//main end

}//class end

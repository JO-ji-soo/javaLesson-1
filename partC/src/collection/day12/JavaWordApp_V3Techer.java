package collection.day12;

import java.util.ArrayList;
import java.util.List;

import collection.myapp.JavaWord;

/**
 * JavaWordApp_V3 : 객체 지향 프로그래밍은 최대한 객체로 분리시켜서 
 *                  실행되는 환경에 독립적이 되도록 합니다.
 * JavaWord  : 단어 객체
 * JavaWordList : 단어장 객체
 * 
 */
public class JavaWordApp_V3Techer {
    //private : JavaWordList 객체
    private JavaWordList words = new JavaWordList();
    
    //프로그램 실행을 시작하는 메소드
    private void start(){
            words.initialize();           //words 리스트 요소를 몇개만 저장해서 초기화(테스트용)
            //단어 등록,목록,검색,삭제 기능을 메뉴로 구현합니다.
            System.out.println("단어장 프로그램 시작합니다.~~" + "~".repeat(30));
            while(true){
                System.out.println("\t <메뉴를 선택하세요.>");
                System.out.println("\t 1. 단어 등록");
                System.out.println("\t 2. 단어 목록 출력");
                System.out.println("\t 3. 단어 검색");
                System.out.println("\t 4. 단어 삭제");
                System.out.println("\t 5. 프로그램 종료");
                System.out.print("선택 > ");        //메소드에 입력기능이 있을 때는 Scanner 관리가 불편
                int select = Integer.parseInt(System.console().readLine());  //키보드 입력 문자열->정수
                //System.console() : 시스템의 콘솔(표준입출력장치) 객체를 리턴. readLine 입력메소드 실행
                switch (select) {
                    case 1:
                        addWord();          //단어 등록 메소드 실행
                        break;
                    case 2: listWord();  break;    // 단어 목록 조회 메소드 실행
                    case 3: searchWordBy();  break;    // 단어 목록 조회 메소드 실행
                    case 4: removeWord();  break;    // 단어 목록 조회 메소드 실행
                    case 5: 
                        System.out.println("프로그램을 종료합니다.");
                        System.exit(0);     //main 실행을 종료  
                        break;    
                    default:
                        System.out.println("잘못된 선택값 입니다.");
                        //break;
                } //switch end
            }   //while end
    }   //start end

    private void addWord() {
        System.out.println("\t::단어 등록합니다.::");
        //사용자 키보드 입력으로 데이터 생성
        System.out.print("영어 단어 입력하세요. _ ");
        String english = System.console().readLine();
        System.out.print("한글 의미 입력하세요. _ ");
        String korean = System.console().readLine();
        System.out.print("단어 레벨 입력하세요.(1:초급 2:중급 3:고급) _");
        int level = Integer.parseInt(System.console().readLine());

        words.add(new JavaWord(english, korean, level));
        // 테스트 하면서 코드 분석 해보세요.
    }

    private void listWord() {
        System.out.println("\t::단어 목록 출력합니다.::");
        System.out.println(String.format("%-20s %-30s %-20s",
                                            "ENGLISH","KOREAN","LEVEL"));
        words.print();
    }

    // JavaWordList 객체의 메소드를 이용해서 수정해보세요.
     //searchWord 메소드를 업그레이드
     private void searchWordBy() {
        System.out.println("\t::단어 검색합니다.(단어 조회는 1 ,  레벨 조회는 2 )::");
        String find=null;
        List<JavaWord> list=null;       //조회되는 `결과`를 리턴받아 참조할 변수입니다.
        System.out.print("선택 >> ");
        switch (System.console().readLine()) {  //키보드 입력을 변수에 저장하지 않고 직접 swicth에 작성
            case "1":
                System.out.print("검색한 단어를 영문으로 입력하세요. _");
                find = System.console().readLine();
                list = words.searchAllByEnglish(find);
                break;
            case "2" :
                System.out.println("검색할 레벨을 입력하세요. _");
                int level = Integer.parseInt(System.console().readLine());
                list = words.searchAllByLevel(level);
                break;
            default:
                System.out.println("1,2 만 입력하세요.");
                return;
        }
        System.out.println("\t:: 검색 결과 입니다.::");
        if(list.size()==0) 
                System.out.println("찾는 단어가 단어장에 없습니다.");   
        else 
                JavaWordList.print(list);       //static 메소드 실행
    }
    
        //단어 삭제 : 단어장에 동일한 단어가 2번 이상 있는 경우입니다.
    //           삭제하기 전에 if문으로 사용자 확인을 받읍시다.
    private void removeWord() {
        System.out.println("\t::단어 삭제합니다.::");
        System.out.print("삭제할 단어를 영문으로 입력하세요. _");
        String find = System.console().readLine();
        int position = words.indexOfWord(find,0);    //단어의 인덱스를 배열로 리턴
        if(position ==-1)      {        //인덱스 0부터 단어를 찾아서 -1 이면 찾는 단어가 없음.
            System.out.println("삭제할 단어는 단어장에 없습니다.");
            return;
        }   
        while(position !=-1){           // 찾는 단어가 없을때 까지 반목하기
                System.out.println("삭제할 단어 - " + words.getWord(position));
                System.out.print("삭제하려면 엔터, 취소는 n 을 입력하세요._");
                if(!System.console().readLine().equals("n")) {
                    //단어 삭제.
                    words.remove(position); 
                    System.out.println("단어 삭제 완료!!");
                    position--;     // 삭제했을 때는 인덱스값이 position 뒤의 요소들은 모두 -1 씩 감소. 
                }            
                position = words.indexOfWord(find,++position);    
                //position은 찾은 단어 다음 위치부터 다시 찾기
        } 
    }







    public static void main(String[] args) {
        //프로그램 실행하는 객체 생성하고 
        //          (메소드로 기능을 분리할 때 main이 호출하는 static 을 없애기 위함.)
        //         start 메소드 프로그램 실행 내용을 코딩
        JavaWordApp_V3Techer app = new JavaWordApp_V3Techer();
        app.start();
    }

    
    
}
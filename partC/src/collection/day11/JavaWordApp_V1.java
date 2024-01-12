package collection.day11;

import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.SourceDataLine;

import collection.myapp.JavaWord;

 
public class JavaWordApp_V1 {
    //private은 현재 클래스에서만 사용할 목적으로 접근제한
    private List<JavaWord> words = new ArrayList<>();

    //프로그램 실행을 시작하는 메소드
    private void start(){
        initialize();       //words 리스트 요소를 몇개만 저장해서 초기화(테스트)
        //단어 등록, 목록, 검색, 삭제 기능을 메뉴로 구현
        System.out.println("단어장 프로그램 시작합니다"+"~".repeat(30));
        while (true) {
            System.out.println("\t <메뉴를 선택하세요.>");
            System.out.println("\t 1. 단어 등록");
            System.out.println("\t 2. 단어 목록 출력");
            System.out.println("\t 3. 단어 검색");
            System.out.println("\t 4. 단어 삭제");
            System.out.println("\t 5. 프로그램 종료");
            System.out.println("선택>> "); //메소드에 입력기능이 있을때는 Scanner 관리가 불편
            int select = Integer.parseInt(System.console().readLine()); //키보드 입력 문자열 ->정수 (parseInt는 정수로 바꿔주는 것)
            //System.console() 시스템의 콘솔(표준 입출력 장치) 객체를 리턴
            //readLine : 입력메소드
            switch (select) {
                case 1:
                    addWord(); //단어등록 메소드 실행
                    break;
            
                case 2: listWord(); break;//단어 목록 조회 메소드 실행

                case 3: searchWord(); break; //단어검색 메소드 실행
                   
                case 4: removeWord(null); break;//단어 삭제 메소드 실행
                
                case 5:
                    System.out.println("프로그램을 종료합니다.");
                    listWord(); //프로그램 종료 메소드 실행
                    System.exit(0); //main 종료
                    break;
                
                default:
                System.out.println("잘못된 선택값입니다.");
                    break; //switch문 내를 빠져나가는 것이기에 있어도되고 없어도 됨 
            }//seitch end
            
        }//while end
    }//start end

    private void initialize() {    //words 리스트 요소를 몇개만 저장해서 초기화(테스트)
        words.add(new JavaWord("pulic", "공용의", 1));
        words.add(new JavaWord("protected", "보호하는", 1));
        words.add(new JavaWord("iterate", "반복자", 3));
        words.add(new JavaWord("collection", "수집", 2));
        words.add(new JavaWord("application", "응용프로그램", 2));
        words.add(new JavaWord("binary", "2진수의", 3));
        words.add(new JavaWord("pulic", "공동의", 2));

    }
    //단어 삭제 : 단어장에 동일한 단어가 2번 이상 있는 경우입니다.
    //            삭제하기 전에 if문으로 사용자 확인을 받읍시다.
    private void removeWord(JavaWord word){ 
        System.out.println("\t::단어 삭제 합니다.::");
        System.out.println("영어 단어 입력하세요 . _");
        String find = System.console().readLine();
        boolean isFind =false;                     //단어 존재 유무 확인
        for(int i=0;i<words.size();i++){
            if(words.get(i).getEnglish().equals(find)){
                isFind = true;
                System.out.println("인덱스"+ i +"에서 단어를 찾았습니다.");
                System.out.println("삭제하려면 엔터, 취소는 n을 입력하세요.");
                if(System.console().readLine().equals("n"))
                    continue;
                else{
                    //단어 삭제.
                    words.remove(i); System.out.println("단어 삭제 완료!!");
                }
            } //단어 비교 if end
        } //for end
        if(!isFind)            //isfind==false
            System.out.println("삭제할 단어는 단어장에 없습니다.");
        }
    

    private void searchWord() {
        System.out.println("::단어 검색 합니다.::");
        System.out.println("검색한 단어를 영문으로 입력하세요. _");
        String find = System.console().readLine();
        boolean isFind = false;
        for(JavaWord word : words){
            if(word.getEnglish().equals(find)){                  //문자열 비교 equals
                System.out.println("검색 결과 : " + word.getEnglish()
                                        +" = "+word.getKorean()+" 레벨 "+word.getLevel());
                return;              //1) 단어를 한개 찾으면 searchWord메소드 종료//같은 단어를 1번만 저장하게 할 때는 사용
                //isFind=true;      //2) 같은 단어가 2번 이상 저장될 때
            }    
        }
        // if(isFind==false)               //2) if문 조건검사는 같은 단어가 2번이상 단어장에 있을 때 사용
        System.out.println("찾는 단어가 단어장에 없습니다.");               //1) 2) 다 가능한 출력문
    }   //리스트에 없는 단어를 조회한다면? 같은 단어 중복 저장 방법에 따라 위와 같이 할 수 있습니다.

    private void listWord() {
        System.out.println("::단어 목록 출력합니다.::");
        System.out.println(String.format("%20s %22s %22s", 
                                                "ENGLISH","KOREAN","LEVEL"));
        for(JavaWord word : words){
            System.out.println(String.format("%20s %20s %20d", word.getEnglish(),word.getKorean(),word.getLevel()));
        }
    }                           
    private void addWord() {
        System.out.println("\t::단어 등록 합니다.::");
        //사용자 키보드 입력으로 데이터 생성
        System.out.println("영어 단어 입력하세요 . -");
        String english = System.console().readLine();
        System.out.println("한글 의미 입력하세요 . -");
        String korean = System.console().readLine();
        System.out.println("단어 레벨을 입력하세요 . (1. 초급, 2:중급, 3: 고급) _");
        int level = Integer.parseInt(System.console().readLine());

        words.add(new JavaWord(english, korean, level));
    }

    public static void main(String[] args) {
        //프로그램 실행하는 객체 생성하고 start 메소드 프로그램 실행을 코딩
        //메소드로 기능을 분리할때 main이 호출하는 static을 없애기 위함 - static은 꼭필요할때만 만들기
        JavaWordApp_V1 app = new JavaWordApp_V1();
        app.start();
    
    
    }
}
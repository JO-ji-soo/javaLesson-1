package collection.day12;

import java.util.ArrayList;
import java.util.List;

import collection.myapp.JavaWord;

/**
 * JavaWordApp_V3 : 아래의 JavaWordList 를 이용해서 똑같이 메뉴가 동작하도록 
 *                  변경해 봅시다.
 * 이 단어장 프로그램이 다른 환경 (예를 들면, 웹브라우저)에서 동작할 때
 * 단어는 1개, 단어장은 단어 여러개를 갖고 이를 대상하는 메소드를 명시하고
 * 그리고 단어장도 객체로 생성될 수 있게 합니다.
 */

 //최후 정리 : 자바단어장 클래스에 적용될 인터페이스 생성.
public class JavaWordList implements WordList {
    //private : 현재 클래스에서만 사용할 목적으로 접근 제한합니다.
    //필드
    private List<JavaWord> words;
   
    public JavaWordList() {
        System.out.println("최대 단어 저장 개수 : "+WordList.MAX_LENGTH);
        words = new ArrayList<>();
        //initialize();          
    }
   //words 리스트 요소를 몇개만 저장해서 초기화(테스트용)
    void initialize() {
        words.add(new JavaWord("public", "공용의", 1));
        words.add(new JavaWord("public", "공동의", 2));
        words.add(new JavaWord("private", "사적인", 1));
        words.add(new JavaWord("iterator", "반복자", 3));
        words.add(new JavaWord("application", "응용프로그램", 2));
    }

    // 지정된 인덱스 i 의 JavaWord 객체 리턴
    @Override
    public JavaWord getWord(int i) {
       return words.get(i);
    }


    //단어장 전체 리스트 리턴
    @Override
    public List<JavaWord> list() {     //getWords 에서 이름 변경
        return words;
    }

    //단어 추가
    @Override
    public void add(JavaWord word) {
        if(words.size()==WordList.MAX_LENGTH){
            System.out.println("단어장이 꽉 찼습니다. 단어장을 새로 만들어 주세요.");
            return;
        }
        words.add(word);
    }

    //전달받은 영어 단어의 인덱스를 배열로 리턴합니다.-조회 및 삭제 기능에 사용할 새로운 메소드
    //words 리스트의 인덱스 위치 position부터 단어english를 찾기.
    @Override
    public int indexOfWord(String english,int position){
        for(int i=position;i<words.size();i++){
            if(words.get(i).getEnglish().equals(english))
                return i;       //찾으면 인덱스 리턴
        }   
        return -1;
    }

    //단어를 인덱스로 삭제
    @Override
    public JavaWord remove(int index) {
        JavaWord word = words.remove(index);          //삭제한 데이터를 리턴합니다.
        return word;
    }

    //단어 1개 조회(여러개 일때는 처음 1개)
    public JavaWord searchFirstByEnglish(String english) {
        for(JavaWord word : words) {
            if(word.getEnglish().equals(english)) {
                return word;        //인자로 전달된 english 와 같은 word 리턴(메소드 종료)
            }
        }
        return null;            
    }
    
    //단어 목록 조회
    @Override
    public List<JavaWord> searchAllByEnglish(String english){
        List<JavaWord> list = new ArrayList<>();    //검색 결과 저장할 리스트
        for(JavaWord word : words) {
            if(word.getEnglish().equals(english)) {
               list.add(word);          //일치하는 하는 단어를 만날 때마다 저장
            }
        }
        return list;
    }

    public List<JavaWord> searchAllByLevel(int level){
        List<JavaWord> list = new ArrayList<>();    //검색 결과 저장할 리스트
        for(JavaWord word : words) {
            if(word.getLevel()==level ) {
               list.add(word);          //일치하는 하는 단어를 만날 때마다 저장
            }
        }
        return list;
    }

    //인스턴스 메소드 : 인스턴스 필드 words 를 사용하여 동작
    @Override
    public void print(){
        for(JavaWord word : words) {
            System.out.println(String.format("%-20s %-30s %-20s",
                                    word.getEnglish(),word.getKorean(),word.getLevel()));
        }
    }
   
    // 출력 메소드 
    // static 메소드 : 인스턴스 필드를 사용하지 않고 메소드 인자를 받아 동작.
    public static void print(List<JavaWord> list){
        for(JavaWord word : list) {
            System.out.println(String.format("%-20s %-30s %-20s",
                                    word.getEnglish(),word.getKorean(),word.getLevel()));
        }
    }

   
   

}
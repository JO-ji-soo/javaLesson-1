package collection.myapp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

//JavaWord 여러개를 저장할 클래스
//조회기능에 유리한 Map을 사용
public class JavaWordBook {
    //굳이 List 대신 Map을 사용한 이유 : 조회와 삭제를 편하게 하려고
    //조회 이외에 특히 출력에는 map.value()로 value값만 사용.

    //private List<String, JavaWord>wordBook; -> 도 가능/ 그러나 계속 비교해야함.
    private Map<String, JavaWord>wordBook;
    //key : 영단어
    //value : JavaWord (영어,한글,레벨)
    public JavaWordBook(){
        this.wordBook = new TreeMap<>(); //key 값인 영단어 순으로 정렬해 접근
    }

    //getter
    public Map<String, JavaWord> getWordBook() {
        return this.wordBook;
    }

    //단어 추가
    public void addWord(JavaWord word){
        this.wordBook.put(word.getEnglish(),word);
  
    }
    
    //단어 조회
    public JavaWord searchWord(String english){
        return this.wordBook.get(english);

    }
    
    //단어 삭제
    public void removeWord(String english){
        this.wordBook.remove(english);

    }

    //전체 단어 추력하기
    public void wordAllPrint(){
      //TreeMap은 정렬되어 있으므로 Map의 values 를 리스트로 변환하여 출력 메소드로 전환하기
      List<JavaWord> all = new ArrayList<>(this.wordBook.values());
      wordListPrint(all);
    }

    //인자로 전달된 list 출력하기
    public void wordListPrint(List<JavaWord>list){
      System.out.println("~".repeat(20)+"~단어장~"+"~".repeat(20));
      System.out.println(String.format("%-15s %15s\t %s", 
                                    "<english>","<korean>","<level>"));
      for(JavaWord word : list){
        System.out.println(String.format("%-15s %-15s\t %d",
                                    word.getEnglish(),word.getKorean(),word.getLevel()));
      }
    }


    public List<JavaWord> searchWordByLevel1(int level){
      List<JavaWord> result = new ArrayList<>();
      //To Do : 인자로  전달된 level만 results 리스트에 저장하기
      for(JavaWord word : this.wordBook.values()){
        if(word.getLevel()==level)
          result.add(word);

      }
      return results;
    }

}//class



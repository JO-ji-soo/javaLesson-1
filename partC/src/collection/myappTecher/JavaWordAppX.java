package collection.myappTecher;

import java.util.List;
import java.util.Map;

public class JavaWordAppX {

     public static void main(String[] args) {
        
        //단어장을 시작하는 프로그램입니다.
        //1. 단어장을 생성
        JavaWordBookX myBook = new JavaWordBookX();

        //2. 단어 추가
        JavaWordX newWord = new JavaWordX("public", "공용의", 1);
        myBook.addWord(newWord);
        myBook.addWord(new JavaWordX("private", "개인적인", 1));
        myBook.addWord(new JavaWordX("protected", "보호하는", 1));
        myBook.addWord(new JavaWordX("iterate", "반복하다", 3));
        myBook.addWord(new JavaWordX("collection", "수집", 2));
        myBook.addWord(new JavaWordX("application", "응용프로그램", 2));
        myBook.addWord(new JavaWordX("binary", "2진수의", 3));

        //메모장 출력
        myBook.wordAllPrint();

        //3. 단어 조회
        //1) 영어단어 입력하면 찾아주기
        String findText = "";
        JavaWordX result = myBook.searchWord(findText);
        System.out.println(findText + " 조회 결과 : " + result);
        
        //2) List<JavaWord> searchWordByLevel(int level) : 레벨로 조회하기
          List<JavaWordX> list =myBook.searchWordByLevel(3);
          myBook.wordListPrint(list);
        
          //4. 단어 삭제


     }
    
}

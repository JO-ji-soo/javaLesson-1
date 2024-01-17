package io.day13.io.day13;

import java.io.IOError;
import java.io.IOException;

import collection.myapp.JavaWord;
import io.javaword.JavaWordList;

public class ReviewProb {

    public static void main(String[] args) {
        prob_10();
    }

    //8번 문제 예시
    public static void prob_8(){
        JavaWordList words = new JavaWordList("WordBook.txt");
        words.fileLoad();
        words.add(new JavaWord("null", "비어있는", 1));
        words.remove(-9);       //words.remove(10);
        //개발자가 만드는 예외 : 
        //1) 예외가 발생되는 문법오류, 실행오류 같지만 값의 범위를 재현하기 위해 예외 발생
        //2) 기존 발생하는 예외를 새로운 내용으로 변경할 때
    }
    //System.in 표준입력만 사용하여 최대 20바이트의 문자열을 입력받을 수 있는 코드를 작성해보세요.
    //          입력받은 내용은 출력으로 확인도 합니다. 총 라인수 3~4 줄 (ReviewProb.java)
    
    public static void prob_10(){
        byte[] buffer = new byte[20];
        try{
            //최대20바이트 실제 입력한 바이트는 정수값으로  리턴
            int b = System.in.read(buffer);         //입력기능 다양하게 만든 것이 Scanner 클래스
            System.out.println("입력 바이트 수 : "+b);
            //System.out.println("입력한 문자열 : "+new String(buffer));
            System.out.println("입력한 문자열 정수 변환 : "
                                + Integer.parseInt(new String(buffer).trim()));
            Integer.parseInt(new String(buffer));
        }//catch(IOException e){
            catch(IOException | NumberFormatException e){
            //2개의 예외를 처리합니다. 참고 : ||논리적인 OR, |는 비트단위 OR
            System.out.println("IOException 또는 NumberFormatException 예외를 처리합니다.");
            e.printStackTrace();
            /*  
                e.printStackTrace(); 메소드로 실행되는 결과 예시. trace는 추적하다.
                예외 원인을 추적해서 출력.
                Exception in thread "main" java.lang.IllegalArgumentException: 단어장이 가득찼습니다.
                at io.javaword.JavaWordList.add(JavaWordList.java:119)  //보통 오류 발생될 땐, 맨 위에 라인에서 발생
                at io.day13.io.day13.ReviewProb.prob_8(ReviewProb.java:19)
                at io.day13.io.day13.ReviewProb.main(ReviewProb.java:12)
    
             */
        }
        
    }
    
}


package io.day12.day12;

import java.io.File;
import java.io.IOException;

//File 클래스 : 운영체제의 파일시스템 클래스
public class D02CheckedExceptionTest {
   
    public static void main(String[] args) {
        //생성하려는 파일의 이름으로 File 객체를 정의
        //File file = new File("F:\\테스트.md"); //없는 드라이브 지정 -> 예외 발생
        File file = new File("테스트2.md");
        //디렉토리 지정하지 않으면 프로젝트와 같은 폴더에.

        //파일을 생성
        try {
            //if(file.exists())           //파일이 존재하나요?
            System.out.println("파일이 존재하나요?"+file.exists());
            file.createNewFile();       //메소드는 처리해야할 예외가 있습니다.
            System.out.println("파일의 길이 : "+file.length());
        } catch (IOException e) {       //IOException 처리 : 대표적인 체크 익셉션.
            //예외 객체는 변수 e로 참조
            System.out.println("파일 생성에 오류가 발생했습니다.");
            System.out.println(e.getMessage()); // 오류 원인 
        }
        
    }
    
}

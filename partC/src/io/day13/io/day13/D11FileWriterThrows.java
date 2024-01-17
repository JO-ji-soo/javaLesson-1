package io.day13.io.day13;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;

public class D11FileWriterThrows {

    public static void main(String[] args) {
       
        try {
            writeByBuffer();
        } catch (IOException e) {
            System.out.println("파일 출력 예외 : " + e.getMessage());
        }

    }
    public static void writeByBuffer() throws IOException{  //throw 던지다
                                        //Exception을 메소드에서 직접 처리하지 않고 호출한 main에게 떠넘기기
        String filePath = "단어장4.txt";
        int count=0;

        //BufferedWriter bw = new BufferedWriter(new FileWriter(filePath,true));
        BufferedWriter bw = new BufferedWriter(
                            new FileWriter(filePath,
                                           Charset.forName("UTF-8"),
                                           true));
            // 파일의 끝까지 반복
            for(int i=0;i<10;i++) {
                bw.append("안녕하세요요요 "+i+"\r\n");       
                //append 기존 내용 뒤에 추가  => new FileWriter(filePath,true) 생성자에 설정필요.
                // bw.write("안녕하십니까?");   //기존파일에 덮어쓰기
                count++;
            }
            bw.close(); //close 가 중요하다
    }

    public static void writeByPrintWriter() throws IOException{        
        String filePath = "단어장4.txt";
        int count=0;
        File file = new File(filePath);
        // PrintWriter 클래스 특징 : 1)print,println 메소드 사용할 수 있음. 
        //                          2) File 객체를 인자로 합니다.
      
        //  PrintWriter pw = new PrintWriter(new FileWriter(filePath,true))   //append
            PrintWriter pw = new PrintWriter(new File(filePath),Charset.forName("UTF-8"));
            // 파일의 끝까지 반복
            for(int i=0;i<10;i++) {
                  pw.append("할로~"+i+"\r\n");
                 // pw.println("안녕하세요"+i);       
                count++;
            }
        System.out.println("저장한 라인수 : "+count);
        pw.close(); //close 해줘야 함.
    }
}

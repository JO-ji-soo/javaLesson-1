package io.day13.io.day13;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.charset.Charset;

public class D10FileWriter {

    public static void main(String[] args) {
       
        writeByBuffer();

    }
    public static void writeByBuffer(){
        String filePath = "단어장2.txt";
        int count=0;
        try( BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath,true))){
            // 파일의 끝까지 반복
            for(int i=0;i<10;i++) {
                bufferedWriter.append("안녕하세요요요용"+i+"\r\n");                    
                //append 기존 내용 뒤에 추가  //new FileWriter(filePath,true) 생성자에 설정필요.
                //bufferedWriter.wirte("안녕하십니까?"); //기존 파일에 덮어쓰기
                count++;
            }
    } catch (Exception e) { }
        System.out.println("저장한 라인수 : "+count);
    }

    public static void writeByPrintWriter(){        
        String filePath = "단어장3.txt";
        int count=0;
        File file = new File(filePath);
        FileWriter fw = null;
        // print,println 메소드 사용할 수 있음. : 1) print,println 메소드 사용할 수 있음
        //                                       2) File 객체를 인자로 합니다.
        try( 
            //PrintWriter pw = new PrintWriter(new FileWriter(filePath,true))){
            PrintWriter pw = new PrintWriter(new File(filePath),Charset.forName("UTF-8"))
            ){

            // 파일의 끝까지 반복
            for(int i=0;i<10;i++) {
                pw.append("할로~"+i+"\r\n");
                //pw.print("안녕하세요"+i+"\r\n");       
                count++;
            }
            
    } catch (Exception e) { }

        System.out.println("저장한 라인수 : "+count);
    }
}

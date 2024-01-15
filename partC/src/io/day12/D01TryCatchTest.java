package io.day12;

import java.util.Scanner;

public class D01TryCatchTest {

    public static void main(String[] args) {
        //예외 처리 구문 : 비정상적인 종료에 대해 사용자에게 전달.
        //                또는 이후의 명령을 계속 실행하도록 합니다.
        //NumberFormatException, ArrayIndexOutOfBoundsException 는
        //예외처리가 강제가 아닙니다.
        //=> Unchecked Exception. 언체크 익셉션.
        try {
            //예외 가능성이 있는 명령문 작성하기
            indexException();
        } catch(NumberFormatException e){           
            // (인자) : 처리할 예외의 종류 : Exception은 모든 예외.
            //예외가 발생할 때 실행할 명령
            System.out.println("정수는 숫자만 입력하세요.");
        } catch(ArrayIndexOutOfBoundsException e){
            System.out.println("인덱스 범위는 배열의 길이 -1까지입니다.");
            System.out.println(e.getMessage());             //오류 원인
        }
        System.out.println("마지막 명령어 입니다.");
        
    }
    
    public static void indexException(){
        int[] arrays = {11,22,33,44,55};
        System.out.println(arrays[0]);
        System.out.println(arrays[1]);
        System.out.println(arrays[arrays.length]);
    }

    public void numberException(){
        Scanner sc = new Scanner(System.in);
        System.out.println("점수를 입력하세요.");
        int number = Integer.parseInt(sc.nextLine());   //문자열을 정수로 변환
        System.out.println("입력한 값 :" +number);
        sc.close();

    }
}

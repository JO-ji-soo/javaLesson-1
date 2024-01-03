package basic.day4;

import java.util.Scanner;

public class A26Test25 {

  public static void main(String[] args) {
    //A25클래스에 만든 메소드를 사용할 수 있습니다.
    int result = A25MySampleMethod.sumTon(10, 13);
    System.out.println(result);

    //메소드가 private으로 정의되면 다른 클래스에서 사용 못합니다.
    //A25MySampleMethod.checkjumsu(67);  //오류

    long sum = A25MySampleMethod.MultiplyToN(4,10);
    System.out.println(sum);

    int a = A25MySampleMethod.sum1ToN(5);
    System.out.println(a);

    //자바 (또는 다른 프로그래밍언어)로 코딩할 때
    //1. 자바에서 제공하는 클래스와 메소드를 잘 활용하기
    //2. 필요에 따라 여러분은 개발자가 직접 잘 만들어 사용하기

    Scanner sc = new Scanner(System.in);
    System.out.println("시작값 입력하세요.>>> ");
    int start = sc.nextInt();
    System.out.println("마지막값 입력하세요. >>>");
    int end = sc.nextInt();

    System.out.println(start + "~" + end + "까지의 곱하기 결과 :" + A25MySampleMethod.MultiplyToN(start, end));
  }
  
}

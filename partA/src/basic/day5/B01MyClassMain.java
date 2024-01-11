package basic.day5;


import java.util.Arrays;

public class B01MyClassMain {

  public static void main(String[] args) {

    // 정의된 클래스 MyClass1 으로 객체를 만듭니다. - new 연산 사용하기
    MyClass1 my1 = new MyClass1();
    // 객체란 데이터 덩어리. new 연산으로 MyClass1 객체를 저장할 메모리 확보
    // myClass1() 는 생성자 메소드. 무조건 클래스이름과 같아야함.
    //                    ㄴ 메모리에 저장공간을 확보하면서 동시에 실행.

    System.out.println("my1.field1:" + my1.field1); // String
    System.out.println("my2.field1:" + my1.field2); // int
    System.out.println("my3.field1:" + my1.field3); // double 배열
    /*
     * my1.field1:null
     * my2.field1:0
     * my3.field1:null
     * 
     */

    my1.field1 = "Hi 모모";
    my1.field2 = 999;
    my1.field3 = new double[5];
    
    System.out.println("my1.field1:" + my1.field1); // String
    System.out.println("my2.field1:" + my1.field2); // int
    System.out.println("my3.field1:" + my1.field3); // double 배열
    System.out.println("my1.field3 배열의 크기 :" + my1.field3.length);
    System.out.println("my1.field3 배열 요소 값:" + Arrays.toString(my1.field3));



  /*
    *my1.field1:Hi 모모
    *my2.field1:999
    *my3.field1:[D@33c7353a
   * my1.field3 배열의 크기 :5
     my1.field3 배열 요소 값:[0.0, 0.0, 0.0, 0.0, 0.0]
   */

   MyClass1 my2 =new MyClass1();        //새로운 MyClass1 객체를 생성
   System.out.println("my2 해시코드 (초기) :="+my2.hashCode());
   my2.field1="점심 먹으러 갑시다.";
   my2.field2=12345;
   my2.field3=new double[]{34.12,23.99,6.78};
   
   System.out.println("my2 해시코드 (필드값 변경 후) :="+my2.hashCode());
  

    MyClass2 my3 = new MyClass2();

    //MyClass1 err = new MyClass2();  //오류:객체의 타입과 변수의 타입이 불일치
  
    //private : 사적인,개인적인. MyClass2 변수 외에는 사용할 수 없는 필드.
    System.out.println("my1.field1:" + my3.field1); // String
    System.out.println("my2.field1:" + my3.field2); // int
    System.out.println("my3.field1:" + my3.field3); // double 배열






  }

}

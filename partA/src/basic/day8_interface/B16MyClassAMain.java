package object.day8_interface;

public class B16MyClassAMain {
    public static void main(String[] args) {
     
        //인터페이스는 객체 생성 못함.
        // 단 , 익명 내부 타입으로 정의는 가능.
        //InterfaceA ifa = new InterfaceA();

        //구현클래스로 객체 생성
        MyClassA mya = new MyClassA();

        //업 캐스팅 가능합니다.
        InterfaceA ifa = new MyClassA();
        //다운 캐스팅 가능합니다.
        MyClassA temp = (MyClassA)ifa; 

        System.out.println("참조타입 변수와 상관없이 똑같이 실행됩니다.");
        mya.methodA();  
        ifa.methodA();

        



    }



    
}

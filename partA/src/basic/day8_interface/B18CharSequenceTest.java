package object.day8_interface;


//CharSequence 는 자바에서 만든 인터페이스입니다.
//      어떻게 동작하는지 예시를 보겠습니다.
public class B18CharSequenceTest {
    public static void main(String[] args) {
        
        CharSequence csstr = new String("Hello Java");
        CharSequence cssb = new StringBuilder("Hi 자바");

        String temp = "자바 Hello~ Hi Java";
        System.out.println("CharSequence 타입을 인자로 하는 메소드 확인");
        System.out.println("contains : temp 객체에 csstr문자열이 포함되어있는가?");
        System.out.println(temp.contains(cssb));    //false
        System.out.println(temp.contains(csstr));   //false
        System.out.println(temp.contains("Hello~")); //true

        System.out.println("결론 : 메소드 인자가 인터페이스 타입일 때에는");
        System.out.println("여러가지 구현 클래스가 인자로 전달될 수 있습니다.");
        







    }
    
}

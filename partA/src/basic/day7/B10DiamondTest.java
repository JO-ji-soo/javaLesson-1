package object.day7;

public class B10DiamondTest {
    public static void main(String[] args) {
        
    //Diamond 클래스에 extends Shape외에는 코드가 없습니다. 그러나 아래 메소드 실행 가능합니다

    Diamond diamond = new Diamond();
    System.out.println("다이아몬드 너비 :" +diamond.getWidth());
    System.out.println("다이아몬드 높이 :" +diamond.getHeight());
    System.out.println("다이아몬드 넓이 :" +diamond.calculateArea());
    diamond.print();
    //여기까지 확인하면 상속받은 필드값 저장하는 setter 생성가능한지 확인해 봅시다.\
    //접근 한정자 확인하기 

    diamond.round = 3;
    diamond.etc= "테스트";
    System.out.println("변경된 내용 확인: " + diamond.round);
    System.out.println("변경된 내용 확인: " + diamond.etc);

    
}
}
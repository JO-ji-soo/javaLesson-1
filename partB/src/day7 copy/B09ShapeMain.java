package object.day7;

//Shape 와 Triangle 을 객체 생성하고 메소드 테스트 해보세요.
public class B09ShapeMain {

    public static void main(String[] args) {
        Shape sh1 = new Shape("육각형", 80, 80);
        Triangle T3 = new Triangle("삼각", 50, 80, 60);

        System.out.println(sh1.calculateArea());
        System.out.println(T3.calculateArea());
        System.out.println(T3.getAngle());

        System.out.println("~~~~재정의 메소드 실행 확인~~~~~");
        System.out.println(sh1.getShapeName() + "의 넓이" + sh1.calculateArea());
        System.out.println(T3.getShapeName() + "의 넓이" + T3.calculateArea());

        System.out.println("~~~~~부모 클래스가 정의한 메소드 실행확인~~~~~");
        sh1.print();
        T3.print();
        T3.printAngle();
        
        // getWidth, getHeight는 부모클래스 Shape 에서 정의했음. 자식이 실행가능.
        System.out.println("세모 너비 : ?" +T3.getWidth());
        System.out.println("세모 너비 : ?" +T3.getHeight());
        System.out.println("세모 너비 : ?" +T3.getAngle());

        //shape.getAngle();     //부모가 자식객체의 메소드 실행 못함.
    
        //상속에서의 변수참조 타입 ~ 자식클래스 타입, 부모 클래스 타입. 
        //1) 자식 객체를 부모 타입으로 참조하기(*****)
        Shape temShape = new Triangle("세모", 30, 40, 90);

        
        //1)과 2)에 대해 메소드 사용 제한 확인해보세요~~~

        System.out.println("~~~~재정의 메소드 실행 확인~~~~~");
        System.out.println("부모타입 참조이나 객체의 실체는 Triangle 이므로");
        System.out.println("\t ※ 너비는 재정의 메소드로 실행됩니다");
        
        
        
        //Triangle TempTriangle = (Triangle) new Shape("임시도형", 30, 30);
        //강제 캐스팅은 했으나  Triangle에 필요한 인스턴스 필드가 안만들어져서 오류
        System.out.println(temShape.getShapeName() + "의 넓이" + temShape.calculateArea());
        
        System.out.println("~~~~~~자식 클래스에서 정의한 메소드 실행 확인~~~~~~");
        System.out.println("Triangle 자식 객체를 부모타입 Shape로 참조할 때에는 아래 메소드 오류");
        System.out.println("※ getAngle은 부모 타입에는 없는 메소드 입니다");
        //System.out.println("세모 각도 : " + temShape.getAngle()); //오류


        //2)부모 객체를 자식 타입으로 참조할 수 있음?? 없음
        //Triangle TempTriangle = new Shape("임시도형", 30, 30);
        //부모 객체를 자식 타입으로 참조하기 위해 강제 캐스팅.
        
        

        

    }




    
}

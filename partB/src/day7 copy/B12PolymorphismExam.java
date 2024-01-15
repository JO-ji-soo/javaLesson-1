package object.day7;

import object.Test.Square;

/*
 * 다형성이 어떻게 구현되는 것인지 확인하기
 *  ㄴ 자료구조 필요합니다. 배열을 사용해 봅시다.
 *
 */
public class B12PolymorphismExam {

    public static void main(String[] args) {
        
        Shape[] shapes = new Shape[5];

        shapes[0] = new Diamond();
        shapes[0].setShapeName("다이아");
        shapes[1] = new Triangle("세모", 120, 40, 45);
        shapes[2] = new Square();
        shapes[2].setShapeName("스퀘어");
        shapes[3] = new Diamond();
        shapes[3].setShapeName("다이");
        shapes[4] = new Square();
        shapes[4].setShapeName("수퀘");
        
    //여기까지 부모타입 배열에 자식 객체들을 생성해서 참조 시켜놓았습니다.

    //다형성 : 자료구조에 저장된 객체가 하나의 타입 Shape 이지만 실행되는 draw 동작은 모두 다릅니다.
    for(int i=0;i<shapes.length;i++){
        System.out.println(i+ "번 도형입니다.");
        shapes[i].draw();
        //부모타입으로 참조되는 객체들이 재정의된 draw() 메소드를 실행합니다.
        //※ 다형성 ※은 메소드는 한가지로 통일해서 실행하나 결과는 여려형태로 보이는 것 입니다.
        //                      ㄴ 자식클래스가 ※메소드 오버라이드 를 할수 있기 때문에 가능합니다.
    }
    System.out.println("~~~~~자식객체의 실제 타입을 검사하는 instanceof 연산 ~~~~~");
    for(int i=0;i<shapes.length;i++){
        System.out.println("도형:" + shapes[i].getShapeName());
        System.out.println("\tshape[i] instanceof Triangle ?" + (shapes[i]instanceof Triangle));
        System.out.println("\tshape[i] instanceof Diamond ?" + (shapes[i]instanceof Diamond));
        System.out.println("\tshape[i] instanceof Square ?" + (shapes[i]instanceof Square));
    }
    System.out.println("~~~~삼각형 Triangle 객체는 넒이를 구해서 출력하기~~~~");
    //4인덱스 도형을 새로운 Triangle 객체로 참조해서 아래 코드 실행해보세요
    for(int i=0;i<shapes.length;i++){
        if(shapes[i] instanceof Triangle){
            System.out.println("i=" + i +"는 삼각형입니다.넓이 :" + shapes[1].calculateArea());
        
        }
      
    }
        
        System.out.println("~~~~shapes 배열에 저장된 객체 중 다이아몬드를 draw 하기");
        for(int i=0;i<shapes.length;i++){
        if(shapes[i] instanceof Diamond){
            System.out.println(i);
            shapes[i].draw();
        }
        }
        shapes[4] = new Triangle("삼각", 45, 12, 68);
        System.out.println("삼각이면 angle 필드값도 출력합니다.");
        for(int i=0;i<shapes.length;i++){
            if(shapes[i] instanceof Triangle){
                //반드시 실제 객체 Triangle일때만 강제캐스팅 합니다. 그렇지 않으면 오류
                Triangle temTriangle = (Triangle) shapes[i];
            System.out.println("i=" + i +"는 삼각형입니다.넓이 :" + shapes[1].calculateArea());
            temTriangle.printAngle();
        }
    }
        //for 문 반복할떄 알아서 순서대로 1개씩 배열요소를 가져오기. 인덱스 i값을 사용하지 않습니다.
         for(Shape temp : shapes){
          if (temp instanceof Diamond){
                  temp.draw();
          }
        }


        
    }
    
    
}


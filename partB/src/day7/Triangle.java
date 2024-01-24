package object.day7;

/* 
	Shape 클래스로부터 인스턴스 필드와 인스턴스 메소드를 상속받습니다.. (extends) 
 * 
*/
public class Triangle extends Shape{   // extend Shape
	
	
	static final int MAX_WIDTH=90;
	private int angle;				//삼각형의 각도
	
	public int getAngle() {
		return angle;
	}

/*  부모가 정의한 생성자를 호출하여 부모의 필드값을 초기화합니다. 
 *  자식 클래스는 반드시 부모 클래스의 생성자를 호출해야 합니다.
*/
	public Triangle(String shapeName, int width, int height,int angle) {
		//super 변수 : 부모 클래스 객체를 참조하는 변수
		super(shapeName, width, height);
		this.angle=angle;
	}

/* ※오버라이드※
 삼각형 넓이를 구하는 메소드로 calculateArea() 를 수정합니다. 
 부모클래스의 메소드 동작을 자식클래스가 수정(재정의)하는 것을 오버라이드라고 합니다.
 리턴타입과 인자의 형식은 동일해야 합니다.
 @ 표시 : 어노테이션. 컴파일과 프로그래밍 실행에 동작한다. 일종의 주석으로 해석합니다.
				     개발자는 문법적인 오류 체크 도움을 받는다.
이 메소드는 오버라이드 메소드라는 표시. 오버라이드 형식에 맞지 않으면 오류. */
	
	@Override
	public int calculateArea() {
		return super.calculateArea()/2;
		//super. 을 생략할 수 없다
		// return (this.getHeight()*this.getWidth())/2;
	}	
	@Override
	public void draw() {
		System.out.println("세모 " + this.getShapeName()+ "를 그립니다.");
	}
/*	
	@Override
	public void print() {  //오류: final메소드 오버라이드 안됩니다.
		System.out.println("나는 트라이앵글 입니다.");
	}
*/	
	//자식클래스가  추가로 정의한 메소드(Triangle 객체의 인스턴스 메소드)
	public void printAngle() {
		System.out.println("삼각형 각도 : " + getAngle());
	}
}


/*  클래스의 상속 - 자바에서 제공하는 클래스들의 상속관계를 이해하기 위함.  우리가 직접 만드는 것은 몇가지 기능정도.
		ㄴ 자세하게(구체화된) 클래스를 만든다면 .. 삼각형,정사각형,직사각형,사다리꼴...
		ㄴ 구체화할 때 Shape 클래스를 상속받는다. 부모클래스 shape 은 모든 도형들의 공통적인 필드와 메소드를 정의.
		ㄴ 상속받는 자식 클래스는 부모 클래스의 생성자를 호출해서 부모의 필드값을 초기화합니다.
		ㄴ 자식 클래스는 부모 클래스의 메소드를 사용할수 있습니다.
		ㄴ 자식 클래스는 부모 클래스의 필드값을 가져올수 있습니다.
		ㄴ 자식 클래스는 부모 클래스의 메소드를 재정의(오버라이딩) 할수 있습니다.

	↓ Shape 클래스는 추상적인 상태. 모든 도형을 대표하는 클래스로 정의하였습니다.
 */



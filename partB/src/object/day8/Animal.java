package object.day8;

public abstract class Animal {
	public static final String TYPE ="동물";	//상수 기호 TYPE을 문자열 지정.
	
	//필드: 공통적인 특성
	protected String color;
	protected String name;    //동물 이름 예)마루
	
	//생성자
	public Animal() {
		//동작 확인을 위한 출력 : 연습용
		System.out.println("☆새로운 반려동물 가족이 생겼습니다.☆");
	}
	
	public Animal(String name,String color) {
		this();		//기본생성자 메소드 호출
		this.name=name;
		this.color=color;
	}
	
	//추상메소드: 자식 클래스들이 공통적으로 가져야할 기능
	//            ㄴ 자식 클래스들이 반드시 재정의 하도록 강요.
	//		      ㄴ 추상메소드가 있는 클래스는 반드시 abstract class로 정의하기
	//		      ㄴ 추상메소드 실행 내용은 없고 선언만.
	//			  ㄴ 부모가 추상화 시킨 클래스를 자식 클래스는 실체화. 부모클래스 이름으로는 객체 생성 못합니다. 
	public abstract void sound();
	
	
	// getter,
	public String getColor() {
		return this.color;
	}

	public String getName() {
		return name;
	}
	
	//   setter
	public void setColor(String color) {
		this.color = color;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	
	
	@Override
	public String toString() { //this.TYPE은 오류 .this는 인스터스 필드와 인스터스 메소드에만 !!
		return TYPE + "Animal [color=" + color + ", name=" + name + "]";
	}

	
}

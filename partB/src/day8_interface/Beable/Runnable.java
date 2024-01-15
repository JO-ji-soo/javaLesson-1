package object.day8_interface.Beable;

public interface Runnable extends BeAble{

	String run(int speed);		//달리다.
	
	
	default void temporary() {
		//오류가 안생기도록 default 메소드로 정의하고 나중에 구현된 버전의 클래스들이 사용하도록 합니다.
	}
}

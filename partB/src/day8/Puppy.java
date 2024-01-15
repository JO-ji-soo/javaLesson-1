package object.day8;

public class Puppy extends Animal {
	public static final String TYPE ="강아지 ";
	
	public Puppy() {
	}
	
	public Puppy(String name, String color) {
		super(name,color); //부모 클래스 생성자 호출. 인자를 전달합니다.
	}
	
	
	@Override
	public void sound() {
		System.out.println(this.color +" 강아지는 멍멍 🐶🐶하고 짖습니다. ");

	}

	 @Override
	public String toString() {
		return TYPE+"[color=" + color + ", name=" + name + "]";
	}
 
	
}
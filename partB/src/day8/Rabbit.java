package object.day8;

public class Rabbit extends Animal{
    public static final String TYPE = "토끼";

    //생성자 정의가 없으면 - 기본생성자 그리고 자동으로 부모 생성자 super() 호출합니다.
    //복습 : 자식 객체가 생성될 때, 먼저 부모 객체를 생성(생성자 호출)하고 자식 인스턴스 요소가 추가됩니다.
    //       자식 인스턴스 요소가 추가됩니다. 이 때 부모 생성자는 super()이 기본입니다.

    public Rabbit(){

    }
    public Rabbit (String name, String color){
        super(null,color);
    }
    
    @Override
    public void sound(){
        System.out.println(this.color + " 토끼는 🐰🐰 조용합니다 ");

    }


    @Override
    public String toString() {
		return TYPE+"[color=" + color + ", name=" + name + "]";
	}
 








}

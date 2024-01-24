package object.day8;

public class Cat extends Animal{
    public static final String TYPE = "고양이";

    public Cat(){        
    }

    public Cat(String color){
        //super(); //생략 가능. super()는 자식 클래스 생성자에서 기본 호출됩니다.
        this.color=color;
    }
     

    @Override
    public void sound(){
        System.out.println(this.color + " 고양이는 야옹😺😺하고 소리냅니다.");
    }

    @Override
    public String toString(){
        return TYPE+"[color=" + color + ",name=" + name + "]";

    }

    
    


    
}

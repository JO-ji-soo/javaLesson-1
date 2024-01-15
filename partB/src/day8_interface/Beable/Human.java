package object.day8_interface.Beable;

public class Human implements Thinkable,Cookable,Runnable {

    @Override
    public int calculate(int a, int b) {
        int result = 0;
        if(a>=999999 && b>=99999){
            System.out.println("사람이 암산으로 할 수 있는 연산입니다.");
            result=-9999999;
        }else{
            System.out.println("사람이 암산으로 할 수 있는 덧셈입니다");
            result = a+b;
        }
        return result;
    }

    @Override
    public void think() {
        System.out.println("휴먼은 창의적으로 생각할 수 있습니다.\n" + 
        "단, 데이터가 너무 많으면 그냥 포기합니다.");
        
    }

    @Override
    public String beAble() {
        
        return "생각하고 요리하고 달리기도 합니다.";
    }

    @Override
    public void cook(String material) {
        System.out.println(material + "를 사용해서 여러가지 요리를 합니다.");
        
    }

    @Override
    public String run(int speed) {
        
        return "사람은 " + speed + "km/h 로 달립니다.\n 최대속도 10km/h...." ;
    }

    
}

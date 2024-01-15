package object.day8_interface.Beable;

public class Dog implements Runnable{

    @Override
    public String run(int speed) {
        
        return "Dog"  + speed + "km/h 로 달립니다.\n최대속도 50km/h....";
    }
    
    @Override
    public String beAble() {
        
        return "달리기만 합니다";
    }

    
    
}

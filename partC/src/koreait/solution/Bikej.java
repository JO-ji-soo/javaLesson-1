package solution;

public class Bikej extends Productj{
    private int speed;

    public Bike(int price, String prdName, int speed){
        this.price = price;
        this.prdName = prdName;
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String ride(){
        return "당신은 이것을 시속"+speed+"로 탈 수 있습니다.";
    }
    
    @Override
    public String sell(Object object){
        return String.format("[%s] 행사_%d%%인하", prdName,object);

    }

}

public class ELectronicsj extends Productj {
    public Bike(int price, String prdName){
        this.price = price;
        this. prdName = prdName;
    
    }

    private double kwh;

    public double getKwh() {
        return kwh;
    }

    public void setKwh(double kwh) {
        this.kwh = kwh;
    }
    
    public double power(){
        return kwh = kwh*24;
    }

    @Override
    public String sell(Object object){
        return String.format("[%s] 증정_%s", prdName,object);
    }

    

}


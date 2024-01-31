package solution;

public class Bikej {
    //1-[4]
    private int speed;
    //1-[3]
    public Bike(int price,String prdName,int speed) {
        this.price = price;
        this.prdName = prdName;
        this.speed = speed;
    }
    //1-[4]
    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    //1-[5]
    public String ride() {
        return ("당신은 이것을 시속"+this.speed+"km로 탈 수 있습니다.");
    }
}

public class ELectronicsj {
    //1-[7]
    public double power(){
        return this.kwh*24
    }
    //1-[6]
    private double kwh;
   
    public double getKwh() {
        return kwh;
    }
    public void setKwh(double kwh) {
        this.kwh = kwh;
    }
    

}

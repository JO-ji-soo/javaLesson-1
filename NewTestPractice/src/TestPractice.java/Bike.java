package TestPractice.java;

import javax.sound.sampled.SourceDataLine;

public class Bike {
    //1-[3]
    public Bike(String prdName, int price, int speed);
        this.prdName = prdName;
        this.price = price;
        this.speed = speed;
    //1-[4]
    private int speed;
    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    //1-[5]
    public String ride;
    System.out.println("당신은 이것을 시속"+this.speed+"로 탈 수 있습니다");
    
}

class Electronics {
    //1-[6]
    private double kwh;

    public double getKwh() {
        return kwh;
    }

    public void setKwh(double kwh) {
        this.kwh = kwh;
    }
    //1-[7]
    public double power;

    


    
}
package koreaIt.test;

import javax.print.DocFlavor.STRING;

public class Bike extends Product {
    private String prdName;
    private int price;
    //1번 문제 [4]
    private int speed;
    
    //1번 문제 [3]
    public Bike(String prdName, int price, int speed){
        this.prdName = prdName;
        this.price = price;
        this.speed = speed;
    }

    //1번 문제 [4]
    public int getSpeed() {
        return speed;
    }

    //1번 문제 [5]
    public String ride(){
     return "당신은 이것을 시속" +speed+ "km로 탈 수 있습니다.";
    }

    @Override
    public String sell() {
        int discount = (int);
        return String.format("[%s] 행사 -%d%% 인하", prdName, discount);
    }    

    @Override
    public String toString() {
        return String.format
        ("Bike {price=%d, prdName='%s', speed=%d}", price, prdName, speed);    
    }

}//bike class end

public class Electronics extends Product{
    private int price;
    private String prdName;
    private double kwh;

    ////1번 문제 [3]
    public Electronics(int price, String prdName, double kwh){
        this.price = price;
        this.prdName = prdName;
        this.kwh = kwh;
    }
}//electronics class end


package koreaIt.test;

public abstract class Product {


public Product(String prdName, int price){
    this.prdName = prdName;
    this.price = price;
}

//필드 : 공통적인 특성    
protected String prdName;
protected int price;

//추상메소드
public abstract void sell();

//getter
public String getPrdName() {
    return this.prdName;
}

public int getPrice() {
    return this.price;
}

}

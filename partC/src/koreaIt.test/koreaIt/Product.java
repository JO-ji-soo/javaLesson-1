package koreaIt.test;

public abstract class Product {

    //1번 문제 [1]
    protected String prdName;
    protected int price;

    public Product(String prdName, int price){
        this.prdName = prdName;
        this.price = price;
    }

    //1번 문제[2]추상메소드
    public abstract void sell();

    
    @Override
    public String toString() {
        return String.format
        ("Product {price=%d, prdName='%s'}", price, prdName);
    }

    //getter
    public String getPrdName() {
        return this.prdName;
    }

    public int getPrice() {
        return this.price;
    }
    
    public void setPrdName(String prdName) {
        this.prdName = prdName;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}



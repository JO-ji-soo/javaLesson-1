package koreait.solution;

public abstract class Product {
    // 1 - [1]
    protected int price;
    protected String prdName;   

    // 1 - [2]
    public abstract String sell(Object object);     
    @Override
    public String toString() {
        return "prdName=" + prdName + ", price=" + price;
    }

    
}


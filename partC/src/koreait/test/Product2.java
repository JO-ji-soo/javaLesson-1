package test;

import solution.ELectronicsj;

public class Product2 {

    public static void main(String[] args) {
        
        Product[] cart = new Product[10];

        cart[0]=new Bike(123000,"MTB",25);
        cart[3]=new Bike(99000,"삼천리",15);

        cart[1]=new ELectronics(35000,"USB");
        cart[1]=new ELectronics(527000,"스마트TV");
        cart[1]=new ELectronics(225000,"lg냉장고");

        ELectronics tv = null;
        if(cart[5] instanceof ELectronics){
            tv=(ELectronics) cart[5];
            tv.setKwh(0.9);
            System.out.println(tv.power());
        }else 
            { System.out.println("Electronics 타입으로 변경 불가");
    }
        for(Product p : cart){
            if(p!=null && p.price >=10000)
               System.out.println(p);
            }
        

        for(Product p : cart){
            if(p!=null && p instanceof Bike){
            Bike bike = (Bike)p;
            System.out.println(bike.ride());
            }
        }

        cart[3].sell(20);
        System.out.println(cart[3].sell(20));

        cart[5].sell("사운드바");
        System.out.println( cart[5].sell("사운드바"));


        

        
    }


    
}

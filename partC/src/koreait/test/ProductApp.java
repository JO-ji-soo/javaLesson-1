package koreait.solution;

public class ProductApp {
    public static void main(String[] args) {
        //2-[1]
        Product[] cart = new Product[10];
        cart[0] = new Bike(123000, "MTB", 25);
        cart[3] = new Bike(99000, "삼천리", 15);
        cart[1] = new ELectronics(35000, "USB");
        cart[5] = new ELectronics(527000, "스마트TV");
        cart[7] = new ELectronics(2250000, "lg냉장고");

        //2-[2]
        //현재 부모타입으로 참조하는 것을 자식타입으로 변경 (다운캐스팅)
        ELectronics tv =null;
        //다운캐스팅은 안전하게 타입체크
        if (cart[5]instanceof ELectronics) {
            tv =(ELectronics) cart[5];        
            tv.setKwh(0.9);
            System.out.println(tv.power());
        }else {System.out.println("Electronics 타입으로 변경 불가");}
        

        //2-[3]
        //->반복문 실행시 반드시 null이 아닌것만 하도록 합니다.
        //->null이면 메소드 실행 예외 발생 NullPointerException
        try {
            for (Product p : cart) {
                if (p !=null && p.price>=100000) {
                    System.out.println(p);
                }
            }
        } catch (NullPointerException e) {}
        
        //2-[4]
    }
}

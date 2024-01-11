package basic.day6;

public class B06ProductMain {

  public static void main(String[] args) {
  
    //product 객체를 4개 만들어보겠습니다.
    Product snack = new Product("새우깡", 1200, "농심", new String[3]);
    Product drink = new Product("칠성사이다", 2200, "롯데", new String[3]);
    Product fruit = new Product("부사", 12000, "우리농원", new String[3]);
    Product icecream = new Product("투케더", 7000, "빙그레", new String[3]);
    
    System.out.println(snack);
    System.out.println(drink);
    System.out.println(fruit);
    System.out.println(icecream);
      
    
    /* 
       object.day6.Product@2f92e0f4 - 2f92e0f4은 객체 참조값(식별값)-> 주소라고 부릅시다.
       object.day6.Product@28a418fc - object.day6.Product 는 패키지랑 클래스이름
       object.day6.Product@5305068a
       object.day6.Product@1f32e575
      */

      System.out.println(snack.getData());
      System.out.println(drink.getData());
      System.out.println(fruit.getData());
      System.out.println(icecream.getData());

      //퀴즈 snack의 etc 필드 배열요소 0번에 "10개 묶음" 문자열을 저장하세요.
    String[] temp = snack.getEtc();   //가져온 값 어떻게 저장??
    temp[0]="10개 묶음";
    System.out.println(snack.getData());
  
    // snack.setPrice(1000); //set 메소드 없음 -> 오류
    // snack.price = 1000;  // private -> 오류
     
    Product[] mycarts = new Product[5];    //정수 5개를 저장합니다.
    //Product 객체 배열 - Product 타입이로 만들어진 객체의 참조값 저장 배열
    mycarts[0]=drink;
    mycarts[1]=icecream;
    //mycarts[2]=drink;
    mycarts[3]=fruit;
    mycarts[4]=snack;
    System.out.println("~~~~mycarts~~~~~~~");
    //배열이므로 반복문으로 출력할 수 있습니다. - getData()메소드사용
    for(int i=0;i<mycarts.length;i++){
      if(mycarts[i] !=null)
      
      System.out.println(mycarts[i] .getData()); 
      //mycarts[i]가 null 일 때에는 메모리 할당이 안된상태. 메소드 사용불가
      
      


    }
  
    }

  
}

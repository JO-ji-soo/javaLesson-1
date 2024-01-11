package basic.day6;

public class HomeStringFormat {

    public static void main(String[] args) {
        
    String name = "Eunha";
    int age = 3;

     System.out.println(String.format("제 이름은 %s 이고 %d 살입니다.",name, age));
    
     System.out.println(String.format("%B,%b", age,name));
    int money = 5000;
    
    System.out.println(String.format("$%, d", money));

    int number = 123;
    System.out.println(String.format("%d", number));
    System.out.println(String.format("%4d", number));
    System.out.println(String.format("%04d", number));
    System.out.println(String.format("%014d", number));

    System.out.println(String.format("%s",name));
    System.out.println(String.format("%9s",name));

    double n = 123.123;

    System.out.println(String.format("%f", n));
    System.out.println(String.format("%12f", n));

    
    
  }



}
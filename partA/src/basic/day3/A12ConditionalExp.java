package basic.day3;

public class A12ConditionalExp {
  
   public static void main(String[] args) {

        /*
         * 조건식은 연산의 결과가 true/false로 나오는 연산식을 말한다.
         * 관계연산 : >, <, >=, <=, ==, !=
         * 논리연산 : &&(그리고), ||(또는), !(NOT)
         * 위의 2가지 연산의 결과는 boolean 타입으로 결과값이 나온다.
         * 
         */    
    
    int age = 23;

    System.out.println(":::::::::::::::::age=23::::::::::::::::");
    System.out.println("나이가 20세 이상인가 ? "+(age>=20));
    System.out.println("나이가 20세 미만인가 ? "+(age<20));
    System.out.println("나이가 20세 이하인가 ? "+!(age>=20));
    System.out.println("나이가 20대 인가 ? " +(age>=20 && age<30));  
    System.out.println("나이가 20대가 아닌가 ? " +!(age>=20 && age<30));  
    System.out.println("나이가 20대가 아닌가 ? " +(age<20 || age>=30));  
    
    
    char ch = 'F';
    System.out.println("\n::::::::::::::::ch='F'::::::::::::::::");
    System.out.println("ch가 대문자인가 ? "+(ch>='A' && ch<='Z'));
    System.out.println("ch가 소문자인가 ? "+(ch>='a' && ch<='z'));
    System.out.println("ch가 영문자인가 ? "+((ch>='A' && ch<='Z') || (ch>='a' && ch<='z')));
    System.out.println("ch가 숫자인가 ? "+(ch>='0' && ch<='9'));
    System.out.println("ch가 숫자가 아닌가 ? "+!(ch>='0' && ch<='9'));

   }
}
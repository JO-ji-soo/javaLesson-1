package basic.day6;

public class Randomtest {
  public static void main(String[] args) {
    
    System.out.println("난수(컴퓨터가 만들어주는 임의값) - random"+Math.random());
    System.out.println("난수(컴퓨터가 만들어주는 임의값) - random"+Math.random());
    System.out.println("난수(컴퓨터가 만들어주는 임의값) - random"+Math.random());
    System.out.println("난수(컴퓨터가 만들어주는 임의값) - random"+Math.random());
    System.out.println("난수(컴퓨터가 만들어주는 임의값) - random"+Math.random());
      
        int start =11 ; int end = 99;
        for(int i =0;i<10;i++){
        int temp = (int)(Math.random()*(end-start+1))+start;
        System.out.println("1~45 범위의 난수 :" + temp);
        }
  }
}

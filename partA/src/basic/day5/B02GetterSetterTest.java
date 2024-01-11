package basic.day5;

public class B02GetterSetterTest {

  public static void main(String[] args) {
    
      MyClass2 momo = new MyClass2();
      //System.out.println("My Class2 의 field 값 :" + momo.getField1());
      momo.setField1("나는 모모");
      System.out.println("My Class2 의 field 값 :" + momo.getField1());
      String message = "WELCOME";
      momo.setField1(message);
      System.out.println(momo.getField1());
      
      System.out.println("\nMy Class2 의 field2 값 :"+ momo.getField2());
      momo.setField2(398);
      System.out.println("My Class2 의 field2값: "+ momo.getField2());
      System.out.println("\n지금까지의 momo 객체 값들은.....");
      momo.printData();
      int test =1212;
      momo.setField2(test);
      System.out.println("My Class2 의 field2값: "+ momo.getField2());


      
      momo.printData();

      System.out.println("~~~~~field3은 double 배열 타입입니다.~~~~~~~");
      double[] dArray = momo.getField3();
      momo.printData();
      System.out.println("field3 :" + momo.getField3());
      System.out.println("field3 :" + dArray);

      double[] tempArray = {1.2,3.44,67.12};
      momo.setField3(new double[5]);
      System.out.println("변경된 field3 확인합니다");
      momo.printData();
    
      System.out.println("변경된 field3을 확인합니다");
      momo.setField3(tempArray);
      momo.printData();

      //setField3을 변수로 전달했을 때
      tempArray[1]=3.1415;   //변경된 값이 momo 객체에도 반영되는지 확인
      System.out.println("변경된 field3을 확인합니다");
      momo.printData();




    } 
  
}

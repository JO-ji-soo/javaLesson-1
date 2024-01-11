package basic.day6;

public class MyClass5 {

    private String field1;
    private int field2;
    private double[] field3;
    
    
    //모든 필드값을 초기화해야만 객체가 생성되는 클래스 입니다.
    //          왜냐하면, 기본생성자를 사용할 수 없습니다.
    //          only 아래 형식의 생성자만 사용할 수 있습니다.
    public MyClass5(String field1,int field2, double[] field3) {
        this.field1=field1;
        this.field2=field2;
        this.field3=field3;
    }

    //getter
    public String getField1() {
        return field1;
    }

    public int getField2() {
        return field2;
    }

    public double[] getField3() {
        return field3;
    }

   //setter가 없으면? 초기값이 설정된 후 모든 필드값을 변경할 수 없는 객체가 됩니다.
   //                                  ==> 불변 객체 

    
}

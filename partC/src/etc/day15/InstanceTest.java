package etc.day15;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * InnerMyCalendar
 */
public class InstanceTest {

    public static void main(String[] args) {
        MyCalendar my1 = MyCalendar.getInstance();
        // MyCalendar my2 = new MyCalendar();
        // MyCalendar my3 = MyCalendar.object;
        YourCalendar you1 = YourCalendar.of("2024","03");

        Member member = new Member("kkk", 23, 1110);
        System.out.println(member.getAge());
    }
    
}

//main 메소드는 1개 파일에 하나만 있어야 합니다.
//public 클래스도 1개 파일에 하나만 있어야 합니다.
// ㄴ 위의 2가지 지키고 1개 파일에 클래스는 여러개 만들 수 있습니다.

@Getter
@Setter
@NoArgsConstructor          //기본생성자
@AllArgsConstructor
@ToString
@EqualsAndHashCode

class Member{
    private String name;
    private int age;
    private int point;

    //lombok 라이브러리 : 매번 작성되는 아래 메소드를 자동으로 만들어 줍니다.
    //커스텀 생성자
    //기본 생성자
    //getter //setter
    //tpString
    //hashcode 와 equals 재정의
}

class MyCalendar {
    private static MyCalendar object = new MyCalendar();
    //필드가 현재 클래스의 타입. 미리 생성자로 객체를 만듭니다.

    private MyCalendar() {      //생성자는 private. 다른 클래스에서 사용 못함.
    }

    public static MyCalendar getInstance(){
        //미리 만들어진 현재 클래스 타입의 객체를 리턴
        return object;
    }

}

class YourCalendar {
    private String month;
    private String day;

    private YourCalendar(){}         //다른 클래스에서 new연산 사용 못함.

    public static YourCalendar of(String month, String day){
        YourCalendar result = new YourCalendar();
        result.month = month;
        result.day = day;
        return result;
    }

    public String getDay() {
        return day;
    }

    public String getMonth() {
        return month;
    }
}

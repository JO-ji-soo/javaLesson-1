package collection.day11;

//고객 정보 클래스
public class Customer {
    private String name;
    private String phone;
    private int group;      //1:일반    2:vip   3:기타

    //커스텀 생성 : 3개 필드 초기화
    public Customer(String name, String phone, int group){
        this.name = name;
        this.phone = phone;
        this.group = group;
    }

    //getter
    public String getName() {
        return name;
    }
    public String getPhone() {
        return phone;
    }
    public int getGroup() {
        return group;
    }

    //setter X

    //정보 변경 메소드
    public void modify(String phone,int group){
        this.phone = phone;
        this.group = group;
    }

    //toString(테스트용)
    @Override
    public String toString() {
        return "Customer{"+"name="+name+"phone"+phone+"group"+group+'}';
    }
    
   
}

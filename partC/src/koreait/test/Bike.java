package koreait.solution;
//객체의 구성요소 : 인스턴스 필드와 인스턴스 메소드
//클래스 구성요소 : 객체의 구성요소 + static 메소드와 필드
//클래스는 객체가 만들어지는 인스턴스 요소를 정의하는 상위 개념
public class Bike extends Product{
    //1 - [4]
    private int speed;
    //1-[3]
    public Bike(int price,String prdName, int speed) {
        //super(); //자식클래스는 부모 생성자 반드시 호출 한다. -super()는 생략 가능하다
        super.price =price;
        super.prdName =prdName;
        //price,prdName은 protected 필드이므로 자식은 직접 접근 가능
        this.speed =speed;
    }
    //1-[8]  추상클래스 상속 받았으므로 반드시 추상메소드 구현 (재정의)
    @Override
    public String sell(Object object) {
            return String.format("[%s]행사- %d %% 인하", this.prdName,object);
    }

    //1 - [4]
    public int getSpeed() {
        return speed;
    }
    //1 - [4]
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    //1-[5] getter,setter,ride 메소드: 인스턴스 필드를 대상으로 처리 기능으 갖습니다. 인스턴스 메소드 객체 = 인스턴스
    public String ride() {
        return "당신은 이것을 시속 "+this.speed+"km로 탈 수 있습니다";
    }

    //1-[10]
    @Override
    public String toString() {
        return "Bike [ "+super.toString()+", speed=" +speed + " ]";
    }
    
}

/**
 * ELectronics
*/
class ELectronics extends Product {



    //price,prdName 필드값만 초기화 - 생성자
    public ELectronics(int price,String prdName){
        super();
        this.price =price;
        this.prdName =prdName;
    }
    //1-[9]
    @Override
    public String sell(Object object) {
            return String.format("[%s]증정- %s", this.prdName,object);
    }
    //1-[6]
    private double kwh;
    //2-[2]에서 필요해서 getter setter 만들어야 함
    public void setKwh(double kwh) {
        this.kwh = kwh;
    }public double getKwh() {
        return kwh;
    }
    //1-[7]
    public double power(){
        return this.kwh*24;
    }
    
    //1-[10] Product 클래스에서 toString 재정의 한 것을 자식클래스가 또(다시) 재정의
    @Override
    public String toString() {
        return "ELectronics [ "+super.toString()+", kwh=" + kwh + " ]";
    }
}

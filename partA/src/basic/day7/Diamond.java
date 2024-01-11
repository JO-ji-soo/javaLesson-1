package object.day7;

//Shape 클래스 상속 예시 2
public class Diamond extends Shape{

//자식이지만 부모가 private 으로 했으므로 오류
//public void setShapeName(String shapeName){
    //this.shapeName = shapeName;



//부모가 protected로 선언한 필드는 자식이 자유롭게 접근 가능함
public void setetc(String etc){
    this.etc = etc;
}
 public void setround(int round){
    this.round = round;
 }


 @Override
 public void draw() {
     System.out.println("다이아몬드 " + this.getShapeName()+ "를 그립니다.");
 }






//생성자 정의가 명시적으로 없으면 기본생성자를 실행합니다.
// 자식 클래스는 부모 클래스 기본 생성자를 먼저 실행합니다
    
}
/*
 * 접근 한정자
 * public       : 모두에게 공개
 * private      : 모두에게 비공개 . 같은 클래스 안에서만 사용
 * protect      : 같은 패키지 클래스와 다른 패키지인 경우는 자식에게만 공개
 *                   ㄴ Shape의 etc는 자식인 Triangle, Diamond 에게는 공개 /같은 패키지 B10Diamond Test 에게도 공개
 *                   ㄴ 그 외의 경우는 비공개. 다른 패키지이지만 자식 클래스라면 공개  
 * 아무것도 안씀 : 거의 사용하지 않습니다. 같은 패키지 클래스에게만 공개
 *  (default)                 ㄴ object.day7 패키지 클래스에게는 모두 공개 /그 외에는 숨기기
 * 
 */                  
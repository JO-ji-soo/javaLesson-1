package object.day8;
//추상클래스 Animal 테스트
public class B15AbstractTest {

        public static void main(String[] args) {
            
            //Animal animal = new Animal(); 
            //new 객체생성 못합니다. 이유: 추상클래스

            //Anonymous Inner Type : 클래스 이름이 없는 내부 클래스 형식 
            Animal animal = new Animal() {   // 강요된 추상메소드 재정의하면서 내부 클래스 정의(일회용)
                @Override
                public void sound() {
                    System.out.println("익명으로 만들어진 동물 클래스 : 소리는 모름." );
                    
                }
            };
            animal.sound();
            System.out.println("animal toString=" + animal);

            Puppy puppy = new Puppy("푸들이", "브라운");
            puppy.sound();
            System.out.println("puppy toString =" + puppy);

        }
        //toString을 재정의 하지 않으면 부모 toString이 실행되고 부모의 TYPE 상수값 출력
        //static 필드 또는 메소드는 객체의 툭장에 적용되지 않습니다.


    }

package object.day9;

public class Student {
    private String name;
    private int age;
    
    public Student(String name, int age){
        this.name = name;
        this.age = age;
    }

        
        public int getAge() {
            return age;
        }

        public String getName() {
            return name;
        }

    /* 
     * Member 클래스 compareTo 의 문제점. 비교 기준 또는 정렬방법(오름,내림) 을 변경하려면 클래스 내부의
     *              compareTo 메소드 구현의 return 을 변경해야 합니다. Member를 사용한 
     * 
     */ 

        @Override
        public String toString(){
            return String.format("Students[name=%s,age = %d]\n", this.name,this.age);

        }









    }


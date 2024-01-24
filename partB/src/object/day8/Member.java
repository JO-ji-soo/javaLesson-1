package object.day8;

public class Member {
    protected int age;
    protected String name;

    public Member(int age, String name){
        this.age = age;
        this.name = name;

    }
    //다형성 예시 : 메소드 인자가 부모 타입일 때, 실제 객체는 여러 자식 객체가 될 수 있습니다.
    //AND 연산 특징 : 참 && 참 = 참, 참 && 거짓 = 거짓, 거짓 && 참 = 거짓, 거짓 && 거짓 = 거짓   
    //OR 연산 특징 :  참 || 참 = 참, 참 || 거짓 = 참, 거짓 || 참 = 참, 거짓 || 거짓 = 거짓
         public boolean isAdopt(Animal animal){
            if(animal instanceof Puppy && age >=15)
             return true;
            else if(animal instanceof Cat && age >=18)
             return true;
            else if(animal instanceof Rabbit && age >=13)
             return true;
            else if(age>=20)
             return true;
            else 
             return false;
        }
    
        // public boolean isAdopt(Animal animal){
        //  if(animal instanceof Puppy)
        //  return this.age>=15;
        // else if(animal instanceof Cat)
        // return this.age>=18;
        // else if(animal instanceof Rabbit)
        //     return this.age>=13;
        // else
        //     return this.age>=20;
        // }


    // public boolean isAdopt(Animal animal){
    //     boolean isAdopt;
    //     if (animal instanceof Puppy){
    //         isAdopt = this.age >=15;
    //     }else if (animal instanceof Cat){
    //         isAdopt = this.age >=18;
    //     }else if (animal instanceof Rabbit){
    //         isAdopt = this.age >=13;
    //     }else{
    //         isAdopt= this.age >=20;
    //     }
    //     return isAdopt;
    
        
        

    }


    


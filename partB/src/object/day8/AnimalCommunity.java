package object.day8;


public class AnimalCommunity {

	public static void main(String[] args)  {
		System.out.println("~~~~여기는 유기동물 분향소입니다~~~~~");
			Animal[] animals = new Animal[10];
			animals[0] = new Puppy("푸들이","브라운");
			animals[1] = new Cat("그레이");
			animals[2] = new Rabbit();
			animals[2].setColor("화이트");
			animals[3] = new Puppy("말티즈","화이트");

			//퀴즈 : 아래 객체를 배열 요소에 대입했습니다. 수정이 필요한 코드는?
			animals[7] = new Animal(){
				static final String TYPE = "새";
				@Override
				public void sound(){
					System.out.println("앵무새는 안녕~~ 하고 말 합니다.");
				}	
				@Override
				public String toString(){
					return TYPE+"[color=" + color + ".names=" + name +"]";
				}

			};
			animals[7].setName("앵무새");
			animals[7].setColor("빨강");

			System.out.println("\n[[반려동물 목록을 보여드리겠습니다.]] \n");
			for(int i=0;i<animals.length;i++) {
				if(animals[i]== null)   	
				//break;       //첫번째로 null을 만나면 break
				continue;      //null을 만나면 다음 명령어를 실행안하고 for 문 i++부터 다시 시작합니다.
					animals[i].sound();		//null 일때 메소드 실행하면 오류
			}	
			
	//	모모회원이 동물 보호소의 모든 동물들을 분양 받을 수 있는지 셀프 체크
	//  동물 보호소 규정(비지니스 로직)
	//	 ㄴ강아지는 15세이상, 고양이는 18세이상, 토끼는 13세 이상 그 이외는 20세 이상 분양받을 수 있습니다.			
	//	 ㄴMember 클래스 isAdopt 메소드에서 실행. -> instanceof 연산 사용	
		String name="모모";
		int age = 17;
	    Member member = new Member(age, name);	//Member 클래스 인스터스 필드는 age, name 2개
		
		StringBuilder sb = new StringBuilder(name);//String은 문자열 연결결과 다른 문자열이 나오면 객체 새로만들어 저장
		//String은 불변객체(문자열 변경 못함), StringBuilder는 가변 객체 (문자열 변경 가능.문자열 추가연산결과 동일 객체에 저장)
		sb.append(" 회원님 \n");		//message += "회원님\n"
		//boolean result;
		for(int i=0;i<animals.length;i++) {
			if(animals[i]!=null){	//배열요소에 참조값이 더 이상 없으니 break 하기
			 //result =member.isAdopt(animals[i]); //인자를 Animal 타입으로 전달받는 메소드 (다형성 예시)
			 sb.append(animals[i].toString());		//message += animals[i].toString()
			if(member.isAdopt(animals[i])) { //if(result) 대신에 직접 메소드를 실행하고 리턴 받아 검사
				sb.append("  😃 분양 가능합니다. \n");  //message += " 😃분양가능합니다. \n"
			} else {
				sb.append("  😓 분양 자격이 안됩니다.\n");
			}
		
			//위 if 문을 조건 삼향연산으로 변경해보면
			String temp = member.isAdopt(animals[i])? "분양 가능합니다.\n" : "분양 자격이 안됩니다\n";
			//sb.append(temp);
		}


		

}
		System.out.println();
		System.out.println(sb); //StringBuilder 타입 객체는 printIn의 인자로 쓸때 toString 생략 가능


	}//main end
	
}








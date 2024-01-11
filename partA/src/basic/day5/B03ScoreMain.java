package basic.day5;

public class B03ScoreMain {

  public static void main(String[] args) {
    
    //학생 4명의 성적을 저장해보세요
    //1학년 2명(모모,다현) 3과목  2학년 2명(나연,쯔위) 4과목
    //점수는 마음대로

    Score 모모 = new Score(); 
    Score 다현 = new Score();
    Score 나연 = new Score();
    Score 쯔위 = new Score();

    모모.setname("모모");
    모모.setgrade(1);
    모모.setjumsues(new int[]{81,80,80});
    

    다현.setname("다현");
    다현.setgrade(1);
    다현.setjumsues(new int[]{65,45,90});

    나연.setname("나연");
    나연.setgrade(2);
    나연.setjumsues(new int[]{88,90,80,100});
    
    쯔위.setname("쯔위");
    쯔위.setgrade(2);
    쯔위.setjumsues(new int[]{90,86,68,77});

    // System.out.println("이름=" + 모모.getname());
    // System.out.println("총점="+ 모모.sum() );
    
    모모.printData();
    System.out.println("평균=" +모모.average());
  
    // System.out.println("이름=" + 다현.getname());
    // System.out.println("총점=" + 다현.sum());
    
    다현.printData();
    System.out.println("평균=" + 다현.average());
    
    // System.out.println("이름=" + 나연.getname());
    // System.out.println("총점=" + 나연.sum());
    
    나연.printData();
    System.out.println("평균=" + 나연.average());
    // System.out.println("이름=" + 쯔위.getname());
    // System.out.println("총점=" + 쯔위.sum());
    
    쯔위.printData();
    System.out.println("평균=" + 쯔위.average());
    






  }
  
}

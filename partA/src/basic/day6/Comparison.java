package basic.day6;

public class Comparison {

  
  private double height; // 키
  private char position; // 포지션
  private String birthday; // 출생일
  private String[] comparison; // 비슷한 유형의 선수
  
  //커스텀 생성자

  public Comparison(double height,char position,String birthday,String[] comparison){
    
    this.height = height;
    this.position = position;
    this.birthday = birthday;
    this.comparison = comparison;


  }




  public float getHeight() {
    return height;
  }

  public char position() {
    return position;
  }

  public String getBirthday() {
    return birthday;
  }

  public String[] getComparison() {
    return comparison;
  }








}

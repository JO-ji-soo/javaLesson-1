package basic.day6;

public class HomeCharType {

  public static void main(String[] args) {
    String message = "2024 Happy New Year~~~";

    int uppercount = 0;
    int lowerCount = 0;
    int numberCount = 0;
    int syobolCount = 0;

    for (int i = 0; i < message.length(); i++) {
      //message.charAt(i) = temp; 
      if (message.charAt(i) >= 48 && message.charAt(i) <= 57) {
        numberCount++;
      } else if (message.charAt(i) >= 65 && message.charAt(i) <= 90) {
        uppercount++;
      } else if (message.charAt(i) >= 97 && message.charAt(i) <= 122) {
        lowerCount++;
        //키보드로 찍는 문자들은 다국어 문자가 아닌경우만 가능
      } else {
        //syobolCount++;
        //만약 한글도 있을 수 있다면
        //else if((temp>32&&temp<=47)||(temp>=':'&&temp<='@')||(temp>=91&&temp<=96)||(temp>=123&&temp<=126);
      syobolCount++;
      }

    }
    System.out.println("문자열:" + message);
    System.out.println("대문자:" + uppercount + "소문자" + lowerCount + "숫자" + numberCount + "기호" + syobolCount);

  }

}

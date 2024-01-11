package basic.day6;

import java.util.Arrays;

public class Cart {

  private String userid;
  private String[] productNames;
  private int[] prices;
  private int total_Money;

  //추가적인 인스턴스 메소드 : 해결방법 ???
  public void total_Money(int[] select){  //setter 역할
    int sum=0;
    for(int i=0;i<select.length;i++){
    int temp = select[i];
          //System.out.println("temp :" + temp);
    if(temp == -1) break;    //반복문 중지
    sum += prices[temp];
  }  
      this.total_Money=sum;
      //return sum
  }
    public int getTotal_Money() {
    return total_Money;
  }
/*   public void setTotal_Money(int total_Money) {
     this.total_Money = total_Money;
*/  
  public String getuserid(){
    return userid;
  }

  public String[] getProductNames() {
    return productNames;
  }

  public int[] getPrices() {
    return prices;
  }


  
  public void setuserid(String userid){
    this.userid = userid;
  }
  
  public void setProductNames(String[] productNames) {
    this.productNames = productNames;
  }
  
  
  public void setPrices(int[] prices) {
    this.prices = prices;
  }



  







  
  
  
  




  }

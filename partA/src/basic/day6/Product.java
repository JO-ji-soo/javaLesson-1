package basic.day6;

import java.util.Arrays;

public class Product {

    private String productName;
    private int    price;
    private String company;
    private String[] etc;


    //커스텀 생성자 만들기
    public Product(String productName,int price,String company,String[] etc){
        this.productName = productName;
        this.price       = price;
        this.company     = company;
        this.etc         = etc;

    }

    //getter 만들기

    public String getProductName() {
      return productName;
    }
  
    public int getPrice() {
      return price;
    }

    public String getCompany() {
      return company;
    }
  

    public String[] getEtc() {
      return etc;
    }
    //모든 필드값을 이용해서 문자열을 만들어 리턴합니다.
    public String getData(){
      return String.format("%s\t, %d\t,%s\t,%s",productName,price,company,Arrays.toString(etc));
    }               //자리크기 지정한 것에 대해 정렬은 %s 문자열은 가운데 - 붙이면 왼쪽
                    //                              %d 정수는 오른쪽 
  
  }


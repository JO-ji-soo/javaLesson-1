package collection.day10;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class C04SetExample {

  public static void main(String[] args) {
    
    Set<String> set=new HashSet<>();
    //무작위 정렬됨
    set.add("트와이스");
    set.add("아이브");
    set.add("잇지");
    set.add("뉴진스");
    set.add("트와이스");
    set.add("소녀시대");
    System.out.println("set:"+set);
    System.out.println("set size:"+set.size());
    
    System.out.println("set 데이터 요소 한개씩 접근하기");
    for(String temp : set){
      System.out.println("\t set 요소 "+ temp);
    }
    //set 인덱스 없습니다
    //for(int i=0;i<set.size();i++) 와 같은 방식은 불가

    Set<String> set2 =new LinkedHashSet<>();
    //본래의 set은 순서가 없으므로 무작위 접근
    //Linked는 다음 입력데이터의 참조값을 저장하여 입력 순서대로 접근 합니다.
    set2.add("트와이스");
    set2.add("아이브");
    set2.add("잇지");
    set2.add("뉴진스");
    set2.add("트와이스");
    set2.add("소녀시대");
    System.out.println("~~~~~~~LinkedHashSet~~~~~~");
    System.out.println("set:"+set2);
    System.out.println("set size:"+set2.size());

    Set<String> set3 =new TreeSet<>();
    //이진트리 알고리즘을 이용하여 데이터를 정렬된 방식으로 접근합니다.
    set3.add("트와이스");
    set3.add("아이브");
    set3.add("잇지");
    set3.add("뉴진스");
    set3.add("트와이스");
    set3.add("소녀시대");
    System.out.println("~~~~~~~TreeSet~~~~~~"); // 글자순서대로 정렬됨
    System.out.println("set:"+set3);
    System.out.println("set size:"+set3.size());

  }
}

/*
 * Set : 수학시간에 배운 집합
 * 순서(인덱스)가 없습니다.
 * 중복값이 없습니다.
 * Map 의 구성요소 : Key, Value 중에서 Key 는 Set 특성을 갖고 있습니다.
 */

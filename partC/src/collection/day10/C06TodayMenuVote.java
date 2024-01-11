package collection.day10;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;  //Map안에서 구성요소로 정의된 Entry 내부 클래스
import javax.sound.sampled.SourceDataLine;

public class C06TodayMenuVote {
  //Map 연습
  public static void main(String[] args) {
    
    String menu = "치킨, 스파게티, 곱창, 불고기, 삼겹살";
    //투표 결과저장을 map에 해봅시다.
    Map<String,Integer> map = new LinkedHashMap<>();
    map.put("치킨", 0);
    map.put("스파게티", 0);
    map.put("곱창", 0);
    map.put("불고기", 0);
    map.put("삼겹살", 0);

    System.out.println("오늘의 메뉴 투표합니다.");
    System.out.println("메뉴 : "+menu);
    Scanner sc = new Scanner(System.in);

    while(true){
      System.out.println("메뉴 이름 입력 >>>>");
      String key = sc.nextLine();
      if(key.equals("end")) break;
      if(map.containsKey(key)){
          //입력한 key의 value를 가져와서 +1 연산을 한 결과로 다시 value에 저장
          int value = map.get(key);
          // value++;
          map.put(key, ++value);
    } else if(!map.containsKey(key)) {
      //없는 메뉴 입력하면
      System.out.println("투표에 없는 메뉴이군요. 추가하겠습니다.~~~");
      map.put(key, 1);
      menu += ","+key;
    } else {
      //또는
      System.out.println("선정된 메뉴 중에서 선택하세요.");
    }
  }  
  
  System.out.println("투표가 종료되었습니다.");
  System.out.println(map);
  System.out.println(Collections.max(map.keySet())); //key중의 최대값
  System.out.println(Collections.max(map.values())); //value중의 최대값
  //value최대값의 key는 무엇??    //key,Value를 한쌍으로 만든 타입이 Entry

  Comparator<Entry<String,Integer>> comparator = new Comparator<Entry<String,Integer>>() {
    @Override
    public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
      return o1.getValue()-o2.getValue();
    }
  };
  Entry<String,Integer> maxEntry = Collections.max(map.entrySet(),comparator);
  System.out.println("최대 득표 결과");
  System.out.println("\t 메뉴이름 : "+maxEntry.getKey());
  System.out.println("\t 투표수 : "+maxEntry.getValue());

  sc.close();
  
  }
}
  

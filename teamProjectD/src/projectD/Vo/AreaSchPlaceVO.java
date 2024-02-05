package projectD.Vo;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * 기능3. 지역이름으로 맛집 검색하기
 *          ㄴ 서울, 인천, 부산, 대구, 광주, 제주 
 */
@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class AreaSchPlaceVO {
    
    private int place_seq;
    private String name;
    private String open_time;
    private String close_time;
    private String address;

    @Override
    public String toString() {
        // String msg = String.format("%-10s %-50s %10s~%10s %-100s %30s %-10s" , "분류번호","상호명","시작 시간", "종료 시간", "주소",); 
        String msg = String.format("%-10d %-50s %10s~%10s %-100s %30s %,-10d원" , place_seq, name, open_time, close_time, address); 
        return  msg;

    }

    



}

package projectD.Vo;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class PlaceAddressVo {
    //private int address_seq;
    private int place_seq;
    private String address; 
    private String name;
    private String open_time;
    private String close_time;
    @Override
    public String toString() {
        return "place_seq=" + place_seq + ", address=" + address + ", name=" + name + ", open_time="
                + open_time + ", close_time=" + close_time;
    } 
}
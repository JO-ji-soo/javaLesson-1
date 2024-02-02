package vo;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class PlaceAddressVo {
    private int address_seq;
    private String address;
    private int place_seq;

    @Override
    public String toString() {
        return String.format("%8d \t %8d %-50s",
                place_seq, address_seq, address);
    }
}

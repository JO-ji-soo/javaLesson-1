package vo;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
public class PlaceVo {
    private int place_seq;
    private String name;
    private String phone;
    private int rate;
    private String open_time;
    private String close_time;
    private String food_type;

    @Override
    public String toString() {
        return String.format("%8d %-40s %15s %4d \t %10d~%10d \t %10s",
                place_seq, name, phone, rate, open_time, close_time, food_type);
    }
}

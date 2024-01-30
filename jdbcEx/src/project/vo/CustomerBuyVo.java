package project.vo;

import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor
@EqualsAndHashCode

public class CustomerBuyVo {

    private int buy_idx;
    private String pcode;
    private String pname;
    private int price;
    private int quantity;
    private Timestamp buy_date;
    
    @Override
    public String toString() {
        return String.format("%8d %-15s %-40s\t % ,6d %4d %30s",buy_idx,pcode,pname,price,quantity,buy_date);
    }

    
    }


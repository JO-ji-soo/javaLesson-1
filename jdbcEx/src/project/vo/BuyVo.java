package project.vo;

import java.sql.Date;

public class BuyVo {
    private String customId;
    private String pcode;
    private int buy_idx;
    private int quantity;
    private Date buy_date;

    public BuyVo(String customId, String pcode, int buy_idx, int quantity, Date buy_date) {
        this.customId = customId;
        this.pcode = pcode;
        this.buy_idx = buy_idx;
        this.quantity = quantity;
        this.buy_date = buy_date;
    }

    public String getCustomId() {
        return customId;
    }

    public String getPcode() {
        return pcode;
    }

    public int getBuy_idx() {
        return buy_idx;
    }

    public int getQuantity() {
        return quantity;
    }

    public Date getBuy_date() {
        return buy_date;
    }

    @Override
    public String toString() {
        return "BuyVo [customId=" + customId + ", pcode=" + pcode + ", buy_idx=" + buy_idx + ", quantity=" + quantity
                + ", buy_date=" + buy_date + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((customId == null) ? 0 : customId.hashCode());
        result = prime * result + ((pcode == null) ? 0 : pcode.hashCode());
        result = prime * result + buy_idx;
        result = prime * result + quantity;
        result = prime * result + ((buy_date == null) ? 0 : buy_date.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        BuyVo other = (BuyVo) obj;
        if (customId == null) {
            if (other.customId != null)
                return false;
        } else if (!customId.equals(other.customId))
            return false;
        if (pcode == null) {
            if (other.pcode != null)
                return false;
        } else if (!pcode.equals(other.pcode))
            return false;
        if (buy_idx != other.buy_idx)
            return false;
        if (quantity != other.quantity)
            return false;
        if (buy_date == null) {
            if (other.buy_date != null)
                return false;
        } else if (!buy_date.equals(other.buy_date))
            return false;
        return true;
    }

    

    
}

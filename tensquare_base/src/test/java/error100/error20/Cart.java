package error100.error20;

import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2020/5/6
 */
//购物车
@Data
public class Cart {

    private List<Item> items = new ArrayList<>();

    private BigDecimal totalDiscount;

    private BigDecimal totalItemPrice;

    private BigDecimal totalDeliveryPrice;

    private BigDecimal payPrice;

}

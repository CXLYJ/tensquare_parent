package error100.error20;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2020/5/6
 */
@Data
public class Item {

    //商品ID
    private long id;

   private  int quantity;

   private BigDecimal price;

   private BigDecimal deliveryPrice;

}

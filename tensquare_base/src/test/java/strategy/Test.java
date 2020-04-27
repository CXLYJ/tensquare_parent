package strategy;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2020/4/27 23:09
 */
public class Test {

    public static void main(String[] args) {
        PromotionActivity promotionActivity618 = new PromotionActivity(new LijianpromotionStategy());
        PromotionActivity promotionActivity1111 = new PromotionActivity(new fanxainpromotionStategy());

        promotionActivity618.exectePromotionStrategy();
        promotionActivity1111.exectePromotionStrategy();
    }

}

package strategy;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2020/4/27 23:01
 */
public class LijianpromotionStategy implements PromotionStrategy{
    @Override
    public void doPromotion() {
        System.out.println("立减促销");
    }
}

package strategy;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2020/4/27 23:04
 */
public class PromotionActivity {

    //执行策略
    private PromotionStrategy promotionStrategy;

    public PromotionActivity(PromotionStrategy promotionStrategy) {
        this.promotionStrategy = promotionStrategy;
    }

    public void exectePromotionStrategy(){
        promotionStrategy.doPromotion();
    }
}

package money;

/**
 * 接口状态
 *
 * @author ：lyj
 * @email: ：liyj@nysoftland.com.cn
 * @date ：2020/10/22 15:45
 */
public interface State {

    /**
     * 定价发布
     */
    void makePriceEvent(Context context);

    /**
     * 接单
     */
    void acceptOrderEvent(Context context);

    /**
     * 无人接单失效
     */
    void notPeopleAcceptEvent(Context context);

    /**
     * 付款
     */
    void payOrderEvent(Context context);

    /**
     * 接单有人支付失效
     */
    void orderFailureEvent(Context context);

    /**
     * 反馈
     */
    void feedBackEvent(Context context);


    /**
     * 得到状态
     *
     * @return
     */
    String getCurrentState();

}

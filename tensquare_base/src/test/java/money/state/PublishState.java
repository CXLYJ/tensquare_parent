package money.state;

import money.AbstractState;
import money.Context;

/**
 * 发布业务状态
 *
 * @author ：lyj
 * @email: ：liyj@nysoftland.com.cn
 * @date ：2020/10/22 16:24
 */
public class PublishState extends AbstractState {

    /**
     * 接单
     */
    @Override
    public void acceptOrderEvent(Context context) {
        // 把当前状态设置为 NotPayState 未付款状态
        // 至于设置成什么状态，由自己得流程业务决定
        context.setState(new NotPayState());
    }

    /**
     * 无人接单失效
     */
    @Override
    public void notPeopleAcceptEvent(Context context) {
        context.setState(new FeedBackState());
    }

    /**
     * 继承没有实现得方法做相应得操作
     *
     * @return
     */
    @Override
    public String getCurrentState() {
        return null;
    }
}

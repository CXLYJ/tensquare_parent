package money.state;

import money.AbstractState;
import money.Context;
import money.StateEnum;

/**
 * 未付款状态
 *
 * @author ：lyj
 * @email: ：liyj@nysoftland.com.cn
 * @date ：2020/10/22 16:31
 */
public class NotPayState extends AbstractState {

    @Override
    public void payOrderEvent(Context context) {
        context.setState(new PaidState());
    }

    @Override
    public void feedBackEvent(Context context) {
        context.setState(new FeedBackState());
    }

    @Override
    public String getCurrentState() {
        return StateEnum.NOT_PAY.getValue();
    }

}

package money.state;

import money.AbstractState;
import money.Context;
import money.StateEnum;
import money.state.FeedBackState;

/**
 * 付费状态
 *
 * @author ：lyj
 * @email: ：liyj@nysoftland.com.cn
 * @date ：2020/10/22 16:40
 */
public class PaidState extends AbstractState {

    @Override
    public void feedBackEvent(Context context) {
        context.setState(new FeedBackState());
    }

    @Override
    public String getCurrentState() {
        return StateEnum.PAID.getValue();
    }

}

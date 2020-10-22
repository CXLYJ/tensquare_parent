package money.state;

import money.AbstractState;
import money.StateEnum;

/**
 * 反馈完结状态
 *
 * @author ：lyj
 * @email: ：liyj@nysoftland.com.cn
 * @date ：2020/10/22 16:39
 */
public class FeedBackState extends AbstractState {

    @Override
    public String getCurrentState() {
        return StateEnum.FEED_BACKED.getValue();
    }

}

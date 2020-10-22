package money;

import money.state.PublishState;

/**
 * 测试
 *
 * @author ：lyj
 * @email: ：liyj@nysoftland.com.cn
 * @date ：2020/10/22 16:47
 */
public class Test {

    public static void main(String[] args) {

        // 创建上下问对象
        Context context = new Context();
        // 设置当前状态(发布业务)
        context.setState(new PublishState());
        //然后可以根据操作变化状态.

        //publish --> not pay
        context.acceptOrderEvent(context);

        //not pay --> paid
        context.payOrderEvent(context);

        // paid --> pay end
        context.feedBackEvent(context);


        // 如果调用业务中没有得状态将失败抛出异常
//        context.makePriceEvent(context);

    }

}

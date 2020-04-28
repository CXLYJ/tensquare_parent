package cas;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2020/4/17
 *
 * 模拟cas等价代码
 */
public class SimulatedCAS {

    private int value;

    public synchronized int compareAndSwap(int expectedValue, int newValue){
        int oldValue = value;
        if (oldValue == expectedValue){
            value = newValue;
        }
        return oldValue;
    }

}

package strategy.test;

/**
 * TODO
 *
 * @author ：lyj
 * @email: ：liyj@nysoftland.com.cn
 * @date ：2020/10/28 10:54
 */
public class Context {

    private Strategy strategy;

    /**
     * 定义传入策略
     *
     * @param strategy
     */
    public Context(Strategy strategy){
        this.strategy = strategy;
    }

    /**
     * 执行策略方法
     *
     * @param num1
     * @param num2
     * @return
     */
    public int executeStrategy(int num1 , int num2){
        return strategy.doOperation(num1 , num2);
    }

}

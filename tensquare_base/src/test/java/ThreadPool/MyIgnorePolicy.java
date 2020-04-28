package ThreadPool;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2020/4/13
 */
public class MyIgnorePolicy implements RejectedExecutionHandler {

    /**
     * 拒绝策略（添加任务失败后如何处理该任务）
     * @param r
     * @param executor
     */

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        doLog(r, executor);  
    }

    private void doLog(Runnable r, ThreadPoolExecutor executor) {
        //可以做日志记录
        System.err.println(r.toString() + " rejected");
        System.out.println("completedTaskCount: " + executor.getCompletedTaskCount());
    }
}

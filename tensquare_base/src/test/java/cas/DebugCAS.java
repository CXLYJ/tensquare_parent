package cas;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2020/4/17
 */
public class DebugCAS implements Runnable{

    private volatile  int value;

    public synchronized int compareAndSwap(int expectedValue, int newValue){
        int oldValue = value;
        if (oldValue == expectedValue){
            value = newValue;
            System.out.println("线程" + Thread.currentThread().getName() + "执行成功");
        }
        return oldValue;
    }

    public static void main(String[] args) throws InterruptedException {
        DebugCAS debugCAS = new DebugCAS();
        debugCAS.value = 100;
        Thread t1 = new Thread(debugCAS, "Thread 1");
        Thread t2 = new Thread(debugCAS, "Thread 2");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(debugCAS.value);
    }

    @Override
    public void run() {
       compareAndSwap(100, 150);
    }
}

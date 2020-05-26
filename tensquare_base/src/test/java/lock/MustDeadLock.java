package lock;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2020/5/26 22:31
 *
 * 必定死锁的情况
 */
public class MustDeadLock implements Runnable{

    public int flag;
    static Object o1 = new Object();
    static Object o2 = new Object();

    @Override
    public void run() {
        System.out.println("线程" + Thread.currentThread().getName() + "的flag为" + flag);
        if (flag == 1){
            synchronized (o1){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o2){
                    System.out.println("线程1获得了两把锁");
                }
            }
        }
        if (flag == 2){
            synchronized (o2){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o1){
                    System.out.println("线程2获得两把锁");
                }
            }
        }
    }

    public static void main(String[] args) {
        MustDeadLock mustDeadLock1 = new MustDeadLock();
        MustDeadLock mustDeadLock2 = new MustDeadLock();
        mustDeadLock1.flag = 1;
        mustDeadLock2.flag = 2;
        Thread thread1 = new Thread(mustDeadLock1,"t1");
        Thread thread2 = new Thread(mustDeadLock2,"t2");
        thread1.start();
        thread2.start();
    }

}

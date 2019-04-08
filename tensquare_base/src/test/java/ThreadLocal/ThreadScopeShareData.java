package ThreadLocal;

import java.util.Random;

/**
 * Created by lyj on 2019/1/30.
 * 用ThreadLoal来完成线程范围内数据共享
 */
public class ThreadScopeShareData {

    //定义一个ThreadLocal
    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        for (int i=0; i < 2; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int data = new Random().nextInt(100);
                    System.out.println(Thread.currentThread().getName() + "has put data: " + data);
                    threadLocal.set(data);  //直接往threadlocal里面忍参数即可
                    new TestA().getData();
                    new TestB().getData();
                }
            }).start();
        }
    }

    static class TestA {
        public void getData() {
            System.out.println("A get data from " + Thread.currentThread().getName()
                    + ": " + threadLocal.get());//直接取，不用什么关键字，它直接从当前线程中取
        }
    }

    static class TestB {
        public void getData() {
            System.out.println("A get data from " + Thread.currentThread().getName()
                    + ": " + threadLocal.get());//直接取，不用什么关键字，它直接从当前线程中取
        }
    }

}

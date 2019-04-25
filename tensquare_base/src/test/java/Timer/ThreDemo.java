package Timer;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2019/4/25 15:06
 *
 * 定时线程
 */
public class ThreDemo {

    static double x = 0;

    public static void main(String[] args) {
        Thread t1 = new Thread(new Thread1()); //创建线程
        Thread t2 = new Thread(new Thread2());

        t1.start();
        t2.start();
    }

    public static class Thread1 extends Thread{
        @Override
        public void run() {
            while (true){
                try {
                    Thread.sleep(300);
                    x += 1.0;
                    System.out.println("x + 1: " + x);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public static class Thread2 extends Thread{
        @Override
        public void run() {
            while (true){
                try {
                    Thread.sleep(300);
                    x += 0.1;
                    System.out.println("x + 01.: " + x);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }

}

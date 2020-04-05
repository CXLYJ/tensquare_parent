package Test;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2019/5/14 15:57
 *
 * 同步线程
 */
public class Test extends Thread{

    private int ticket = 10;

    public void run(){
        for (int i = 0; i < 10; i++){
            synchronized (Test.class){
                if (this.ticket > 0){
                    try {
                        Thread.sleep(100);
                        System.out.println(Thread.currentThread().getName() + "卖票---->"+(this.ticket--));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
       Test test1 = new Test();
       new Thread(test1,"线程1").start();
       new Thread(test1,"线程2").start();
    }

    /*private static boolean flag(){
        try {
            return true;
        }catch (Exception e){
                e.printStackTrace();
        }finally {
            return false;
        }
    }*/

}

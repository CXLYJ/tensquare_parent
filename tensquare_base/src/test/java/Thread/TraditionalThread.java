package Thread;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2020/3/30 17:04
 *
 * 线程创建两种方式
 */
public class TraditionalThread {

    public static void main(String[] args) {
        //这哥们的代码写的比较给力
        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Runnable:" + Thread.currentThread().getName());
            }
        }){

            @Override
            public void run() {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread:" + Thread.currentThread().getName());
            }

        }.start();
    }

}

package ThreadLocal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2020/4/15
 */
public class ThreadLocalDemo04 {

    public static ExecutorService executorService4 = Executors.newFixedThreadPool(16);
    static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss");

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++){
            int finalI = i;
            executorService4.submit(new Runnable() {
                @Override
                public void run() {
                    String date = new ThreadLocalDemo04().date(finalI);
                    System.out.println(date);
                }
            });
        }
        executorService4.shutdown();
    }

    public String date(int seconds){
        Date date = new Date(1000 * seconds);
        String s = null;
        synchronized (ThreadLocalDemo04.class){
            s = simpleDateFormat.format(date);
        }
        return s;
    }

}

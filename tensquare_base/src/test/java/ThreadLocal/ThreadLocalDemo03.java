package ThreadLocal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2020/4/15
 */
public class ThreadLocalDemo03 {

    public static ExecutorService executorService = Executors.newFixedThreadPool(16);

    public static void main(String[] args) {
       for (int i = 0; i < 1000; i++){
           int finalI = i;
           executorService.submit(new Runnable() {
               @Override
               public void run() {
                   String date = new ThreadLocalDemo03().date(finalI);
                   System.out.println(date);
               }
           });
       }
       executorService.shutdown();
    }

    public String date(int seconds){
        Date date = new Date(1000 * seconds);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss");
        return simpleDateFormat.format(date);
    }
}

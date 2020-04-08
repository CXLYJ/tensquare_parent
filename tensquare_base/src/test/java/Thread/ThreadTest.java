package Thread;

import lombok.extern.slf4j.Slf4j;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2020/3/14 21:08
 *
 * 线程池
 */
@Slf4j
public class ThreadTest {


    public static void main(String[] args) throws InterruptedException {
            ThreadPoolExecutor threadPool = (ThreadPoolExecutor) Executors.newFixedThreadPool(1);
            for (int i = 0; i < 100000000; i++){
                threadPool.execute(() -> {
                    String payload = IntStream.rangeClosed(1,1000000)
                            .mapToObj(__ -> "a")
                            .collect(Collectors.joining("")) + UUID.randomUUID().toString();
                    try {
                        TimeUnit.HOURS.sleep(1);
                    } catch (InterruptedException e) {
                    }
                    log.info(payload);
                });
            }
            threadPool.shutdown();
            threadPool.awaitTermination(1,TimeUnit.HOURS);
    }

}

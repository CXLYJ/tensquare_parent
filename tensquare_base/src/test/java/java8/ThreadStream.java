package java8;

import java.util.function.LongConsumer;
import java.util.stream.LongStream;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2019/8/5 15:57
 */
public class ThreadStream {

    public static void main(String[] args) {
        ThreadStream.test((n) -> LongStream.rangeClosed(1L, n).reduce(0L, Long::sum), 1000L);
        ThreadStream.test((n) -> LongStream.rangeClosed(1L, n).parallel().reduce(0L, Long::sum), 1000L);
    }

    static void test(LongConsumer c, Long n){
        long start = System.currentTimeMillis();
        c.accept(n);
        long end = System.currentTimeMillis();
        System.out.println("处理时间：" + (end - start) + "msc");
    }

}

package collection.listvsmap;

import com.google.common.base.Stopwatch;
import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Assert;
import org.springframework.util.StopWatch;

import java.io.InputStream;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * TODO
 *
 * @author ：lyj
 * @email: ：liyj@nysoftland.com.cn
 * @date ：2020/8/17 18:32
 */
public class ListVsMapApplication {

    public static void main(String[] args){
        int elementCount = 1000000;
        int loopCount = 1000;
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("listSearch");
        Object list = listSearch(elementCount, loopCount);
        System.out.println(ObjectSizeCalculator.getObjectSize(list));
    }

    private static Object listSearch(int elementCount, int loopCount) {
        List<Order> list = IntStream.rangeClosed(1, elementCount).mapToObj(i -> new Order(i)).collect(Collectors.toList());
        IntStream.rangeClosed(1, loopCount).forEach(i -> {
            int search = ThreadLocalRandom.current().nextInt(elementCount);
            Order result = list.stream().filter(order -> order.getOrderId() == search).findFirst().orElse(null);
            Assert.assertTrue(result != null && result.getOrderId() == search);
        });
        return list;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    static class Order {
        private int orderId;
    }

}

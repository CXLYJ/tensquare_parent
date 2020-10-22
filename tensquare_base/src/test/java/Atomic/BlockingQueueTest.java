package Atomic;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 阻塞队列
 *
 * @author ：lyj
 * @email: ：liyj@nysoftland.com.cn
 * @date ：2020/9/25 13:43
 */
public class BlockingQueueTest {

    public static void main(String[] args) {

        BlockingQueue<Object> queue = new ArrayBlockingQueue<>(10);

        Runnable product = () -> {
            while (true){
                try {
                    queue.put(new Object());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        new Thread(product).start();
        new Thread(product).start();

        Runnable consumer = () -> {
            while (true){
                try {
                    queue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        new Thread(consumer).start();
        new Thread(consumer).start();

    }


}

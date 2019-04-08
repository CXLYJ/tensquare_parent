package tensquare.base;


import sun.security.provider.Sun;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by lyj on 2019/1/24.
 */
public class MyTask implements Callable<Integer> {

    private int upperBounds;

    public MyTask(int upperBounds){
        this.upperBounds = upperBounds;
    }

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i=1; i <= upperBounds; i++){
            sum = sum + i;
        }
        return sum;
    }
}

class Test {

    public static void main(String[] args) throws Exception{
        List<Future<Integer>> list = new ArrayList<>();
        ExecutorService service = Executors.newFixedThreadPool(10);
        for (int i=0; i<10; i++){
            list.add(service.submit(new MyTask((int)Math.random()*100)));
        }
        int sum = 0;
        boolean flase = false;
        for (Future<Integer> future : list){
            sum += future.get();
            flase = future.isDone();
        }

        System.out.println(sum);
        System.out.println(flase);
    }

}
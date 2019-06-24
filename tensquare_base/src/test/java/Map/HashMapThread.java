package Map;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2019/6/21 15:40
 *
 * 线程同步
 */
public class HashMapThread {

    public static void main(String[] args) {

        /**
         * 运行代码抛出异常java.util.ConcurrentModificationException
         */

//        HashMap<Integer,String> hashMap1 = new HashMap<>();
//        //写线程
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 1000; i++){
//                    hashMap1.put(i,"value" + i);
//                    try {
//                        Thread.sleep(new Random().nextInt(10));
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }).start();
//        //读线程
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (true){
//                    if (hashMap1.size() > 0){
//                        for (Map.Entry entry : hashMap1.entrySet()){
//                            System.out.println(entry.getKey() + "=" + entry.getValue());
//                        }
//                    }
//                    try {
//                        Thread.sleep(new Random().nextInt(10));
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }).start();


        /**
         * 代码任然抛出异常java.util.ConcurrentModificationException
         */
//        HashMap<Integer,String> hashMap2 = new HashMap<>();
//        Map<Integer,String> map = Collections.synchronizedMap(hashMap2);
//        //写线程
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 1000; i++){
//                    map.put(i ,"value=" + i);
//                    try {
//                        Thread.sleep(new Random().nextInt(10));
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }).start();
//        //读线程
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (true){
//                    if (map.size() > 0){
//                        for (Map.Entry entry : map.entrySet()){
//                            System.out.println(entry.getKey() + "=" + entry.getValue());
//                        }
//                    }
//                    try {
//                        Thread.sleep(new Random().nextInt(10));
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }).start();


        /**
         * ConcurrentHashMap 保证线程的同步
         */

//        ConcurrentHashMap<Integer,String> concurrentHashMap = new ConcurrentHashMap<>();
//        //写线程
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 1000; i++){
//                    concurrentHashMap.put(i ,"value=" + i);
//                    try {
//                        Thread.sleep(new Random().nextInt(10));
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }).start();
//        //读线程
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (true){
//                    if (concurrentHashMap.size() > 0){
//                        for (Map.Entry entry : concurrentHashMap.entrySet()){
//                            System.out.println(entry.getKey() + "=" + entry.getValue());
//                        }
//                    }
//                    try {
//                        Thread.sleep(new Random().nextInt(10));
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }).start();


        /**
         *  使用lock锁手动实现hashmap的同步
         */
        ReentrantLock  lock = new ReentrantLock(true);
        HashMap<Integer,String> hashMap3 = new HashMap<>();

        //写线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 10; i++){
                        hashMap3.put(i, "value" + i);
                        Thread.sleep(new Random().nextInt(10));
                    }
                }catch (Exception e){

                }finally {
                    //lock.unlock();
                }
            }
        }).start();

        //读线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    lock.lock();
                    try {
                        if (hashMap3.size() > 0){
                            for (Map.Entry entry : hashMap3.entrySet()){
                                System.out.println(entry.getKey() + "=" + entry.getValue());
                            }
                        }
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }finally {
                        lock.unlock();
                    }
                    try {
                        Thread.sleep(new Random().nextInt(10));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();


    }

}

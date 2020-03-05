package Thread;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2020/3/5 17:22
 */
public class TraditionalTimer {

    private static int count = 0; //记录爆炸的次数

    public static void main(String[] args) {

//        /**
//         * 我们用匿名内部类来定义了一个TimerTask对象，需要重写run()方法，然后运行这个程序，
//         * 可以看出来第一次2秒钟后打印“--boom--，后面每隔3秒打印一次。
//         */
//        new Timer().schedule(new TimerTask() {
//            @Override
//            public void run() {
//                //实际中会扔一个对象进来，我们就可以在这里操作这个对象的所有方法了
//                System.out.println("--boom--");//爆炸
//            }
//        },2000,3000);
//
//        //打印秒钟，一秒输出一次,用来方便观察的
//        while(true) {
//            System.out.println(new Date().getSeconds());
//            try {
//                Thread.sleep(1000);
//            } catch(Exception e) {
//                e.printStackTrace();
//            }
//        }

//        //自定义一个定时器
//        class MyTimerTask extends TimerTask{
//            @Override
//            public void run() {
//                System.out.println("--boom--");
//                //任务执行完再装一个定时器，扔进自定义的定时器任务
//                new Timer().schedule(new MyTimerTask(), 3000);
//            }
//        }
//        new Timer().schedule(new MyTimerTask(), 2000);
//
//        while(true) {//打印秒钟，一秒输出一次
//            System.out.println(new Date().getSeconds());
//            try {
//                Thread.sleep(1000);
//            } catch(Exception e) {
//                e.printStackTrace();
//            }
//        }


//        class MyTimerTask extends TimerTask{
//
//            @Override
//            public void run() {
//                count = (count + 1) % 2; //结果只有0和1
//                System.out.println("--boom--");
//                new Timer().schedule(new MyTimerTask(), 2000+2000*count);//根据count结果设定新的定时时间
//            }
//        }
//        new Timer().schedule(new MyTimerTask(), 2000);
//
//        while(true) {//打印秒钟，一秒输出一次
//            System.out.println(new Date().getSeconds());
//            try {
//                Thread.sleep(1000);
//            } catch(Exception e) {
//                e.printStackTrace();
//            }
//        }


        /**
         * 这样的话，我们就实现了自定义爆炸间隔了。
         * 上面这个是通过定义一个全局私有变量来实现，其实我们也可以这么干：
         * 不是要实现两个不同时间间隔的连环炸么？我可以定义两个定时器任务A和B，
         * 在A执行完开启定时器，把B任务装进去，B执行完开启定时器把A装进去，这样也可以。如下：
         */

            new Timer().schedule(new MyTimerTaskA(), 2000);//A和B随便开一个

            while (true) {//打印秒钟，一秒输出一次
                System.out.println(new Date().getSeconds());
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
    }


    //自定义两个定时器任务类，继承TimerTask即可
    static class MyTimerTaskA extends TimerTask {

        @Override
        public void run() {
            System.out.println("--boomA--");
            new Timer().schedule(new MyTimerTaskB(), 4000);
        }
    }

    static  class MyTimerTaskB extends TimerTask {

        @Override
        public void run() {
            System.out.println("--boomB--");
            new Timer().schedule(new MyTimerTaskA(), 2000);
        }
    }


}

package Timer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2019/4/25 14:38
 *
 * 定时线程
 */
public class JavaTimer {

    public static void main(String[] args) {
        TimerTask task = new TimerTask() { //创建一个新的timer task
            @Override
            public void run() { //定时器任务执行的操作
                Date date = new Date();//创建Date对象
                String hour = String.format("%tH",date);//格式化输出时间
                String minute = String.format("%tM",date);
                String second = String.format("%tS",date);

                System.out.println("现在是：" + hour + "时" +minute+"分" + second +"秒");
            }
        };
        Timer timer = new Timer();//创建一个定时器
        long delay = 0;
        long periodTime = 1 * 1000;
        //重复执行特定任务，第一个参数为要执行的任务，第二个为执行任务之前延迟的时间，第三个为时间间隔
        //单位都是毫秒
        timer.scheduleAtFixedRate(task, delay, periodTime);
    }
}

package Timer;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2019/4/25 14:51
 *
 * 定时线程
 */
public class ThreadTest extends Thread {

    public void run(){
        while (true){
            try {
                Thread.sleep(1000);//程序眠1秒，括号内参数以毫秒为单位
                SimpleDateFormat ft = new SimpleDateFormat("yyy-MM-dd hh:mm:ss");//格式化输出时间
                String time = ft.format(new Date());
                System.out.println("现在时刻：" + time);//输出时间
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new ThreadTest().start();
    }

}

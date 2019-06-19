package Timer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2019/6/19 14:04
 */
public class ydcTimer extends HttpServlet{

    private final static Logger LOGGER = LoggerFactory.getLogger(ydcTimer.class);

    @Override
    public void init() throws ServletException {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY,0);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.SECOND,1000);

        Date date = calendar.getTime();
        if (date.before(new Date())){
            date = this.addHour(date,1);
        }

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
               LOGGER.info("开始启动...");
            }
        };

        Timer timer = new Timer();//创建一个定时器
        long delay = 0;
        long periodTime = 1 * 1000;
        //重复执行特定任务，第一个参数为要执行的任务，第二个为执行任务之前延迟的时间，第三个为时间间隔
        //单位都是毫秒
        timer.scheduleAtFixedRate(task, delay, periodTime);

    }

    //增加或减少时间
    private Date addHour(Date date, int num) {
        Calendar startDate = Calendar.getInstance();
        startDate.setTime(date);
        startDate.add(Calendar.HOUR_OF_DAY,num);
        return startDate.getTime();
    }
}

package sjms.zr;

/**
 * TODO
 *
 * @author ：lyj
 * @email: ：liyj@nysoftland.com.cn
 * @date ：2020/10/28 15:47
 */
public class ConsoleLogger extends AbstractLogger{

    public ConsoleLogger(int level){
        this.level = level;
    }


    @Override
    protected void write(String message) {
        System.out.println("Standard Console::Logger: " + message);
    }
}

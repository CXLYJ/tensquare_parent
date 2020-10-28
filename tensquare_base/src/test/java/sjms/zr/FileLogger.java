package sjms.zr;

/**
 * TODO
 *
 * @author ：lyj
 * @email: ：liyj@nysoftland.com.cn
 * @date ：2020/10/28 15:50
 */
public class FileLogger extends AbstractLogger{

    public FileLogger(int level){
        this.level = level;
    }


    @Override
    protected void write(String message) {
        System.out.println("File::Logger: " + message);
    }
}

package Test;

/**
 * Created by Administrator on 2019/8/13.
 */
public class InitialOrderTest {

    public static String staticField = "静态变量"; //静态变量

    public String filed = "变量"; // 变量

    static {
        //静态初始化块
        System.out.println(staticField);
        System.out.println(" 静态初始化块 ");
    }

    {
        //初始化块
        System.out.println( filed );
        System.out.println("初始化块");
    }

    /**
     * 构造器
     */
    public InitialOrderTest() {
        System.out.println(" 构造器 ");
    }

    public static void main(String[] args) {
        new InitialOrderTest();
    }
}

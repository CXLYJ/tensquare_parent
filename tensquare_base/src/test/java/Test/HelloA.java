package Test;

/**
 * Created by Administrator on 2019/8/13.
 */
public class HelloA {

    /**
     * 对于一个类而言
     * 1.执行静态代码块
     * 2.执行构造代码块
     * 3.执行构造函数
     *
     * 对于静态变量、静态代码块、变量、初始化块、构造器、他们的初始化顺序（静态变量、静态初始块）》 （变量、初始化块）》
     * 构造器
     */

    public HelloA(){
        //构造函数
        System.out.println("A 的构造函数");
    }

    {
        //构造代码块
        System.out.println("A 的构造代码块");
    }

    static {
        //静态代码块
        System.out.println("A 的静态代码块");
    }

    public static void main(String[] args) {
        HelloA helloA = new HelloA();
        System.out.println("\n");
        HelloA b = new HelloA();
    }

}

package Test;

/**
 * Created by Administrator on 2019/8/13.
 */
public class HelloB extends HelloA{

    /**
     * 当涉及继承时
     *
     * 1.执行父类的静态代码块，并初始化父类静态成员变量
     * 2.执行子类的静态代码块，并初始化子类静态成员变量
     * 3.执行父类的构造代码块，执行父类的构造函数，并初始化父类普通成员变量
     * 4.执行子类的构造代码块， 执行子类的构造函数，并初始化子类普通成员变量
     */

    public HelloB(){//构造函数
        System.out.println("B的构造函数");
    }
    {//构造代码块
        System.out.println("B的构造代码块");
    }
    static {//静态代码块
        System.out.println("B的静态代码块");
    }
    public static void main(String[] args) {
        HelloB b=new HelloB();
    }

}

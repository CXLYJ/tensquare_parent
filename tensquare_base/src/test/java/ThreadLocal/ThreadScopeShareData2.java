package ThreadLocal;

import java.util.Random;

/**
 * Created by lyj on 2019/1/30.
 *
 * ThreadLocal的用法
 */
public class ThreadScopeShareData2 {

    private static ThreadLocal<Users>  threadLocal = new ThreadLocal<Users>();

    public static void main(String[] args) {
        for (int i=0 ; i < 2; i++){  //开启两个线程
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int data = new Random().nextInt(100);
                    System.out.println(Thread.currentThread().getName() + "has put a data :" + data);

                    //每个线程中维护一个Users，Users中保存name和age
                    Users users = new Users();
                    users.setName("name" + data);
                    users.setAge(data);
                    threadLocal.set(users); //向当前线程中存入users对象

                    new TestA().getData();
                    new TestB().getData();
                }
            }).start();
        }
    }

    static class TestA{
        public void getData(){
            Users users = threadLocal.get(); //从当线程中取出users对象
            System.out.println("A get data from " + Thread.currentThread().getName() +
            ":" +users.getName() + "," + users.getAge());
        }
    }

    static class TestB{
        public void getData(){
            Users users = threadLocal.get(); //从当线程中取出users对象
            System.out.println("A get data from " + Thread.currentThread().getName() +
                    ":" +users.getName() + "," + users.getAge());
        }
    }

}


//定义一个Users来存储姓名和年龄
class Users{

    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
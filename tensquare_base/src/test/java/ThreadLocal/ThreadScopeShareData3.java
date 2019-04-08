package ThreadLocal;

import java.util.Random;

/**
 * Created by lyj on 2019/1/30.
 */
public class ThreadScopeShareData3 {

    //不需要在外面定义threadLocal了，放到User类中了
//    private static ThreadLocal<User> threadLocal = new ThreadLocal<User>();

    public static void main(String[] args) {
        for (int i=0; i < 2; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int data = new Random().nextInt(100);
                    System.out.println(Thread.currentThread().getName() + "has put a data: " + data);
                    //这里直接用User去调用getThreadLocal这个静态方法获取本线程范围内的一个User对象
                    //这里就优雅多了，我完全不用关心如何去拿该线程中的对象，如何把对象放到threadLocal中
                    //我只要拿就行，而且拿出来的肯定就是当前线程中的对象，原因看下面User类中的设计
                    Users2.getThreadInstance().setName("name" + data);
                    Users2.getThreadInstance().setAge(data);

                    new TestA().getData();
                    new TestB().getData();

                }
            }).start();
        }
    }

    static class TestA{
        public void  getData(){
            //还是调用这个静态方法拿，因为刚刚已经拿过一次了，threadLocal中已经有了
            Users2 users2 = Users2.getThreadInstance();
            System.out.println("A get data from " + Thread.currentThread().getName() + ": "
                    + users2.getName() + "," + users2.getAge());
        }
    }

    static class TestB{
        public void  getData(){
            Users2 users2 = Users2.getThreadInstance();
            System.out.println("A get data from " + Thread.currentThread().getName() + ": "
                    + users2.getName() + "," + users2.getAge());
        }
    }


}



 class  Users2{
     private Users2(){} // //私有构造方法阻止外界new

     private static ThreadLocal<Users2> threadLocal = new ThreadLocal<>();

     //注意，这里不是单例，每个线程都可以new，所以不用synchronized
     //但是每个threadlocal中的是单例的，因为有了的话就不会再new了

     public static /*synchronized*/ Users2 getThreadInstance(){
         Users2 instance = threadLocal.get(); // 先从当前的threadlocal的拿
         if (instance == null){
             instance = new Users2();
             threadLocal.set(instance); //如果没有就要new一个放到threadlocal中
         }
         return instance; //向外返回user2
     }

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
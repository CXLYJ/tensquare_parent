package ThreadLocal;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2020/4/15
 */
public class ThreadLocalDemo05 {


    public static void main(String[] args) {
        new Service1().service1();
    }

    static class Service1 {
          public void service1(){
              User user = new User("拉钩教育");
              UserContextHolder.holder.set(user);
              new Service2().service2();
          }
    }

    static class Service2{
        public void service2(){
            User user = UserContextHolder.holder.get();
            System.out.println("Service2拿到用户名：" + user.name);
            new Service3().service3();
        }
    }

    static class Service3{
        public void service3(){
            User user = UserContextHolder.holder.get();
            System.out.println("Service3拿到用户名：" + user.name);
            UserContextHolder.holder.remove();
        }
    }

    static class UserContextHolder{
        public static ThreadLocal<User> holder = new ThreadLocal<>();
    }

    static class User{
        String name;
        public User(String name){
            this.name = name;
        }
    }

}

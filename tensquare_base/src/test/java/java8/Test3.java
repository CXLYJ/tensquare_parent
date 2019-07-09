package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2019/7/9 10:31
 */
public class Test3 {

    public static void main(String[] args) {

        //实现Runnable线程案例
        //before java 8
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("before java8 ");
//            }
//        }).start();
//
//        //java 8 way
//        new Thread(() -> System.out.println("In java8")).start();

        //使用Lambda表达式遍历List集合
        List features = Arrays.asList("Lambdas", "Default Method",
                "Stream API", "Date and Time API");
//        for (Object feature : features) {
//            System.out.println(feature);
//        }

        List<String> list = new ArrayList<>();
        features.forEach(n -> list.add((String) n));
        list.forEach(System.out :: println);


    }

}

package java8;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2019/11/8
 */
public class Test6 {

    public static void main(String[] args) {
        List<String> stringCollection = new ArrayList<>();
        stringCollection.add("ddd2");
        stringCollection.add("aaa2");
        stringCollection.add("bbb1");
        stringCollection.add("aaa1");
        stringCollection.add("bbb3");
        stringCollection.add("ccc");
        stringCollection.add("bbb2");
        stringCollection.add("ddd1");

        stringCollection.stream()
                .filter((s) -> s.startsWith("a"))
                .forEach(System.out::println);

        stringCollection.stream().
                sorted().filter((s) -> s.startsWith("a"))
                .forEach(System.out::println);


        

    }

}

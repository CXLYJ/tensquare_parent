package java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2019/7/8 17:58
 */
public class Test2 {

    public static void main(String[] args) {
        List names = Arrays.asList("peter","anna","mike","xenia");

        Collections.sort(names,(String a,String b) -> {
            return b.compareTo(a);
        });

        Collections.sort(names,(String a, String b) -> b.compareTo(a));

    }

}

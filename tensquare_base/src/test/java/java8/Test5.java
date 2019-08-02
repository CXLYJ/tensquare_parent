package java8;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2019/8/1 17:11
 */
public class Test5 {

    public static void main(String[] args) {
        List<Apple> appleList = new ArrayList<>();
        appleList.add(new Apple("red", 0.4));
        appleList.add(new Apple("red", 0.6));
        appleList.add(new Apple("red", 1.3));
        appleList.add(new Apple("green", 0.2));
        appleList.add(new Apple("green", 0.35));
        appleList.add(new Apple("green", 1.1));

        /**
         * 传统的方法
         */
//        List<Apple> appleFilterList = AppleFilterMethod.filterApple(appleList, new RedApple());
//        for (Apple apple : appleFilterList){
//            System.out.println(apple.getColor() + " apple,weight:" + apple.getWeight());
//        }

        List<Apple> appleFilterList = AppleFilterMethod.filterApple(appleList,
                apple -> "red".equalsIgnoreCase(apple.getColor()));
        for (Apple apple : appleFilterList) {
            System.out.println(apple.getColor() + " apple,weight:" + apple.getWeight());
        }

    }

}

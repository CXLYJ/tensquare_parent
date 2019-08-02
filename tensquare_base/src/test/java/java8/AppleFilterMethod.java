package java8;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2019/8/1 18:15
 *
 * 筛选苹果的方法
 */
public class AppleFilterMethod {

    public static List<Apple> filterApple(List<Apple> list, AppleFilter filter){
        List<Apple> filterList = new ArrayList<>();
        for (Apple apple : list){
            if (filter.test(apple)){
                filterList.add(apple);
            }
        }
        return filterList;
    }

}

package java8;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2019/8/1 18:12
 *
 * 筛选出红色并且重量大于1kg的苹果
 */
public class RedAndMoreThan1kgApple implements AppleFilter{
    @Override
    public boolean test(Apple apple) {
        return "red".equalsIgnoreCase(apple.getColor()) && apple.getWeight() > 1.0;
    }
}

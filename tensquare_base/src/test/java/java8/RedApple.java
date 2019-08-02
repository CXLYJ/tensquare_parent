package java8;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2019/8/1 18:10
 *
 * 筛选出红色苹果
 */
public class RedApple implements AppleFilter {
    @Override
    public boolean test(Apple apple) {
        return "red".equalsIgnoreCase(apple.getColor());
    }
}

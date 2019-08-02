package java8;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2019/8/1 18:19
 */
public class GreenAndLessThan05OrRedAndMoreThan05Apple implements AppleFilter {
    @Override
    public boolean test(Apple apple) {
        return ("green".equalsIgnoreCase(apple.getColor()) && apple.getWeight() < 0.5)
                || ("red".equalsIgnoreCase(apple.getColor()) && apple.getWeight() > 0.5);
    }
}

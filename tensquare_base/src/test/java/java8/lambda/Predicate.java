package java8.lambda;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2019/8/1 19:05
 */
@FunctionalInterface
public interface Predicate<T> {

    boolean test(T t);

}

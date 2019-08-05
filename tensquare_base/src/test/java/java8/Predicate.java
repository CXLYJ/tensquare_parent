package java8;

import java.util.Objects;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2019/8/5 10:46
 */
@FunctionalInterface //函数式接口
public interface Predicate<T> {

    boolean test(T t);

    default Predicate<T> add(Predicate<? super T> other){
        Objects.requireNonNull(other);
        return t -> test(t) && other.test(t);
    }

    default Predicate<T> negate(){
        return t -> !test(t);
    }

    default Predicate<T> or(Predicate<? super T> other){
        Objects.requireNonNull(other);
        return t -> test(t) || other.test(t);
    }

    static <T> Predicate<T> isEqual(Object targetRef){
        return (null == targetRef)
                ? Objects :: isNull
                : object -> targetRef.equals(object);
    }

}

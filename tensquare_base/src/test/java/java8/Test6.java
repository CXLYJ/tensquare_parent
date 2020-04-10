package java8;

import java.util.ArrayList;
import java.util.List;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
<<<<<<< HEAD
 * @date ：2020/3/18 17:19
 *
=======
 * @date ：2019/11/8
>>>>>>> 16aed8af0adefbed7992b249aa0d71b172a1fcc2
 * java8流的初步调研
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


<<<<<<< HEAD

=======
>>>>>>> 16aed8af0adefbed7992b249aa0d71b172a1fcc2

        //通过stream方法把list或者数组转换成流
        Arrays.asList("a1","a2","a3").stream().forEach(System.out :: println);
        Arrays.stream(new int[]{1,2,3}).forEach(System.out :: println);
        System.out.println(" ");

        //通过stream.of的方法直接传入多个元素构成一个流
        String[] arr = {"a", "b", "c"};
        Stream.of("a", "b", "c").forEach(System.out :: println);
        Stream.of(1, 2, "a").map(item -> item.getClass().getName()).forEach(System.out :: println);
        System.out.println(" ");

        //通过stream.iterate方法使用迭代的方法构造一个无线流，然后使用limit限制流元素个数
        Stream.iterate(2, item -> item * 2).limit(10).forEach(System.out :: println);
        Stream.iterate(BigInteger.ZERO, n -> n.add(BigInteger.TEN)).limit(10).forEach(System.out :: println);
        System.out.println(" ");

        //通过Stream.generate方法从外部传入一个提供元素的Supplier来构造无限流，然后使用limit限制流元素个数
        Stream.generate(() -> "test").limit(3).forEach(System.out :: println);
        Stream.generate(Math :: random).limit(5).forEach(System.out :: println);
        System.out.println(" ");

        //演示IntStream和DoubleStream
        IntStream.range(1,3).forEach(System.out :: println);
        IntStream.range(0, 3).mapToObj(i -> "x").forEach(System.out::println);
        System.out.println(" ");


        IntStream.rangeClosed(1, 3).forEach(System.out::println);
        DoubleStream.of(1.1, 2.2, 3.3).forEach(System.out::println);
        System.out.println(" ");

        //注意基本类型流和装箱后的流的区别
        Arrays.asList("a", "b", "c").stream()
                .mapToInt(String :: length)
                .asLongStream()
                .mapToDouble(x -> x / 10.0)
                .boxed()
                .mapToLong(x -> 1L)
                .mapToObj(x -> "")
                .collect(Collectors.toList());

    }

}

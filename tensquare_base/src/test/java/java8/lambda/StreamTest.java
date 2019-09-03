package java8.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2019/8/5 14:31
 *
 * java8中流的使用(1)
 */
public class StreamTest {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("Java", "JavaScript", "python", "PHP", "C#", "Golang", "Swift");
//        List<String> filterList = new ArrayList<>();
//        for (String str : list){
//            if (str.startsWith("J")){
//                filterList.add(str.toUpperCase());
//            }
//        }
//
//        for(String str : filterList){
//            System.out.println(str);
//        }

        //Streams接口支持·filter方法，该方法接收一个Predicate<T>，
        // 函数描述符为T -> boolean，用于对集合进行筛选，返回所有满足的元素：
        list.stream()
                .filter(l -> l.startsWith("J"))
                .map(String::toUpperCase)
                .forEach(System.out::println);

        //distinct方法用于排除流中重复的元素，类似于SQL中的distinct操作。
        // 比如筛选中集合中所有的偶数，并排除重复的结果：
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        numbers.stream()
                .filter(i -> i % 2 == 0)
                .distinct()
                .forEach(System.out::println);

        //skip(n)方法用于跳过流中的前n个元素，如果集合元素小于n，则返回空流。比如筛选出以J开头的元素，并排除第一个：
        list.stream()
                .filter(s -> s.startsWith("J"))
                .skip(1)
                .forEach(System.out::println);

        //limit(n)方法返回一个长度不超过n的流，比如下面的例子将输出Java JavaScript python：
        list.stream()
                .limit(3)
                .forEach(System.out::println);

        //map方法接收一个函数作为参数。这个函数会被应用到每个元素上，并将其映射成一个新的元素。如：
        list.stream()
                .map(String::length)
                .forEach(System.out::println);

        //map还支持将流特化为指定原始类型的流，如通过mapToInt，mapToDouble和mapToLong方法，可以将流转换为IntStream，
        // DoubleStream和LongStream。特化后的流支持sum，min和max方法来对流中的元素进行计算。比如：
        IntStream intStream = numbers.stream().mapToInt(a -> a);
        System.out.println(intStream.sum()); // 16
        //也可以通过下面的方法，将IntStream转换为Stream：
//        Stream<Integer> s = intStream.boxed();


        list.stream()
                .map(s -> s.split(""))
                .flatMap(Arrays :: stream)
                .distinct()
                .forEach(s -> System.out.print(s + " "));


    }

}

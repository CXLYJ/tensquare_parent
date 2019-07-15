package java8;

import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2019/7/15 10:29
 *
 * 对象的用法（java8新特性）
 */
public class Test4 {

    public static void main(String[] args) {
        Person ss = new Person();
        ss.setName("iclyj");
        ss.setEmailAddress("iclyj");

        Person aa = new Person();
        aa.setName("aiclyj");
        aa.setEmailAddress("aiclyj");

        List<Person> list = new ArrayList<>();
        list.add(ss);
        list.add(aa);

        List<String> newList = list.stream().map(Person :: getName).filter(
                ee -> StringUtils.hasLength(ee)
        ).distinct().collect(Collectors.toList());

//        List<String> newList=list.stream().map(Person::getName).collect(Collectors.toList());

        for (String string : newList) {
            System.out.println(string);
        }

    }

}

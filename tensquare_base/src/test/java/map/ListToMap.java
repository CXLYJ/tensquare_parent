package map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2019/7/3 11:24
 *
 * 将list转为map
 */
public class ListToMap {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("123");
        list.add("321");

        Map<String, String> map = new HashMap<>();
        for (String s : list){
            map.put(s,s);
        }
        System.out.println(map);
    }

}

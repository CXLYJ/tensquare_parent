package map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2019/7/19 10:02
 */
public class Test {

    public static void main(String[] args) {
        //创建集合对象
        Set<String> set = new HashSet<>();
        //添加元素对象
        set.add("hello");
        set.add("world");
        set.add("world");
        set.add("java");

        //转数组
        Object[] o = set.toArray();
        for (int i = 0; i < o.length; i++){
            System.out.println(o[i]);
        }

        HashMap<String,Integer> hashMap = new HashMap<>();
        hashMap.put("张三",18);
        hashMap.put("李四",20);
        hashMap.put("李四",20);

        Set<Map.Entry<String,Integer>> entries = hashMap.entrySet();
        for (Map.Entry<String,Integer> entry : entries){
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println("key：" + key + "，value：" + value);
        }

    }

}

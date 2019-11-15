package map;

import java.util.*;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2019/7/17 16:29
 */
public class HashMapTest {

    public static void main(String[] args) {
        HashMap<Integer,String> hashMap = new HashMap<>();
        hashMap.put(400,"dd");
        hashMap.put(3,"cc");
        hashMap.put(2,"bb");
        hashMap.put(1,"aa");

        System.out.println(hashMap);

        //将keySet放入list
        ArrayList<Integer> list = new ArrayList<>(hashMap.keySet());
        //调用sort方法重写比较器进行升/降序
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 > o2 ? 1 : -1;
            }
        });

        Iterator<Integer> iterator = list.iterator();
        //迭代排序后的key的list
        while ((iterator.hasNext())){
            Integer key = iterator.next();
            String value = hashMap.get(key);
            System.out.print(key+"="+value+",");
        }
        System.out.println();

        System.out.println(hashMap);
        TreeMap<Integer,String> treeMap = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 > o2 ? 1 : -1;
            }
        });

        treeMap.putAll(hashMap);
        System.out.println(treeMap);

        ArrayList<Map.Entry<Integer,String>> list1 = new ArrayList<>(hashMap.entrySet());
//        Collections.sort(list1, new Comparator<map.Entry<Integer, String>>() {
//            @Override
//            public int compare(map.Entry<Integer, String> o1, map.Entry<Integer, String> o2) {
//                return o1.getValue().compareTo(o2.getValue()); //升序，前边加负号为降序
//            }
//        });

        Collections.sort(list1,Comparator.comparing(Map.Entry :: getValue));

        for (Map.Entry<Integer,String> m: list1){
            System.out.println(m.getKey()+"="+m.getValue());
        }

     }

}

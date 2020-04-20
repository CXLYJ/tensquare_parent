package map;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2019/6/17 11:14
 *
 * Map高级用法：排序(map的排序使用)
 */
public class HashMapCode {

    public static void main(String[] args) {
//        sortMap();
//        sortTreeMap();
        sortTreeMapDate();
    }

    public static void sortMap(){
        HashMap<Integer,String> hashMap = new HashMap<>();
        hashMap.put(400,"dd");
        hashMap.put(3,"cc");
        hashMap.put(2,"bb");
        hashMap.put(1,"aa");

        System.out.println(hashMap);

        //将keySet放入list
        ArrayList<Integer> list = new ArrayList<>(hashMap.keySet());
        //调用sort方法并重写比较器进行升/降排序
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 > o2 ? 1 : -1;
            }
        });

        Iterator<Integer> iterator = list.iterator();
        //迭代排序后的key的list
        while (iterator.hasNext()){
            Integer key = iterator.next();
            String value = hashMap.get(key);
            System.out.println(key + "=" + value + ",");
        }
        System.out.println();
    }

    public static void sortTreeMap(){
//        map<String,String> map = new TreeMap<>(); //大写字母的ASCII码都小于小写字母所以不会正常排序
//        map<String,String> map = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

//        map<String,String> map = new TreeMap<>(new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//               return o2.compareTo(o1); //将两个对象翻转过来逆序的
//            }
//        });

//        map<String,String> map = new TreeMap<>(Collections.reverseOrder());

        Map<String,String> map = new TreeMap<>(Collections.reverseOrder(String.CASE_INSENSITIVE_ORDER)); //忽略大小写逆序

        map.put("a","abstract");
        map.put("c","call");
        map.put("b","basic");
        map.put("T","tree");
        for (Map.Entry<String, String> kv : map.entrySet()){
            System.out.println(kv.getKey() + "=" + kv.getValue() + " ");
        }
    }

    public static void sortTreeMapDate(){
//        map<String,Integer> map = new TreeMap<>();

        Map<String,Integer> map = new TreeMap<>(new Comparator<String>() {

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            @Override
            public int compare(String o1, String o2) {
                try {
                    return sdf.parse(o1).compareTo(sdf.parse(o2));
                } catch (ParseException e) {
                    e.printStackTrace();
                    return 0;
                }
            }
        });

        map.put("2016-7-3",100);
        map.put("2016-7-10",120);
        map.put("2016-8-1",90);

        for (Map.Entry<String,Integer> kv : map.entrySet()){
            System.out.println(kv.getKey() + ", " + kv.getValue());
        }
    }

}

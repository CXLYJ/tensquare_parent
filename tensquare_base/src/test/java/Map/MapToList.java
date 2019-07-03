package Map;

import java.util.*;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2019/7/3 10:19
 *
 * 将map转换成list
 */
public class MapToList {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("a", "111");
        map.put("b", "222");
        map.put("c", "333");

        //取出所有的values值
//        List<String> list = new ArrayList<>(map.values());
//        for (int i = 0; i < list.size(); i++){
//            System.out.println(list.get(i));
//        }

//        List<String> listNext = new ArrayList<>(map.keySet());
//       Iterator iterator = listNext.iterator();
//       while (iterator.hasNext()){
//           System.out.println(iterator.next());
//       }

//        ArrayList list = new ArrayList<>(map.entrySet());
//        for (Object s : list){
//            System.out.println(s);
//        }

//         Set<Map.Entry<String,String>> entrySet = map.entrySet();
//
//         for (Map.Entry<String, String> entry : entrySet){
//             System.out.println("key = " + entry.getKey() + ",value = " + entry.getValue());
//        }


        for (Map.Entry<String,String> entry : map.entrySet()){
            System.out.println("key = " + entry.getKey() + ",value = " + entry.getValue());
        }



    }
}

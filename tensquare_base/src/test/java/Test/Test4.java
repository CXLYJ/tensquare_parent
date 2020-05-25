package Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2020/5/21
 *
 * 取出数组中重复的数字
 */
public class Test4 {

    public static void main(String[] args) {
//        int a[] ={1,2,3,4,5,5,6};
//        int val_max = -1;
//        int time_max = 0;
//        for (int i = 0; i < a.length; i++){
//            int time_temp = 0;
//            for (int j = 0; j < a.length; j++){
//                if (a[i] == a[j]){
//                    time_temp += 1;
//                }
//                if (time_temp > time_max){
//                    time_max = time_temp;
//                    val_max = a[i];
//                }
//            }
//        }
//        System.out.println(val_max);

        int a[] = {1,2,3,4,5,5,6};
        Map<Integer, Integer> d = new HashMap<>();
        for (int i = 0; i < a.length; i++){
            if (d.containsKey(a[i])){
                d.put(a[i], d.get(a[i]) + 1);
            }else {
                d.put(a[i], 1);
            }
        }

        int val_max = -1;
        int time_max = 0;
        int count = 0;
        for (Integer key : d.keySet()){
            if (d.get(key) > time_max){
                time_max = d.get(key);
                val_max = count;
            }
            count ++;
        }
        System.out.println(d);
    }

}

package Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2019/12/4 22:49
 *
 * 找出两个数组中不同的数
 */
public class Nodecode {

    /**
     * 原题：
     * 有一串递增的数据[1,2,3,4,5....N]，从中抽取一个数为X，将抽出X的数组即[1,2,3,4,5.....	N-1]
     * 这个的数组重新打乱找出被抽取的数。
     *
     * 例：从数组[1,2,3,4,5]抽出3，将数组打乱成[5,1,4,2]找出其中被抽取的数是3。
     */


    /**
     * 查找两个数组中不同的数
     * @param t1
     * @param t2
     * @param <T>
     * @return
     */
    public static <T> List<T> comport(T[] t1, T[] t2){
        List<T> list2 = Arrays.asList(t2);
        List<T> list1 = new ArrayList<T>();
        for (T t : t1){
            if (!list2.contains(t)){
               list1.add(t);
            }
        }
        return list1;
    }

    public static void main(String[] args) {
        Integer[] a = {1,2,3,4,5};
        Integer[] b= {5,1,4,3};
        List<Integer> result = comport(a,b);
        for (Integer code : result){
            System.out.println(code);
        }
    }

}

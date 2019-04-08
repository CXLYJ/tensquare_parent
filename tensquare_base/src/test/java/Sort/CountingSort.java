package Sort;

import java.util.Arrays;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2019/3/29 10:46
 *
 * 计数排序
 */
public class CountingSort {

    public static int[] CountingSorts(int[] array){
        if (array.length == 0)
            return array;
        //定义变量
        int bias,min = array[0],max = array[0];
        for (int i = 1; i < array.length; i++){
            if (array[i] > max)
                max = array[i];
            if (array[i] < min)
                min = array[i];
        }
        bias = 0 - min;
        int[] bucket = new int[max - min + 1];
        //将0填充给指定数组的每个元素
        Arrays.fill(bucket,0);
        for (int i = 0; i < array.length; i++){
            bucket[array[i] + bias]++;
        }
        int index = 0, i = 0;
        while (index < array.length){
            if (bucket[i] != 0){
                array[index] = i - bias;
                bucket[i] -- ;
                index ++;
            }else {
                i ++;
            }
        }
        return array;
    }

}

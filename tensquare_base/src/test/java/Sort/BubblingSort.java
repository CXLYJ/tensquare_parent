package Sort;

import java.util.Arrays;

/**
 * Created by lyj on 2019/2/20.
 *
 * 冒泡排序
 */
public class BubblingSort {

    /**
     * 算法描述
     *   1.比较相邻的元素。如果第一个比第二个大，就交换它们两个；
         2.对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大的数；
         3.针对所有的元素重复以上的步骤，除了最后一个；
         4.重复步骤1~3，直到排序完成。

        最佳情况：T(n) = O(n)   最差情况：T(n) = O(n2)   平均情况：T(n) = O(n2)
     * @param array
     */
    public static void bubbleSort(int[] array){
        if (array.length == 0)
            return ;
        for (int i = 0; i < array.length-1; i ++){
            for (int j = 0; j < array.length-1-i ; j++){
                if (array[j] > array[j+1]){
                    int temp = array[j + 1];
                    array[j+1] = array[j];
                    array[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }

    public static void main(String[] args) {
        int [] array = new int[]{6,2,7,3,1,4,5};
        bubbleSort(array);
    }

}

package Sort;

import java.util.Arrays;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2019/5/8 17:43
 *
 * 冒泡排序(三刷)
 */
public class BubbleSort3 {

    public static void bubbleSort(int[] array){
        if (array.length == 0)
            return;
        for (int i = 0; i < array.length-1; i++){
            for (int j = 0; j < array.length -1- i; j++){
                if (array[j] > array[j + 1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
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

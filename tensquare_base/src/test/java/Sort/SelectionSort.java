package Sort;

import java.util.Arrays;

/**
 * Created by lyj on 2019/2/21.
 *
 * 选择排序
 */
public class SelectionSort {

    /**
     *
     * 表现最稳当的算法之一
     *
     * 2.1 算法描述
       1.n个记录的直接选择排序可经过n-1趟直接选择排序得到有序结果。具体算法描述如下：
       2.初始状态：无序区为R[1..n]，有序区为空；
       3.第i趟排序(i=1,2,3…n-1)开始时，当前有序区和无序区分别为R[1..i-1]和R(i..n）。
        该趟排序从当前无序区中-选出关键字最小的记录 R[k]，将它与无序区的第1个记录R交换，
        使R[1..i]和R[i+1..n)分别变为记录个数增加1个的新有序区和记录个数减少1个的新无序区；
       4.n-1趟结束，数组有序化了。
     *
     * @param array
     */
    public static void SelectionSorts(int[] array){
        if (array.length == 0 )
            return;
        for (int i = 0; i < array.length; i++){
            int minIndex = i;
            for (int j = i; j < array.length; j++){
                if (array[j] < array[minIndex]) //找到最小的数
                    minIndex = j; //将最小的数的索引保存
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
        System.out.println(Arrays.toString(array));
    }

    public static void main(String[] args) {
        int [] array = new int[]{6,2,7,3,1,4,5};
        SelectionSorts(array);
    }

}

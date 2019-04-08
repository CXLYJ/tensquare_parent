package Sort;

import java.util.Random;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2019/3/26 10:40
 */
public class QuickSort {

    /**
     * 快速排序算法
     *
     *   1.从数列中挑出一个元素，称为 “基准”（pivot）；
         2.重新排序数列，所有元素比基准值小的摆放在基准前面，
             所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。
             在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作；
         3.递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序。
     * @param array
     * @param start
     * @param end
     * @return
     */
    public static int[] quickSort(int[] array,int start,int end){
        if (array.length < 1 || start < 0 || end >= array.length || start > end)
            return null;
        int smallIndex = partition(array,start,end);
        if (smallIndex > start)
            quickSort(array,start,smallIndex - 1);
        if (smallIndex < end)
            quickSort(array,smallIndex + 1,end);
        return array;
    }


    /**
     * 快速排序算法
     *
     *
     * 快速排序的基本思想：通过一趟排序将待排记录分隔成独立的两部分，
     * 其中一部分记录的关键字均比另一部分的关键字小，
     * 则可分别对这两部分记录继续进行排序，以达到整个序列有序。
     *
     * @param array
     * @param start
     * @param end
     * @return
     */
    private static int partition(int[] array, int start, int end) {
        //Math.random()是令系统随机选取大于等于 0.0 且小于 1.0 的伪随机 double 值，是Java语言常用代码。
        // 例如：double a=Math.random()*(3-1)+1，设置一个随机1到3的变量。
        int pivot = (int) (start + Math.random() * (end - start + 1));
        int smallIndex = start - 1;
        swap(array,pivot,end);
        for (int i = start; i <= end; i++){
            if (array[i] <= array[end]){
                smallIndex++;
                if (i > smallIndex)
                    swap(array,i,smallIndex);
            }
        }
        return smallIndex;
    }

    /**
     * 交换数组内的两个元素
     * @param array
     * @param i
     * @param j
     */
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


}

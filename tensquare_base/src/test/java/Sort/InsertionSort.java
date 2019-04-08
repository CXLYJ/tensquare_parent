package Sort;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by lyj on 2019/2/25.
 *
 * 插入排序
 *
 * 1.从第一个元素开始，该元素可以认为已经被排序；
   2.取出下一个元素，在已经排序的元素序列中从后向前扫描；
   3.如果该元素（已排序）大于新元素，将该元素移到下一位置；
   4.重复步骤3，直到找到已排序的元素小于或者等于新元素的位置；
   5.将新元素插入到该位置后；
   6.重复步骤2~5。

   算法适用于少量的数据排序，时间复杂度为O(n^2)。是稳定的排序算法
 */
public class InsertionSort {

    public static int[] insertionSorts(int[] array){
        if (array.length == 0)
            return array;
        int current;
        for (int i = 0; i < array.length - 1; i++){
            current = array[i + 1]; //取出后一位的数
            int preIndex = i;  //定义最小下标
            while (preIndex >=0 && current < array[preIndex]){
                array[preIndex + 1] = array[preIndex];
                preIndex--;
            }
            array[preIndex + 1] = current;
        }
//        System.out.println(Arrays.toString(array));
        return array;
    }

    /**
     * 插入排序
     * @param sort
     */
    private static void InsertionSorting(int[] sort) {
        if (sort.length == 0) {
            return;
        }
        for (int i = 1; i < sort.length; i++) {
            int index = i - 1; //定义最小下标
            int temp = sort[i]; //取出后一位的数
            // 3 2 1,3 3 1,2 3 1,2 3 3,2 2 3,1 2 3
            // 3(index) 2(index+1) 1
            while(index >= 0 && sort[index] > temp){
                //将index与index+1(temp)之后的每一位数进行比较，
                //当前一位的数大于现在数
                // 3(index=i-1) 3(index+1=i) 1
                sort[index + 1] = sort[index];
                //将大于他的数复制到后一位上(也就将sort[index]复制到sort[index+1]上)
                //相当于将较大的数往后移动
                index -- ; //逐步比较循环比较
            }
            //2(index+1=i) 3(index=i-1) 1
            sort[index + 1] = temp;
            //将移动到最前的数也就是比较出的最小的数赋值上(当前比较下标赋值上比较的最小数)
            //最后将对应的下标赋值到对应的值
        }
    }


    public static void main(String[] args) {
        Random random =  new Random();
        int[] sort = new int[10];
        for (int i = 0; i < 10; i++){
            sort[i] = random.nextInt(100);
        }
        System.out.println("排序前的数组为：");
        for (int i : sort){
            System.out.println(i + "");
        }
        insertionSorts(sort);
        System.out.println();
        System.out.println("排序后的数组为：");
        for (int i : sort){
            System.out.println(i + "");
        }
    }

}

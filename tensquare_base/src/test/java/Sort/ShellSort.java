package Sort;

import java.util.Random;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2019/3/20 15:15
 * 希尔排序
 */
public class ShellSort {

    /**
     * 思想：基于插入排序，交换不相邻的元素已对数组的局部进行排序，
     * 并最终用插入排序将局部有序的数组排序。
     * 思想是使数组中任意间隔为h的元素都是有序的，这样的数组称为h有序数组.
         特性：In-place sort，unstable sort。
         思想：每次找一个最小值。
         最好情况时间：O(n)。
         最坏情况时间：O(n^2)。
     * @param array
     * @return
     */
    public static int[] ShellSorts(int[] array){
        int len = array.length;
        int temp, gap = len / 2;
        while (gap > 0){
            for (int i = gap; i < len; i++){
                temp = array[i];
                int preIndex = i - gap;
                while (preIndex >= 0 && array[preIndex] > temp){
                    array[preIndex + gap] = array[preIndex];
                    preIndex -= gap;
                }
                array[preIndex + gap] = temp;
            }
            gap /= 2;
        }
        return array;
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
        ShellSorts(sort);
        System.out.println();
        System.out.println("排序后的数组为：");
        for (int i : sort){
            System.out.println(i + "");
        }
    }

}

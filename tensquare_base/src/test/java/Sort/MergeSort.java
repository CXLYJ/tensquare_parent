package Sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2019/3/22 22:29
 *
 * 归并排序
 */
public class MergeSort {

    /**
     * 算法描述
     * @param array
     * @return
     */

    public static int[] mergesort(int[] array){
//        if (array.length < 2)
//            return array;
//        int mid = array.length / 2;
//        //截取数组把数组array从零截取到mid
//        int[] left = Arrays.copyOfRange(array,0,mid);
//        int[] right = Arrays.copyOfRange(array,mid,array.length);
//        return merge(mergesort(left),mergesort(right));
        if (array.length < 2) return array;
        int mid = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);
        return merge(mergesort(left), mergesort(right));
    }

    /**
     * 归并排序——将两段排序好的数组结合成一个排序数组
     * @param left
     * @param right
     * @return
     */
    private static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        for (int index = 0, i = 0, j = 0; index < result.length; index++) {
            if (i >= left.length)
                result[index] = right[j++];
            else if (j >= right.length)
                result[index] = left[i++];
            else if (left[i] > right[j])
                result[index] = right[j++];
            else
                result[index] = left[i++];
        }
        return result;
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
        mergesort(sort);
        System.out.println();
        System.out.println("排序后的数组为：");
        for (int i : sort){
            System.out.println(i + "");
        }
    }

}

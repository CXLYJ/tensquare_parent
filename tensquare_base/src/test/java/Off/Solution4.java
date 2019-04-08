package Off;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by lyj on 2019/2/3.
 * 剑指off
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非减排序的数组的一个旋转，
 * 输出旋转数组的最小元素。 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class Solution4 {


    public static int minNumberInRotateArray(int [] array){
        if (array.length == 0){
            return 0;
        }
        int left = 0;
        int right = array.length - 1;
        int middle = 0;
        while (array[left] >= array[right]){
            if (right - left == 1){
                middle = right;
                break;
            }
            middle = left + (right - left) / 2;
            if (array[middle] >= array[left]){
                left = middle;
            }
            if (array[middle] <= array[right]){
                right = middle;
            }
        }
        System.out.println(array[middle]);
        return array[middle];
    }

    public static void main(String[] args) {
        int array[] = new int[]{3,4,5,1,2};
        minNumberInRotateArray(array);
        List<Integer> list = Arrays.stream(array).boxed().collect(Collectors.toList());
        System.out.println(list);
//        int[] src = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
//        List<Integer> list = Arrays.stream( src ).boxed().collect(Collectors.toList());
//        System.out.println(list);

    }
}

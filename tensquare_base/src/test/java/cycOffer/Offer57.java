package cycOffer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2019/12/6 22:25
 *
 * 和为S的两个数
 */
public class Offer57 {

    /**
     * 动态规划思想
     * @param array
     * @param sum
     * @return
     */
    public static ArrayList<Integer> FindNumbersWithSum(int[] array, int sum){
        if (array == null || array.length == 0)
            return new ArrayList<>();
        int left = 0, right = array.length - 1;
        while (left < right){
            int count = array[left] + array[right];
            if (count == sum)
                return new ArrayList<>(Arrays.asList(array[left], array[right]));
            if (count < sum)
                left++;
            else
                right --;
        }
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        int [] array = {1,2,3,4,5,6,7,8,9};
        int sum = 5;
        System.out.println(FindNumbersWithSum(array, sum));
    }

}

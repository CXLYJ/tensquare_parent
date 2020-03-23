package cycOffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2019/12/6
 *
 * 和为 S 的两个数字
 */
public class Offer57 {

    /**
     * 题目描述
     *
     * 输入一个递增排序的数组和一个数字 S，
     * 在数组中查找两个数，使得他们的和正好是 S。
     * 如果有多对数字的和等于 S，输出两个数的乘积最小的。
     */

    /**
     * 解题思路
     *
     * 使用双指针，一个指针指向元素较小的值，一个指针指向元素较大的值。
     * 指向较小元素的指针从头向尾遍历，指向较大元素的指针从尾向头遍历。
     *
     * 如果两个指针指向元素的和 sum == target，那么得到要求的结果；
     * 如果 sum > target，移动较大的元素，使 sum 变小一些；
     * 如果 sum < target，移动较小的元素，使 sum 变大一些。
     *
     * @param array
     * @param sum
     * @return
     */
     public static ArrayList<Integer> FindNumbersWithSum(int[] array, int sum){
         int i = 0, j = array.length - 1;
         while (i < j){
             int cur = array[i] + array[j];
             if (cur == sum)
                 return new ArrayList<>(Arrays.asList(array[i],array[j]));
             if (cur < sum)
                 i++;
             else
                 j--;
         }
         return new ArrayList<>();
     }

    /**
     * 输出的两个数的乘积最小的理解
     * 假设: 若b > a,且存在
     * a+b=s
     * (a-m) + (b + m) = s
     * 则 (a - m )(b + m)=ab - (b-a)m - m*m < ab；说明外层的乘积更小
     * 也就是说依然是左右夹逼法！！！只需要2个指针
     * 1.left开头，right指向结尾
     * 2.如果和小于sum，说明太小了，left右移寻找更大的数
     * 3.如果和大于sum，说明太大了，right左移寻找更小的数
     * 4.和相等，把left和right的数返回
     *
     */
    public ArrayList<Integer> FindNumbersWithSums(int[] array, int sum){
        if (array == null || array.length == 0)
            return new ArrayList<>();
        int left = 0,right = array.length - 1;
        while (left < right){
            int total = array[left] + array[right];
            if (total == sum)
                return new ArrayList<>(Arrays.asList(array[left],array[right]));
            if (total < sum)
                left ++;
            else
                right --;
        }
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        int[] array= {1,2,3,4,5,6,7,8,9};
        int sum = 9;
        List<Integer> result = FindNumbersWithSum(array, sum);
        System.out.println(result);
        for (Integer s : result){
            System.out.println(s);
        }
    }
}

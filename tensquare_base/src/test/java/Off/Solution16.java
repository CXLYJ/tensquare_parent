package Off;

import java.util.ArrayList;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2019/4/12 10:23
 *
 * 题目描述
 *
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，
 * 使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 */
public class Solution16 {

    /**
     * 思路
     *
     * 数列满足递增，设两个头尾两个指针i和j，
     若ai + aj == sum，就是答案（相差越远乘积越小）
     若ai + aj > sum，aj肯定不是答案之一（前面已得出 i 前面的数已是不可能），j -= 1
     若ai + aj < sum，ai肯定不是答案之一（前面已得出 j 后面的数已是不可能），i += 1
     */

    public static ArrayList<Integer> FindNumbersWithSum(int [] array,int sum){
        ArrayList<Integer> returnList = new ArrayList<>();
        if (array.length <=1 )
            return returnList;
        for (int i = 0, j = array.length-1; i < j;){
            if (array[i] + array[j] == sum){
                returnList.add(array[i]);
                returnList.add(array[j]);
                return returnList;//找到直接返回
            }else if (array[i] + array[j] > sum){
                //和已经大于目标值了，所以大数要减小！
                j--;
            }else {
                //和小于目标值所以，所以小数要增大
                i++;
            }
        }
        return returnList;
    }

    public static void main(String[] args) {
        int [] array = new int[]{1,2,3,4,5,6,7,8};
//        int[] array1 = {1,2,3,4,5,6,7}
        int sum = 8;
        ArrayList<Integer> arrayList = FindNumbersWithSum(array,sum);
        System.out.println(arrayList);
    }

}

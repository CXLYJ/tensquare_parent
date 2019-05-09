package Off;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2019/5/8 18:04
 *
 * 剑指offer-数组中重复的数字
 *
 * 此大法利用了哈希的特性，但不需要额外的存储空间。 因此时间复杂度为O(n)，不需要额外空间！
 */
public class Solution23 {

    /**
     * 题目
     *
     * 链接：https://www.nowcoder.com/questionTerminal/623a5ac0ea5b4e5f95552655361ae0a8
     来源：牛客网
     在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。
     也不知道每个数字重复几次。请找出数组中任意一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，
     那么对应的输出是第一个重复的数字2。
     */

    /**
     * 思路
     *
     * 把当前序列当成是一个下标和下标对应值是相同的数组；
     遍历数组，判断当前位的值和下标是否相等： 2.1. 若相等，则遍历下一位；
     2.2. 若不等，则将当前位置i上的元素和a[i]位置上的元素比较：若它们相等，则成功！若不等，则将它们两交换。
     - - 换完之后a[i]位置上的值和它的下标是对应的，但i位置上的元素和下标并不一定对应；重复2.2的操作，
     直到当前位置i的值也为i，将i向后移一位，再重复2.
     */

    public boolean duplicate(int array[],int length,int [] duplication){
        if (array == null)
            return false;

        //判断数组是否合法（每个数都在0到n-1之间）
        for (int i = 0; i < length; i++){
            if (array[i] < 0 || array[i] > length -1)
                return false;
        }

        //key step
        for (int i = 0; i < length; i++){
            while (i != array[i]){
                if (array[i] == array[array[i]]){
                    duplication[0] = array[i];
                    return true;
                }
                int temp = array[i];
                array[i] = array[array[i]];
                array[array[i]] = temp;
            }
        }
        return false;
    }

}

package leetCode;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2019/6/20 10:40
 *
 * leetCode-把数组中的 0 移到末尾
 */
public class Solution8 {

    /**
     * 题目描述
     *
     * For example, given nums = [0, 1, 0, 3, 12], after calling your function,
     * nums should be [1, 3, 12, 0, 0].
     */

    public static void moveZeroes(int[] nums){
        int idx = 0;
        for (int num : nums){
            if (num != 0)
                nums[idx++] = num;
        }
        while (idx < nums.length){
            nums[idx++] = 0;
        }

//        for (int num : nums){
//            System.out.println(num);
//        }

        for (int i = 0; i < nums.length; i++){
            System.out.println(nums[i]);
        }
    }

    public static void main(String[] args) {
        int [] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);
    }

}

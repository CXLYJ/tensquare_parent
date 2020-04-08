package leetCode;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2020/1/3
 *
 * 把数组中的 0 移动到末尾
 */
public class MoveZeroes {

    /**
     * For example, given nums = [0, 1, 0, 3, 12],
     * after calling your function, nums should be [1, 3, 12, 0, 0]
     * @param nums
     */
    public void moveZeroes(int[] nums){
        int idx = 0;
        for (int num : nums){
            if (num != 0)
                nums[idx++] = num;
        }
       while (idx < nums.length){
           nums[idx++] = 0;
       }
    }

}

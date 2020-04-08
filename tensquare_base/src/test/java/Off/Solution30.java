package Off;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2020/3/15 23:37
 *
 * 旋转数组的最小数字
 */
public class Solution30 {

    public int findMin(int[] nums){
        if (nums == null|| nums.length == 0 ) {
            return -1;
        }

        int min = nums[0];
        int n = nums.length;
        if (min < nums[n - 1]){
            return min;
        }
        for (int i = 1; i < n; i ++){
            min = Math.min(min, nums[i]);
        }
        return  min;
    }
}

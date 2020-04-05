package Off;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2020/3/31 17:19
 *
 * 旋转数组中最小数
 */
public class Solution33 {

    /**
     * 获取旋转数组的最小元素
     *
     * @param nums 旋转数组
     * @return 数组中的最小值
     */
    public int findMin(int[] nums){
        if (nums == null || nums.length == 0)
            return -1;
        int min = nums[0];
        int n = nums.length;
        if (min < nums[n - 1]){
            return min;
        }
        for (int i = 1; i < n; i++){
            min = Math.min(min, nums[i]);
        }
        return min;
    }

}

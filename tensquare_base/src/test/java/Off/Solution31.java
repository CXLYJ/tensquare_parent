package Off;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2020/3/18 17:12
 *
 *  股票的最大利润
 */
public class Solution31 {

    /**
     * 遍历到 nums[i] 时，求 nums[i] 与前 i 个数的最小值 min 的差值，最后求出最大的差值即可
     *
     * @param nums 数组
     * @return 最大利润
     */
    public int indexDiff(int[] nums){
        if (nums == null || nums.length < 2)
            return 0;
        int min = nums[0];
        int maxGap = nums[1] - nums[0];
        for (int i = 2, n = nums.length; i < n; ++i){
            min = Math.min(min, nums[i - 1]);
            maxGap = Math.max(maxGap, nums[i] - min);
        }
        return maxGap > 0 ? maxGap : 0;
    }

    public static void main(String[] args) {
        float a = 0;
        a = a + 1;
        if (++a > 1){
            a = a + 1;
        }
        System.out.println(a);
    }


}

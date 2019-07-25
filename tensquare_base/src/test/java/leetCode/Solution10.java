package leetCode;

import java.util.Arrays;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2019/7/25 10:53
 *
 * 最长递增子序列
 */
public class Solution10 {

    public int lengthOfLIS(int[] nums){
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++){
            int max  = 1;
            for (int j = 0; j < i; j++){
                if (nums[i] > nums[j]){
                    max = Math.max(max,dp[j] + 1);
                }
            }
            dp[i] = max;
        }
        return Arrays.stream(dp).max().orElse(0);
    }

}

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
        int n = nums.length; //定义长度
        int[] dp = new int[n]; //放进一个一维数组
        for (int i = 0; i < n; i++){ //循环遍历
            int max  = 1; //定义初始最大值为1
            for (int j = 0; j < i; j++){
                if (nums[i] > nums[j]){ //比较前后的值
                    max = Math.max(max,dp[j] + 1); //返回最大的那个值
                }
            }
            dp[i] = max;
        }
//        return Arrays.stream(dp).max().orElse(0);  //导致时间过长

        int ret = 0;
        for (int i = 0; i < n; i++) { //再与从到n比较一遍
            ret = Math.max(ret, dp[i]); //取出最大的值
        }
        return ret;

    }

}

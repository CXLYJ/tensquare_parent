package cycOffer;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2019/12/5 23:24
 * 剪绳子
 *
 * 把一根绳子剪成多段，并且使得每段的长度乘积最大。
 */
public class offer14 {

    public int integerBreak(int n){
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i < n; i++)
            for (int j = 1; j < i; j++)
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), dp[j] * (i - j)));
            return dp[n];
    }

}

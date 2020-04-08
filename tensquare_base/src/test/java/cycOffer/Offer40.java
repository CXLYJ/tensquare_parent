package cycOffer;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2019/12/2
 *
 * 礼物的最大值
 *
 * 解题思路：应该用动态规划求解，而不是深度优先搜索，深度优先搜索过于复杂，不是最优解
 */
public class Offer40 {

    /**
     * 动态规划思想
     * 
     * @param values
     * @return
     */
    public static int getMost(int[][] values){
        if (values == null || values.length == 0 || values[0].length == 0)
            return 0;
        int n = values[0].length;
        int[] dp = new int[n];
        for (int[] value : values){
            dp[0] += value[0];
            for (int i = 1; i < n; i++){
                dp[i] = Math.max(dp[i], dp[i - 1]) + value[i];
            }
        }
        return dp[n - 1];
    }


    /**
     *
     * 题目描述
     * 在一个 m*n 的棋盘的每一个格都放有一个礼物，每个礼物都有一定价值（大于 0）。
     * 从左上角开始拿礼物，每次向右或向下移动一格，直到右下角结束。给定一个棋盘，
     * 求拿到礼物的最大价值。例如，对于如下棋盘。
     *
     * 1    10   3    8
     * 12   2    9    6
     * 5    7    4    11
     * 3    7    16   5
     * Copy to clipboardErrorCopied
     * 礼物的最大价值为 1+12+5+7+7+16+5=53。
     *
     * @param args
     */

    public static void main(String[] args) {
        int[][] arr= {{1,10,3,8},{12,2,9,6},{5,7,4,11},{3,7,16,5}};
//        int[][] arr = {
//                {10,20,30,100},
//                {40,50,60,110},
//                {70,80,90,120}
//        };

//        for (int[] is: arr){
//            for (int i : is){
//                System.out.println(i);
//            }
//        }

        System.out.println(getMost(arr));

    }

}

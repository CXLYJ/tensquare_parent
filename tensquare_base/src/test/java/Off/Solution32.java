package Off;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2020/3/21 23:00
 */
public class Solution32 {

    /**
     * 求连续子数组的最大和
     * @param array 数组
     * @return 最大和
     */
    public static int FindGreatestSumOfSubArray(int[] array){
        int n = array.length;
        int[] res = new int[n];
        res[0] = array[0];
        int max = res[0];
        for (int i = 1; i < n; ++i){
            res[i] = res[ i - 1] > 0 ? res[ i - 1] + array[i] : array[i];
            max = Math.max(max, res[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] res = new int[]{1,2,3,5,6,-1,0,6,9};
        System.out.println(FindGreatestSumOfSubArray(res));
    }

}

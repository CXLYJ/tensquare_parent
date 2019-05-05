package Off;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2019/5/5 10:46
 *
 * 剑指offer-整数中1出现的次数(暴力解法)
 */
public class Solution22 {

    /**
     * 题目描述
     *
     * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
     * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。
     * ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
     */

    /**
     * 暴力解法
     *
     * 你可从1遍历到n，然后将当前被遍历的到的数中1出现的次数累加到结果
     */

    public int NumberOf1Between1AndN_Solution(int n){
        if (n < 1)
            return 0;
        int res = 0;
        for (int i = 1; i < n; i++){
            res += count(i);
        }
        return res;
    }

    private int count(int n) {
        int count = 0;
        while (n != 0){
            //取个位
            count = (n % 10 ==1) ? ++count : count;
            //去掉个位
            n /= 10;
        }
        return count;
    }

}

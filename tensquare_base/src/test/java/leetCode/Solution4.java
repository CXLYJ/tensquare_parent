package leetCode;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2019/5/13 11:22
 *
 * LeetCode-大于给定元素的最小元素
 */
public class Solution4 {

    /**
     * 题目描述
     *
     * 题目描述：给定一个有序的字符数组 letters 和一个字符 target，
     * 要求找出 letters 中大于 target 的最小字符，如果找不到就返回第 1 个字符。
     *
     * Input:
     letters = ["c", "f", "j"]
     target = "d"
     Output: "f"

     Input:
     letters = ["c", "f", "j"]
     target = "k"
     Output: "c"
     */

    /**
     * 思路
     *
     * 给定数组是有序的，给定一个key值。每次查找最中间的值，如果相等，就返回对应下标，如果key大于最中间的值，
     * 则在数组的右半边继续查找，如果小于，则在数组左半边查找，最终有两种结果，一种是找到并返回下标，第二种是没找到
     * @param letters
     * @param target
     * @return
     */

    public char nextGreatestLetter(char[] letters, char target){
        int n = letters.length;
        int l = 0, h = n - 1;
        while (l <= h){
            int m = l + (h - 1) / 2;
            if (target >= letters[m]){
                l = m + 1;
            } else {
                h = m - 1;
            }
        }
        return 1 < n ? letters[l] : letters[0];
    }
}

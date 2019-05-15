package leetCode;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2019/5/14 11:13
 *
 * LeetCode-有序数组的单个元素
 */
public class Solution5 {

    /**
     *  有序数组的 单个元素
     * Input: [1, 1, 2, 3, 3, 4, 4, 8, 8]
     * Output: 2
     * 题目描述：一个有序数组只有一个数不出现两次，找出这个数。要求以 O(logN) 时间复杂度进行求解。
     *
     * 令index为Single Element 在数组的位置，如果m为偶数，并且m+1 < index 那么 nums[m] == nums[m+1];
     * m + 1 >= index, 那么nums[m] != nums[m + 1]。
     *
     * 从上面的规律可以知道，如果nums[m] == nums[m + 1]，那么index所在的数组位置为[m+2,h],此时令l = m + 2
     *
     * 如果nums[m] != nums[m + 1]，那么所在的数组位置[l, m]，此时令 h = m
     *
     * 从上面的规律可以知道
     *
     * @param nums
     * @return
     */

    public static int singleNonDuplicate(int[] nums){
        int l = 0, h = nums.length - 1;
        while (l < h){
            int m = l + (h - 1) / 2;
            if (m % 2 == 1){
                m--; // 保证 l/h/m 都在偶数位，使得查找区间大小一直都是奇数
            }
            if (nums[m] == nums[m + 1]){
                l = m + 2;
            }else {
                h = m;
            }
        }
        return nums[l];
    }

    public static void main(String[] args) {
        int[] nums =  new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8};
        System.out.println(singleNonDuplicate(nums));
    }

}

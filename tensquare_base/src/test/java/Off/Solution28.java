package Off;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2019/6/24 10:59
 *
 * 查找区间
 */
public class Solution28 {

    /**
     * 题目
     *
     *   Input: nums = [5,7,7,8,8,10], target = 8
         Output: [3,4]

         Input: nums = [5,7,7,8,8,10], target = 6
         Output: [-1,-1]
     */

    public static int[] searchRange(int[] nums, int target){
        int first = binarySearch(nums, target);
        int last = binarySearch(nums, target + 1) - 1;
        if (first == nums.length || nums[first] != target){
            return new int[]{-1, -1};
        } else {
            return new int[]{first,Math.max(first,last)};
        }
    }

    private static int binarySearch(int[] nums, int target) {
        int l = 0, h = nums.length; // 注意h 的初始值
        while (l < h){
            int m = l + (h - l) / 2;
            if (nums[m] >= target){
                h = m;
            }else {
                l = m + 1;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        int nums[] = new int[]{5,7,7,8,8,10};
        int target = 8;
        System.out.println(searchRange(nums, target));
    }

}

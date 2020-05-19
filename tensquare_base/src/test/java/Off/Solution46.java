package Off;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2020/5/19
 */
public class Solution46 {

//    public static int[] findNumbersWithSum(int[] nums, int tager){
//        if (nums == null || nums.length < 2)
//            return null;
//        int n = nums.length;
//        Set<Integer> set = new HashSet<>();
//        for (int i = 0; i < n; ++i){
//            if (set.contains(tager - nums[i])){
//                return new int[] {tager - nums[i], nums[i]};
//            }
//            set.add(nums[i]);
//        }
//        return null;
//    }

    /**
     * 在数组中找出和为target的两个数
     *
     * @param nums 数组
     * @param target 目标和
     * @return 满足条件的两个数构成的数组
     */
    public static int[] findNumbersWithSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return null;
        }
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; ++i) {
            if (set.contains(target - nums[i])) {
                return new int[] {target- nums[i], nums[i]};
            }
            set.add(nums[i]);
        }
        return null;
    }

    public static void main(String[] args) {
        int sum = 7;
        int[] nums = new int[]{1,2,3,4};
        System.out.println(findNumbersWithSum(nums, sum));
    }

}

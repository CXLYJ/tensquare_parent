package cycOffer;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2020/1/8
 *
 * 数字在排序数组中出现的次数
 */
public class Offer53 {

    /**
     * 题目描述
     *
     * Input:
     * nums = 1, 2, 3, 3, 3, 3, 4, 6
     * K = 3
     *
     * Output:
     * 4
     */

    public static int GetNumberOfK(int[] nums, int k){
        //二分查找法搜索
        int first = binarySearch2(nums, k);
        int last = binarySearch2(nums, k + 1);

        return (first == nums.length || nums[first] != k) ? 0 : last - first;
        
    }

    private static int binarySearch2(int[] nums, int k){
        int l = 0, h = nums.length;
        while (l < h) {
            int m = l + (h - l) /  2;
            if (nums[m] >= k)
                h = m;
            else
                l = m + 1;
        }
      return l;
    }



    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3, 3, 3, 4, 6};
//        int[] a = new int[5];
//        int[] a2 = new int[]{1,2,3};
        int k = 3;
        int result = GetNumberOfK(nums, k);
        System.out.println(result);
    }

}

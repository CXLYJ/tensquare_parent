package leetCode;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2019/5/13 10:57
 *
 * 二分法查找原理
 */
public class Solution3 {

    public int binarySearch(int[] nums, int key){
        int l = 0, h = nums.length - 1;
        while (l < h){
            int m = l + (h - 1) / 2;
            // 如果中间的数就是需要查找的数返回数组的下标
            if (nums[m] == key)
                return m;
            else if (nums[m] > key){
                h = m - 1;
            }else {
                l = m + 1;
            }
        }
        return -1;
    }

}

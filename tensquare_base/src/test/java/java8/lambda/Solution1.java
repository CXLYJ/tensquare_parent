package java8.lambda;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by lyj on 2019/2/9.
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。

 示例:

 给定 nums = [2, 7, 11, 15], target = 9

 因为 nums[0] + nums[1] = 2 + 7 = 9
 所以返回 [0, 1]
 *
 */
public class Solution1 {

    /**
     * 方法三：一遍哈希表
     事实证明，我们可以一次完成。在进行迭代并将元素插入到表中的同时，
     我们还会回过头来检查表中是否已经存在当前元素所对应的目标元素。如果它存在，
     那我们已经找到了对应解，并立即将其返回。

     复杂度分析：

     时间复杂度：O(n)O(n)， 我们只遍历了包含有 nn 个元素的列表一次。在表中进行的每次查找只花费 O(1)O(1) 的时间。

     空间复杂度：O(n)O(n)， 所需的额外空间取决于哈希表中存储的元素数量，该表最多需要存储 nn 个元素。
     * @param nums
     * @param target
     * @return
     */

    /**
     * TODO 需要待改造成lambda写法
     * @param nums
     * @param target
     * @return
     */

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        twoSum(nums,target);
    }

}

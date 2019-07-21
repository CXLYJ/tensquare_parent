package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2019/7/19 11:21
 *
 * 找出集合的所有子集，子集不能重复，[1, 2] 和 [2, 1] 这种子集算重复
 */
public class Solution9 {

   public List<List<Integer>> subsets(int[] nums){
       List<List<Integer>> subsets = new ArrayList<>();
       List<Integer> tempSubset = new ArrayList<>();
       for (int size = 0; size <= nums.length; size++){
           backtracking(0, tempSubset, subsets, size, nums); // 不同的子集大小
       }
       return subsets;
   }

    private void backtracking(int start, List<Integer> tempSubset, List<List<Integer>> subsets,
                              final int size, int[] nums) {

       if (tempSubset.size() == size){
           subsets.add(new ArrayList<>(tempSubset));
           return;
       }

       for (int i = start; i < nums.length; i++){
           tempSubset.add(nums[i]);
           backtracking(i+1, tempSubset, subsets, size, nums);
           tempSubset.remove(tempSubset.size() - 1);
       }

    }

}

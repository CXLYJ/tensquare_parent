package leetCode;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2019/5/17 16:53
 *
 * 二分查找正常实现
 */
public class Solution6 {

    /**
     * 题目描述
     *
     * Input : [1,2,3,4,5]
         key : 3
         return the index : 2
     */

    public int binarySearch(int[] nums,int key){
        int l = 0, h = nums.length - 1;
        //如果 l < h 进入while循环
        while (l <= h){
            //计算出中间位置
            int mind = l + (h - l)/2;
            //如果中间位置上的数等于输入的数直接返回下标
            if (nums[mind] == key)
                return mind;
            if (key > nums[mind]){
                l = mind + 1;
            }else {
                h = mind - 1;
            }
        }
        return -1;
    }

}

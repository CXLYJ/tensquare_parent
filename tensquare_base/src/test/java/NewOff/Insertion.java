package NewOff;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2019/11/22
 *
 * 插入排序
 */
public class Insertion <T extends Comparable<T>> extends Sort<T>{

    @Override
    public void sort(T[] nums) {
        if (nums.length == 0)
            return;
        for (int i = 1; i < nums.length; i ++){
            for (int j = i; j > 0 && less(nums[j], nums[j -1]); j--){
                swap(nums, j, j - 1);
            }
        }
    }
}

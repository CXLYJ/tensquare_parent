package NewOff;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2019/11/13 23:15
 *
 * 插入排序
 */
public class Insertion<T extends Comparable<T>> extends Sort<T> {
    @Override
    public void sort(T[] nums) {
        int N = nums.length;
        for (int i = 1; i < N; i++){
            for (int j = i; j > 0 && less(nums[i], nums[j - 1]); j--){
                sawp(nums, j, j - 1);
            }
        }
    }
}

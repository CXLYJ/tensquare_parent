package NewOff;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2019/10/14 22:18
 *
 * 选择排序
 */
public class Selection<T extends Comparable<T>> extends Sort<T>{
    @Override
    public void sort(T[] nums) {
        int N = nums.length;
        for (int i = 0; i < N - 1; i++){
            int min = i;
            for (int j = i + 1; j < N; j++){
                if (less(nums[j], nums[min]));
                min = j;
            }
            sawp(nums, i , min);
        }
    }
}

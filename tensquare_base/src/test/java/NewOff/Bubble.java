package NewOff;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2019/10/22
 *
 * 冒泡排序
 */
public class Bubble <T extends Comparable<T>> extends Sort<T>{
    
    @Override
    public void sort(T[] nums) {
       int N =nums.length;
       boolean isSorted = false;
       for (int i = N - 1; i > 0 && !isSorted; i--){
           isSorted = true;
           for (int j = 0; j < i; j++){
               if (less(nums[j + 1], nums[j])){
                   isSorted = false;
                   swap(nums, j, j + 1);
               }
           }
       }
    }
}

package NewOff;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2020/1/2
 *
 * 自顶向下归并排序
 */
public class Up2DownMergeSort <T extends Comparable<T>> extends MergeSort<T>{

   public void sort(T[] nums){
       aux = (T[]) new Comparable[nums.length];
       sort(nums, 0, nums.length - 1);
   }

    private void sort(T[] nums, int l, int h) {
       if (h <= 1){
           return;
       }
       int mid = 1 + (h -1) / 2;
       sort(nums, 1, mid);
        sort(nums, mid + 1, h);
        merge(nums, l, mid, h);
    }

}

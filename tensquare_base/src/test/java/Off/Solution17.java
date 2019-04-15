package Off;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2019/4/15 16:35
 *
 * 剑指offer-最小的K个数
 */
public class Solution17 {

    /**
     * 题目描述
     *
     * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,
     */

    /**
     * 思路
     *
     * 使用一个大小为K的最大堆，然后堆里面最大的数是堆顶，然后每次比较堆顶的数和数组中的数，
     * 如果堆顶的数比数组中的数A大，那么就把堆顶的数弹出来，把数组中的数A进堆，
     * 这样子到最后堆里面的堆顶始终是比外面的数小，而堆里的其他数是小于堆顶的数（最大堆的性质），
     * 所以堆中的数就是最小的k个数
     */

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input,int k){
        ArrayList<Integer> resultList = new ArrayList<>();
        if (k > input.length || k <= 0)
            return resultList;
        //使用优先队列建堆，优先级队列默认是最小堆，所以要重写比较器
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        for (int i = 0; i < input.length; i++){

            if (i < k){
                //如果没有达到k个数直接入堆
                maxHeap.add(input[i]);
            }else {
                if (maxHeap.peek() > input[i]){
                    //堆项的数比数组当前的数大，那么久堆顶出堆
                    maxHeap.poll();
                    maxHeap.add(input[i]);//b吧当前数加入堆中
                }
            }
        }
        while (maxHeap.isEmpty() != true)
            //把堆中的数出堆添加到结果数组中
            resultList.add(maxHeap.poll());
            return resultList;
    }

}

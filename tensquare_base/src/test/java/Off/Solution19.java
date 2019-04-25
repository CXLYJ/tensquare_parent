package Off;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2019/4/23 17:55
 *
 * 剑指offer-旋转数组的最小值
 */
public class Solution19 {

    /**
     * 题目描述
     *
     * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
     * 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
     * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
     * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
     */

    /**
     * 思路
     *
     * 根据题意说明是一个递增数组的旋转，所以如题所示【3,4,5】，【1,2】还是局部递增的，
     * 在这种的数组中查找，一般选择二分的方法；基本模型有了，下面试着分析：
     * 1.先取出中间的数值，和最后一个比较5>2 说明mid之前的某些部分旋转到了后面，
     * 所以下次寻找 start = mid+1 开始；
     * 2.取出的中间值要是小于end，说明mid-end之间都应为被旋转的部分，
     * 所以最小应该在mid的前面，但是也有可能当前的mid 就是最小的值 所以下次需找的应该 从mid开始，也即end = mid 开始
     * 3.当mid == end的时候，说明数组中存在着相等的数值，
     * 可能是这样的形式 【2,2,2,2,1,2】所以应该选择的end 应该递减1 或者begin加1作为下次寻找的上界。
     */

    public static int minNumberInRotateArray(int [] array){
        if (array.length == 0)
            return 0;
        if (array[0] < array[array.length-1])
            return array[0];
        int start = 0;
        int end = array.length - 1;
        while (start + 1 != end){
            int mid = (start + end)/2;
            if (array[mid] > array[start])
                start = mid;
             else if (array[mid] < array[end])
                 end = mid;
             else {
                 start ++;
            }
        }
        return array[end];
    }

    public static void main(String[] args) {
        int [] array = new int[]{1,2,3,4,5};
        System.out.println(minNumberInRotateArray(array));
    }

}

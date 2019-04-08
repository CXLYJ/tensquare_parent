package Off;

/**
 * Created by lyj on 2019/2/16.
 *
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 */
public class Solution9 {

    /**
     * 其实就是简单的斐波那契数列， f(n) = f(n-1) + f(n-2)
     * @param target
     * @return
     */

    public static int RectCover(int target){
        if (target <= 1){
            return 1;
        }else if (target == 2){
            return 2;
        }else {
            return RectCover(target-1)+RectCover(target-2);
        }
    }

    /**
     * 其实就是一个斐波那契数列，满足公式：d(n) = d(n-1) + d(n-2)
     * @param target
     * @return
     */
    public int RectCover2(int target) {
        int tempNum = 1;
        int result = 2;

        if (target == 0) {
            return 1;
        }

        if (target == 1 || target == 2) {
            return target;
        }

        int count = 2;
        while (count < target) {
            result += tempNum;
            tempNum = result - tempNum;
            count ++;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(RectCover(8));
    }

}

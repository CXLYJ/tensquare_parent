package Off;

import java.util.ArrayList;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2019/4/16 10:12
 *
 * 剑指offer-调整数组顺序使奇数位于偶数前面
 */
public class Solution18 {


    /**
     * 题目描述
     *
     * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
     * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
     */

    /**
     * 思路（直接解法）
     *
     * 题目明确说了，不能修改相对位置，所以只能是用以下的新建两个数组，一个奇数数组，
     * 一个偶数数组，然后把奇数和偶数分别保存到对应的数组，然后在赋值到原数组中
     */

    public void reOrderArray(int [] array){
        ArrayList<Integer> odd =new ArrayList<>();
        ArrayList<Integer> even = new ArrayList<>();
        for (int i = 0; i < array.length; i++){
            if (array[i] % 2 == 1){
                odd.add(array[i]); //加入奇数数组中
            }else {
             even.add(array[i]); //加入偶数数组中
            }
        }
        for (int i =0; i < odd.size(); i++){
            array[i] = odd.get(i); //因为奇数在数组前面
        }
        for (int i = 0; i < even.size(); i++){
            array[odd.size() + i] = even.get(i);//把偶数数组赋值到后面
        }
    }

}

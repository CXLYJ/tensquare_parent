package Off;

/**
 * Created by lyj on 2019/2/17.
 *
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class Solution10 {

    public void reOrderArray(int [] array) {
        if (array == null)
            return;
        /*int i = 0;
        int j = array.length - 1;
        while (i < j){
            while (i < j && array[i]%2 == 1){
                i++;
            }
            while (i < j && array[j]%2 == 0){
                j--;
            }
            int temp = array[j];
            array[j] = array[i];
            array[i] = temp;
        }*/

        //由于要保证稳定即证奇数和奇数，偶数和偶数之间的相对位置不变 使用插入排序思想
        for (int i = 0; i < array.length; i++) {
            //int temp=array[i];
            if (array[i] % 2 == 1) {
                int temp = array[i];
                int j = i - 1;
                while (j >= 0 && array[j] % 2 == 0) {
                    array[j + 1] = array[j];
                    j--;
                }
                array[j + 1] = temp;
            }
        }
    }
}

package Sort;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2019/4/12 9:59
 *
 * 冒泡排序
 */
public class bubbleSort2 {

    public static void bubbleSort(int[] array){
        if (array == null)
            return;
        int len = array.length;
        //i控制循环的次数，长度为len的数组只需要循环len-1次，i的起始值为0所以i<len-1
        for (int i = 0; i < len-1; i ++){
            //j控制比较的次数，第i次循环内需要比较len-1次
            //但是由于是由array[j]跟array[j+1]比较，所以为了保证array[j+1]不越界，j<len-i-1
            for (int j = 0; j < len-1-i; j++){
                //如果前一个数比后一个数大，则交换位置将大的数往后放
                if (array[j] > array[j+1]){
                    int temp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

}

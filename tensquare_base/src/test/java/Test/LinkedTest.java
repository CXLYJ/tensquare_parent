package Test;


/**
 * 在数组中找出一个数返回下标
 *
 * @author ：lyj
 * @email: ：liyj@nysoftland.com.cn
 * @date ：2020/9/14 10:54
 */
public class LinkedTest {

    public static int find(int[] a, int key){
        if (a == null || a.length <= 0){
            return -1;
        }
        int i = 0;
        while (i < a.length){
            if (a[i] == key){
                return i;
            }
            ++i;
        }
        return -1;
    }

    /**
     * 性能优化
     * 在数组a中查找key，返回key的所在位置
     *
     * @param a
     * @param n
     * @param key
     * @return
     */
    public static int find2(int[] a,int n, int key){
        // 为空直接返回-1
        if (a == null || n <= 0){
            return -1;
        }
        // 这里因为要将a[n-1]的值替换成key，所以要特殊处理这个值
        if (a[n-1] == key){
            return n - 1;
        }
        // 把a[n-1]的值临时保存在变量tmp中，以便之后恢复。tmp=6。
        // 之所以这样做的目的是：希望find2()代码不要改变a数组中的内容
        int temp = a[n-1];
        // 把key的值放到a[n-1]中，此时a = {4, 2, 3, 5, 9, 5}
        a[n-1] = key;
        int i = 0;
        // while 循环比起代码一，少了i
        while (a[i] != key){
            ++i;
        }
        // // 恢复a[n-1]原来的值,此时a= {4, 2, 3, 5, 9, 6}
        a[n-1] = temp;
        if (i == n-1){
            // 如果i == n-1说明，在0...n-2之间都没有key，所以返回-1
            return -1;
        }else {
            // 找到则返回
            return i;
        }
    }

    public static void main(String[] args) {
        int a[] = new int[]{4, 2, 3, 5, 9, 6},n = 6,key = 5;
        System.out.println(find2(a, n, key));
    }

}

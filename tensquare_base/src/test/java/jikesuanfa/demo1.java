package jikesuanfa;

/**
 * TODO
 *
 * @author ：lyj
 * @email: ：liyj@nysoftland.com.cn
 * @date ：2020/8/14 16:19
 */
public class demo1 {

    public static void main(String[] args) {
    }

    /**
     * 时间复杂度为 O(n)
     *
     * @param array
     * @param n
     * @param x
     * @return
     */
    int find(int[] array, int n, int x){
        int i = 0 ;
        int pos = -1;
        for(; i < n; ++i){
            if (array[i] == x) pos = i;
        }
        return pos;
    }

}

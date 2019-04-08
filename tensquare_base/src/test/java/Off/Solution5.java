package Off;

/**
 * Created by lyj on 2019/2/5.
 *
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）,n<=39
 *
 */
public class Solution5 {

    public int Fibonacci(int n){
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        int numfn1 = 0, numfn2 = 1;
        int currentnum = 0;
        for (int i = 2; i <= n; i++){
            currentnum = numfn1 + numfn2;
            numfn1 = numfn2;
            numfn2 = currentnum;
        }
        return currentnum;
    }

}

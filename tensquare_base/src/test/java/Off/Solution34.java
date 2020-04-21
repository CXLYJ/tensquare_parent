package Off;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2020/4/21 23:03
 *
 * 二进制中1的个数
 *
 * 输入一个整数，输出该数二进制表示中1的个数，其中负数用补码表示。
 */
public class Solution34 {

    public int NumberOf(int n){
        int t = 0;
        String str;
        char[]ch=Integer.toBinaryString(n).toCharArray();
        for (int i = 0; i < ch.length; i++){
            if (ch[i] == '1')
                t ++;
        }
        return t;
    }

}

package Off;

/**
 * Created by lyj on 2019/2/15.
 *
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 *
 */
public class Solution8 {

    public static int JumpFloorII(int targer){
        if (targer <= 0){
            return -1;
        } else if (targer == 1){
            return 1;
        } else {
            return 2 * JumpFloorII(targer -1);
        }
    }

    public static void main(String[] args) {
        System.out.println(JumpFloorII(6));
    }

}

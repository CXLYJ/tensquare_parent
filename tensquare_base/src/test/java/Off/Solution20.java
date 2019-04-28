package Off;

import java.util.Arrays;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2019/4/28 16:27
 *
 * 剑指offer-扑克牌顺子
 */
public class Solution20 {

    /**
     * 题目描述
     *
     * LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...
     * 他随机从中抽出了5张牌,想测测自己的手气,看看能不能抽到顺子,如果抽到的话,他决定去买体育彩票,嘿嘿！！
     * “红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是顺子.....LL不高兴了,
     * 他想了想,决定大\小 王可以看成任何数字,并且A看作1,J为11,Q为12,K为13。
     * 上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),“So Lucky!”。LL决定去买体育彩票啦。
     * 现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何， 如果牌能组成顺子就输出true，否则就输出false。
     * 为了方便起见,你可以认为大小王是0。
     */

    /**
     * 思路
     *
     * 先排序，然后统计数字与数字之间的差值，计算差值和；统计数组中出现的0的个数，然后比较差值和与0的个数的大小，
     * 如果0的个数比差值大，那么就说明可以连成顺子，否则不能连成顺子。
     * 当然还得判断里面有没有对子，如果有对子，那么一定不是顺子了！
     */

    public boolean isContinuous(int [] numbers){
        if (numbers.length < 4)
            return false;
        Arrays.sort(numbers);
        int numberZero = 0;
        int numberNeed = 0;
        for (int i = 0; i < numbers.length; i++){
            if (numbers[i] == 0){//统计0出现的个人
                numberZero ++;
            }else {
                if (i < (numbers.length - 1)){
                    if (numbers[i + 1] == numbers[i])
                        return false;//出现对子，那么肯定不是顺子
                        numberNeed += (numbers[i+1] - numbers[i] - 1);//统计数组中数字和数字之间的差值
                }
            }
        }
        if (numberZero >= numberNeed)
            return true; //如果0的个人大于差值，那么可以用0来填充，组成顺子，所以可以连成顺子
        return false;
    }

}

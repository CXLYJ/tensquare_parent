package jikesuanfa;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

/**
 * 双色球计算
 *
 * @author ：lyj
 * @email: ：liyj@nysoftland.com.cn
 * @date ：2020/11/4 15:00
 */
public class Test {

    public static void main(String[] args) {
        //从方法，获得红球号码数组和蓝球号码数组
        int[] red = lottery(33);
        int[] blue = lottery(16);

        //从红球号码数组选择6个，保存得到变量red
        int[] redBall = selectRed(red);
        //从蓝球号码数组选择1个，保存到变量blue
        int blueBall = selectBlue(blue);

        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("现在的时间是："+ sdf.format(now));
        System.out.println("本次红球号码为：" + Arrays.toString(redBall));
        System.out.println("本次蓝球号码为：" + blueBall);
    }

    private static int[] selectRed(int[] r) {

        //保存结果的数组
        int[] red = new int[6];
        //标记数组
        boolean[] flag = new boolean[33];
        //遍历red数组，放入选择的红球号码
        for (int i = 0; i < red.length; i++) {
            //先随机选择一个位置
            //再判断是否要重复再选另一个位置
            int j;
            do {
                j = new Random().nextInt(33);
            }
            while (flag[j]);
            //选择j位置的值，存入结果数组
            red[i] = r[j];
            flag[j] = true;//标记j位置已选过
        }
        return red;


    }

    private static int selectBlue(int[] b) {
        return b[new Random().nextInt(16)];
    }

    private static int[] lottery(int length) {
        /*
         * 1.新建len长度的int[]数组，保存到变量a
         * 2.遍历数组，填入1到length
         * 3.返回数组a
         */
        int[] a = new int[length];
        for (int i = 0; i < a.length; i++) {
            a[i] = i + 1;
        }
        return a;
    }


}

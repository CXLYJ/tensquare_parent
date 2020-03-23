package cycOffer;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2019/12/13
 *
 * 数值的整数次方
 */
public class Offer16 {

    /**
     * 因为 (x*x)的n/2可以通过递归求解，并且每次递归 n 都减小一半，因此整个算法的时间复杂度为 O(logN)。
     * @param base
     * @param exponent
     * @return
     */
    public double Power(double base, int exponent){
        if (exponent == 0)
            return 1;
        if (exponent == 1)
            return base;
        boolean isNegative = false;
        if (exponent < 0)
            exponent = - exponent;
        isNegative = true;

        double pow = Power(base * base, exponent / 2);
        if (exponent % 2 != 0)
            pow = pow * base;
        return isNegative ? 1 / pow : pow;
    }

}

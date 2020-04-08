package Test;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2019/11/22
 */
public class IntergerTest {

    public static void main(String[] args) {
        Integer integer1 = 2;
        Integer integer2 = 3;

        if (integer1 == integer2)
            System.out.println("integer1 == integer2");
        else
            System.out.println("integer1 != integer2");

        Integer integer3 = 129;
        Integer integer4 = 129;

        if (integer3 == integer4)
            System.out.println("integer3 == integer4");
        else
            System.out.println("integer3 != integer4");

        System.out.println(Integer.valueOf("127")==Integer.valueOf("127"));
        System.out.println(Integer.valueOf("128")==Integer.valueOf("128"));
        System.out.println(Integer.parseInt("128")==Integer.valueOf("128"));

        Integer integer5 = new Integer(3);
        Integer integer6 = new Integer(3);
        if (integer5 == integer6)
            System.out.println("integer5 == integer6");
        else
            System.out.println("integer5 != integer6");
    }
}

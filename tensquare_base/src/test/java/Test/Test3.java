package Test;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2019/6/24 11:11
 *
 * 异常处理
 */
public class Test3 {

    public static int aMethod(int i) throws Exception{
        try {
            return 10/i;
        }catch (Exception ex){
            throw new Exception("exception in aMethod");
        }finally {
            System.out.println("finally");
        }
    }

    public static void main(String[] args) {
        try {
            aMethod(0);
        }catch (Exception ex){
            System.out.println("exception in main");
        }
        System.out.printf("finished");
    }

}

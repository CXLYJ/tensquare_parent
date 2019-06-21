package Test;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2019/5/14 15:57
 */
public class Test {

    public static void main(String[] args) {
        System.out.println(flag());
    }

    private static boolean flag(){
        try {
            return true;
        }catch (Exception e){
                e.printStackTrace();
        }finally {
            return false;
        }
    }

}

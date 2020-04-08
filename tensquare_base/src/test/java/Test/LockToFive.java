package Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2019/12/25
 */
public class LockToFive {

    public static void main(String[] args) {
        int lockCount = 0;
        String password = "123";
        for (int i = 0; i < 8; i++){
            if (!"1234".equals(password))
                System.out.println("密码错误！" + lockCount);
                lockCount ++;
            if (lockCount > 5) {
                System.out.println("账户已被锁住！" + lockCount);
                return; 
            }
        }
    }

}

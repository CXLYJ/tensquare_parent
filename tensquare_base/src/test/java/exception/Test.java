package exception;

import lombok.extern.slf4j.Slf4j;
import sun.rmi.runtime.Log;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2020/4/8
 *
 * 异常捕获
 */
@Slf4j
public class Test {

    public static void main(String[] args) {
        try {
            log.info("try is run");
            if (true){
                throw new RuntimeException("try exception");
            }
        }catch (Exception e){
            log.info("catch is run");
            if (true){
                throw new RuntimeException("catch exception");
            }
        }finally {
            log.info("finally is run");
        }
    }

}

package util.encry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.encry.digest.MD5Strategy;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2019/6/24 16:38
 *
 * 获取加密策略工厂类
 */
public final class EncryptStrategyFactory {

    private static Logger logger = LoggerFactory.getLogger(EncryptStrategyFactory.class);

    /**
     * 目前所支持的加密策略
     */
    public static final String MD5 = "MD5";
    public static final String SHA = "SHA";
    public static final String AES = "AES";
    public static final String DES = "DES";
    public static final String XHW_DES = "XHWDES";
    public static final String TRIPLE_DES = "TRIPLEDES";
    public static final String BASE64 = "BASE64";

    public static IStrategy makeIStrategy(String type) {
        IStrategy encryptStrategy = null;
        switch (type) {
            case MD5:
                encryptStrategy = new MD5Strategy();
                break;
            /*case AES:
                encryptStrategy = new AESStrategy();
                break;
            case DES:
                encryptStrategy = new DESStrategy();
                break;
            case XHW_DES:
                encryptStrategy = new XHWDESStrategy();
                break;
            case TRIPLE_DES:
                encryptStrategy = new TripleDESStrategy();
                break;*/
            case BASE64:
                encryptStrategy = new Base64Strategy();
                break;
            default:
                logger.error(type + "类型的加密策略无法生产");
                break;
        }
        return encryptStrategy;
    }

}

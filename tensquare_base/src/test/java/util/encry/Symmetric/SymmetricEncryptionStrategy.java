package util.encry.Symmetric;

import util.encry.IStrategy;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2019/6/24 17:25
 *
 * 对称加密算法积累
 */
public abstract class SymmetricEncryptionStrategy implements IStrategy {

    protected static final String DEFAULT_ENCODE_RULES = "ABC";


    /**
     * 获取密钥
     *
     * @param algorithm
     *            算法
     * @param initSize
     *            密钥生成器大小
     * @param encodeRules
     *            加密规则
     * @return 密钥
     * @throws NoSuchAlgorithmException
     */
    public byte[] initKey(String algorithm, int initSize,String encodeRules){
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance(algorithm);
            // 根据ecnodeRules规则初始化密钥生成器
            // 生成一个128位的随机源,根据传入的字节数组
            keyGenerator.init(initSize,
                    new SecureRandom(encodeRules.getBytes()));
            SecretKey secretKey = keyGenerator.generateKey();
            return secretKey.getEncoded();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public abstract String encode(String str);

    public abstract String encode(String str, String encodeRules);

    @Override
    public abstract String decode(String str);

    public abstract String decode(String src, String encodeRules);
}

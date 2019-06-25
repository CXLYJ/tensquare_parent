package util.encry.Symmetric;

import org.apache.commons.codec.binary.Hex;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2019/6/24 17:25
 */
public class AESStrategy extends SymmetricEncryptionStrategy{
    @Override
    public String encode(String str) {
        return encode(str,DEFAULT_ENCODE_RULES);
    }

    @Override
    public String encode(String str, String encodeRules) {
        byte[] key = initKey("AES", 128, encodeRules);
        SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
        try {
            // Cipher完成加密或解密工作
            Cipher cipher = Cipher.getInstance("AES");
            // 根据密钥对Cipher进行初始化 ENCRYPT_MODE, DECRYPT_MODE
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            // 加密
            byte[] resultBytes = cipher.doFinal(str.getBytes("UTF-8"));
            return Hex.encodeHexString(resultBytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String decode(String str) {
        return decode(str, DEFAULT_ENCODE_RULES);
    }

    @Override
    public String decode(String src, String encodeRules) {
        byte[] key = initKey("AES", 128, encodeRules);
        SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
        try {
            // Cipher完成加密或解密工作
            Cipher cipher = Cipher.getInstance("AES");
            // 根据密钥对Cipher进行初始化 ENCRYPT_MODE, DECRYPT_MODE
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] srcBytes = Hex.decodeHex(src.toCharArray());
            // 解密
            return new String(cipher.doFinal(srcBytes), "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

package util.encry.Symmetric;

import util.Base64Util;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2019/6/25 10:03
 * DES加密策略
 */
public class DESStrategy extends SymmetricEncryptionStrategy{
    @Override
    public String encode(String str) {
        return encode(str,DEFAULT_ENCODE_RULES);
    }

    @Override
    public String encode(String str, String encodeRules) {
        try {
            DESKeySpec dks = new DESKeySpec(encodeRules.getBytes());
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            Key secretKey = keyFactory.generateSecret(dks);
            Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
            IvParameterSpec iv = new IvParameterSpec(encodeRules.getBytes());// 向量
            AlgorithmParameterSpec paramSpec = iv;
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, paramSpec);
            byte[] bytes = cipher.doFinal(str.getBytes("utf-8"));
            return Base64Util.encode(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String decode(String str) {
        return decode(str,DEFAULT_ENCODE_RULES);
    }

    @Override
    public String decode(String src, String encodeRules) {
        try {
            DESKeySpec dks = new DESKeySpec(encodeRules.getBytes());
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            Key secretKey = keyFactory.generateSecret(dks);
            Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
            IvParameterSpec iv = new IvParameterSpec(encodeRules.getBytes());
            AlgorithmParameterSpec paramSpec = iv;
            cipher.init(Cipher.DECRYPT_MODE, secretKey, paramSpec);
            byte[] srcByte = Base64Util.decode(src);
            byte[] resultBytes = cipher.doFinal(srcByte);
            return new String(resultBytes, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        SymmetricEncryptionStrategy strategy = new DESStrategy();
        String src = "谭伍波";
        System.out.println(src);
        src = strategy.encode(src,"aaa");
        System.out.println(src);
        src = strategy.decode(src,"aaa");
        System.out.println(src);
    }
}

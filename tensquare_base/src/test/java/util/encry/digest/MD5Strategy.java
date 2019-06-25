package util.encry.digest;

import util.encry.IStrategy;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2019/6/24 16:50
 */
public class MD5Strategy extends MessageDigestStrategy {

    @Override
    public String encode(String str) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            try {
                byte[] encodeBytes = md.digest(str.getBytes("UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        IStrategy strategy = new MD5Strategy();
        String str = "李依金";
        System.out.println(str);
        str = strategy.decode(str);
        System.out.println(str);
    }
}

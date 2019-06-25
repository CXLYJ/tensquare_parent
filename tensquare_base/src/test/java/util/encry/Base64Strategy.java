package util.encry;

import util.Base64Util;

import java.io.UnsupportedEncodingException;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2019/6/24 15:40
 */
public class Base64Strategy implements IStrategy{
    @Override
    public String encode(String str) {
        try {
            return Base64Util.encode(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String decode(String str) {
        try {
            byte[] decodeBytes = Base64Util.decode(str);
            return new String(decodeBytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        IStrategy strategy = new Base64Strategy();
        String str = "李依金";
        System.out.println(str);
        str = strategy.encode(str);
        System.out.println(str);
        str = strategy.decode(str);
        System.out.println(str);
    }
}

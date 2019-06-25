package util.encry.digest;

import util.encry.IStrategy;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2019/6/24 16:53
 * 消息摘要算法加密基类
 */
public abstract class MessageDigestStrategy implements IStrategy {

    public abstract String encode(String str);

    @Override
    public String decode(String str) {
        throw new RuntimeException("Message Digest no decode");
    }
}

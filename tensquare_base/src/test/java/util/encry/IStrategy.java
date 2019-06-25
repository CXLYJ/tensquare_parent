package util.encry;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2019/6/24 15:37
 * 加密工具类策略接口
 */
public interface IStrategy {

    String encode(String str);

    String decode(String str);

}

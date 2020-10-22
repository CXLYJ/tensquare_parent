package money;

/**
 * 状态枚举
 *
 * @author ：lyj
 * @email: ：liyj@nysoftland.com.cn
 * @date ：2020/10/22 16:06
 */
public enum  StateEnum {

    //待付款
    NOT_PAY(1, "待付款"),

    //已付款
    PAID(2, "已付款"),

    //已完结
    FEED_BACKED(3, "已完结");

    private int key;
    private String value;

    StateEnum(int key, String value) {
        this.key = key;
        this.value = value;
    }
    public String getValue() {
        return value;
    }

}

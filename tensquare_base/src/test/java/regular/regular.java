package regular;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2019/6/5 10:45
 */
public class regular {

    public static void main(String[] args) {
//        System.out.println(idCard("17918316800"));
        System.out.println(name("李金$"));
    }


    /**
     * 姓名校验规则（仅针对客户类型为个人的投保人和被保险人）
     1：姓名字段长度不得小于2个字符
     2：首位或末位不得为空格
     3：姓名中不得含有数字
     4：姓名中不得含有2个特殊字符"-"和"_"

     判断是否中文姓名（长度为2-22位）
     *
     * 只允许汉字和英文字母： ^[A-Za-z\u4e00-\u9fa5]{2,8}$
     *
     * 只允许汉字： ^[\u4e00-\u9fa5]{2,8}$

     * @param str
     * @return
     */
    public static boolean name(String str){
        String regular = "^[\\u4e00-\\u9fa5]{2,8}$";
        return quickValidate(regular, str);
    }

    /**
     * 手机号码校验规则（手机号如果为空，则必须满足以下规则）
     1：首位数组必须为1
     2：字段取值长度为11数字
     3：只能以“13”“14”“15”“16”“17”“18”“19”开头
     * @param str
     * @return
     */
    public static boolean idCard(String str){
//        String regular = "0?(13|14|15|17|18|19)[0-9]{9}";
        String regular = "^1[3|4|5|7|8|9][0-9]\\d{4,8}$";
        return quickValidate(regular, str);
    }

    /**
     * 验证正则
     * @param express
     * @param value
     * @return
     */
    public static boolean quickValidate(String express, String value){
        Pattern pattern = Pattern.compile(express);
        Matcher matcher = pattern.matcher(value);
        boolean flag = matcher.matches();
        return flag;
    }

}

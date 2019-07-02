package util.encry;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2019/6/25 14:38
 */
public class SnCal {

    public static void main(String[] args) {
        Map<String,String> paramsMap = new TreeMap<>();
        paramsMap.put("apiId", "161");
        paramsMap.put("name", "张三");
        paramsMap.put("certNo", "411081199004235955");
        paramsMap.put("clinicDate", "2016-11-05");
        paramsMap.put("ak", "test01");
        paramsMap.put("sk", "e430e034ed614322a07999ef01a6f244");
    }

}

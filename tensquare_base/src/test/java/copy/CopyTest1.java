package copy;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2019/7/4 15:54
 */
@Data
@ToString
public class CopyTest1 {

    public String otherName;
    public CopyTest1.InnerClass innerClass;
    public List<CopyTest1.InnerClass> clazz;

    @ToString
    @Data
    public static class InnerClass{
        public String InnerName;
    }

}

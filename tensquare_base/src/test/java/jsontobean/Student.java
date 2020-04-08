package jsontobean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2019/11/26
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student {

    private String stuNo;

    private String stuName;
    
}

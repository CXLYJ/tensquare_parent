package jsontobean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2019/11/26
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {

    private String teaId;

    private String teaName;

    private List<Student> stus;

}

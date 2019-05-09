package json.entity;

import lombok.Data;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2019/5/9 10:58
 */
@Data
public class Student {

    private String name;
    private String age;
    private String address;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

package json.base;

import json.entity.Student;
import org.json.JSONObject;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2019/5/9 11:00
 */
public class convertObject {

    public static void main(String[] args) {
        Student student = new Student();
        student.setName("json");
        student.setAge("23");
        student.setAddress("上海闵行");
        //使用JSONObject(Object bean)构造方法
//        System.out.println(new JSONObject(student));
    }

}

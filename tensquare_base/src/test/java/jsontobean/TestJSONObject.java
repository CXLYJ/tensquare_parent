package jsontobean;

import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2019/11/26
 */
public class TestJSONObject {

//    public static void main(String[] args) {
//        Student student_1 = new Student("学号1", "学生1");
//        List<Student> stus = new ArrayList<Student>();
//        stus.add(student_1);
//        Teacher teacher_1 = new Teacher("编号1", "教师1", stus);
//        JSONObject obj = JSONObject.fromObject(teacher_1);
//        System.out.println("JSON格式的Teacher->" + obj.toString());
//        Teacher teacherBean = (Teacher) JSONObject.toBean(obj, Teacher.class);
//        try {
//            Student studentBean = teacherBean.getStus().get(0);
//            System.out.println(studentBean);
//        } catch (Exception e) {
//            System.out.println("出现异常");
//            e.printStackTrace();
//        }
//    }

    public static void main(String[] args) {
        Student student = new Student("学号1","学生1");
        List<Student> stus = new ArrayList<Student>();
        stus.add(student);
        Teacher teacher = new Teacher("编号1","教师1",stus);
        JSONObject object = JSONObject.fromObject(teacher);
        System.out.println("JSON格式的Teacher->" + object.toString());

        //定义一个Map
        Map<String, Class<Student>> map = new HashMap<String, Class<Student>>();
        map.put("stus", Student.class); //key为teacher私有变量的属性名
        // 使用JSONObject.toBean(jsonObject, beanClass, classMap)
        Teacher teacherBean = (Teacher) JSONObject.toBean(object, Teacher.class, map);
        try {
            Student studentBean = teacherBean.getStus().get(0);
            System.out.println(studentBean);
        } catch (Exception e) {
            System.out.println("出现异常");
            e.printStackTrace();
        }
    }

}

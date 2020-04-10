package Thread;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2020/4/10
 */
public class WrongInit {

    private Map<Integer, String> students;

    public WrongInit(){
        new Thread(new Runnable() {
            @Override
            public void run() {
              students = new HashMap<>();
              students.put(1, "王小美");
              students.put(2, "钱二宝");
              students.put(3, "周三");
              students.put(4, "赵四");
            }
        }).start();
    }

    public Map<Integer, String> getStudents(){
        return students;
    }

    public static void main(String[] args) {
        WrongInit wrongInit = new WrongInit();
        System.out.println(wrongInit.getStudents().get(1));
    }

}

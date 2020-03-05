package Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2020/3/1 10:37
 */
public class ArrayTest {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        List<Integer> subList = list.subList(0,1);

        //强转
        ArrayList<Integer> cast = (ArrayList<Integer>) subList;
    }

}

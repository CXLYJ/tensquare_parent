package util;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2020/1/9
 */
public class ListTest {

    public static void main(String[] args) {

        ArrayList<String> arrayList = new ArrayList<>();
        LinkedList<String> linkedList = new LinkedList<>();
        Long start1 =  System.currentTimeMillis();
       for (int i = 1 ; i <= 150000; i++){
           arrayList.add("iclyj");
       }
        Long end1 = System.currentTimeMillis();
        System.out.println(end1 - start1);
        Long start2 =  System.currentTimeMillis();
        for (int i = 1 ; i <= 150000; i++){
            linkedList.add("iclyj");
        }
        Long end2 = System.currentTimeMillis();
        System.out.println(end2 - start2);

    }

}

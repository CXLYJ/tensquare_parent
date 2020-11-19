package jikesuanfa;

import io.swagger.models.auth.In;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;

/**
 * 批量新增的优势
 *
 * @author ：lyj
 * @email: ：liyj@nysoftland.com.cn
 * @date ：2020/11/6 11:28
 */
@Slf4j
public class Test1 {

    public static void main(String[] args) {
        // 准备数据
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 3000000; i++){
            list.add(i);
        }

        // for + add
        ArrayList<Integer> list1 = new ArrayList<>();
        long start1 = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++){
            list1.add(list.get(i));
        }

        log.info("单个 for 循环新增 100 w 个，耗时{}",System.currentTimeMillis()-start1);

        // 批量新增
        ArrayList<Integer> list2 = new ArrayList<>();
        long start2 = System.currentTimeMillis();
        list2.addAll(list);
        log.info("批量新增 100 w 个，耗时{}",System.currentTimeMillis()-start2);
    }

}

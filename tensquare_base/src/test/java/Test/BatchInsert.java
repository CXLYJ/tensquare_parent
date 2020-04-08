package Test;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2020/2/21 19:18
 */
@Slf4j
public class BatchInsert {

    public static void main(String[] args) {
        // 准备拷贝数据
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<3000000;i++){
            list.add(i);
        }

        // for 循环 + add
        ArrayList<Integer> list2 = new ArrayList<>();
        long start1 = System.currentTimeMillis();
        for(int i=0;i<list.size();i++){
            list2.add(list.get(i));
        }
        log.info("单个 for 循环新增 300 w 个，耗时{}",System.currentTimeMillis()-start1);


        // 批量新增
        ArrayList<Integer> list3 = new ArrayList<>();
        long start2 = System.currentTimeMillis();
        list3.addAll(list);
        log.info("批量新增 300 w 个，耗时{}",System.currentTimeMillis()-start2);

    }

}

package map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2019/7/5 17:38
 *
 * linkedHashMap的扩容用法
 */
public class LinkedHashMapTest {

    private static final Logger logger = LoggerFactory.getLogger(LinkedHashMapTest.class);

    public static void main(String[] args) {

        int initialCapacity = 10; //初始化容量
        float loadFactor = 0.75f; // 加载因子，一般是0.75
        boolean accessOrder = true; //排序呢方式 false 基于插入排序 true 基于顺序访问
        Map<String, Integer> map = new LinkedHashMap<>(initialCapacity,loadFactor,accessOrder);

        for (int i = 0; i < 10; i++){
            map.put(String.valueOf(i), i);
        }
        //访问前数据
        for (Iterator<Map.Entry<String,Integer>> it = map.entrySet().iterator(); it.hasNext();){
            Map.Entry<String, Integer> next = it.next();
            logger.info("linkedMap--before-->" + next.getKey());
        }

        //模拟访问
        map.get("5");

        //访问后数据
        for (Iterator<Map.Entry<String, Integer>> it = map.entrySet().iterator(); it.hasNext(); ) {
            Map.Entry<String, Integer> next = it.next();
            logger.info("linkedMap--after-->" + next.getKey());
        }


        Map<String, Integer> lruLinkedHashMap = new LinkedHashMap(initialCapacity, loadFactor, accessOrder) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > initialCapacity;
            }
        };

        for (int i = 0; i < 15; i++) {
            lruLinkedHashMap.put(String.valueOf(i), i);
        }
        //访问前顺序
        for (Iterator<Map.Entry<String, Integer>> it = lruLinkedHashMap.entrySet().iterator(); it.hasNext(); ) {
            Map.Entry<String, Integer> next = it.next();
           logger.info("lruLinkedHashMap--after-->" + next.getKey());
        }

    }

}

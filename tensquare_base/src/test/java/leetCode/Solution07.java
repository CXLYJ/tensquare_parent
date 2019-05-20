package leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2019/5/20 10:17
 *
 * LeetCode-按照字符出现次数对字符串排序
 */
public class Solution07 {

    /**
     * 题目描述
     * Input:
     "tree"

     Output:
     "eert"

     Explanation:
     'e' appears twice while 'r' and 't' both appear once.
     So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
     *
     * 说明:“e”出现两次，“r”和“t”都出现一次。所以e必须同时出现在r和t之前。因此“eetr”也是一个有效的答案
     */

    public String frequencySort(String s){
        Map<Character,Integer> frequencyForNum = new HashMap<>();
        for (char c : s.toCharArray()){
            //getOrDefault返回指定键所映射的值，或defaultVaule如果此映射包含该键的映射
            frequencyForNum.put(c, frequencyForNum.getOrDefault(c,0) + 1);
        }

        List<Character>[] frequencyBucket = new ArrayList[s.length() + 1];

        for (char c : frequencyForNum.keySet()){
            int f = frequencyForNum.get(c);
            if (frequencyBucket[f] == null){
                frequencyBucket[f] = new ArrayList<>();
            }
            frequencyBucket[f].add(c);
        }
        StringBuilder str = new StringBuilder();
        for (int i = frequencyBucket.length - 1; i >= 0; i--){
            if (frequencyBucket[i] == null){
                continue;
            }
            for (char c : frequencyBucket[i]){
                for (int j = 0; j < i; j++){
                    str.append(c);
                }
            }
        }
        return str.toString();
    }

}

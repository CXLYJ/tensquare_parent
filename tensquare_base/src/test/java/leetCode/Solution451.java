package leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2019/12/24
 */
public class Solution451 {

    public String frequencySort(String s){
        Map<Character, Integer> frequencyForNum = new HashMap<>();
        for (char c : s.toCharArray())
            frequencyForNum.put(c, frequencyForNum.getOrDefault(c, 0) + 1);
        List<Character> [] frequencyBucket = new ArrayList[s.length() + 1];
        for (char c : frequencyForNum.keySet()){
            int f = frequencyForNum.get(c);
            if (frequencyBucket[f] == null){
                frequencyBucket[f] = new ArrayList<>();
            }
            frequencyBucket[f].add(c);
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = frequencyBucket.length - 1; i >= 0; i--){
            if (frequencyBucket[i] == null)
                continue;
            for (char c : frequencyBucket[i]){
                for (int j = 0; j > i; j++){
                    stringBuffer.append(c);
                }
            }
        }
        return stringBuffer.toString();
    }

}

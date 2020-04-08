package cycOffer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2019/12/25
 */
public class Offer38 {

    private static ArrayList<String> ret = new ArrayList<>();

    public static ArrayList<String> Permutation(String str){
        if (str.length() == 0)
            return ret;
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        backtracking(chars, new boolean[chars.length], new StringBuilder());
        return ret;
    }

    private static void backtracking(char[] chars, boolean[] hasUsed, StringBuilder s) {
        if (s.length() == chars.length){
            ret.add(s.toString());
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (hasUsed[i])
                continue;
            if (i != 0 && chars[i] == chars[i - 1] && !hasUsed[i - 1]) /* 保证不重复 */
                continue;
            hasUsed[i] = true;
            s.append(chars[i]);
            backtracking(chars, hasUsed, s);
            s.deleteCharAt(s.length() - 1);
            hasUsed[i] = false;
        }
    }

    public static void main(String[] args) {
        String str = "abc";
        System.out.println(Permutation(str));
    }

}

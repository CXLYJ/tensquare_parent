package Off;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2019/4/29 10:25
 *
 * 剑指offer-翻转单词顺序列
 */
public class Solution21 {

    /**
     * 题目描述
     *
     *牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
     * 同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
     * 例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，
     * 正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
     */

    /**
     * 思路
     *
     * 先反转整个字符串，“student. a am I”反转完就是“I ma a .tneduts”,
     * 然后依据空格分割字符串以后，再继续反转每一个单词，最后就是最终的结果
     */

    public String ReverseSentence(String str){
        if (str == null || str == "")
            return str;
        char [] strArray = str.toCharArray(); //将此字符串转换为新的字符数组
        reverse(strArray,0,strArray.length - 1); //反转整个字符串
        int begin = 0;
        for (int i = 0; i < strArray.length; i++){
            if (strArray[i] == ' '){
                reverse(strArray,begin,i-1);
                begin = i + 1; //每当遇到空格，就是一个单词，然后反转这个单词
            }
        }
        if (begin < strArray.length - 1 ){
            reverse(strArray,begin,strArray.length - 1);//反转最后一个单词
        }
        return String.valueOf(strArray);
    }

    private void reverse(char[] str, int begin, int end) {
        //反转字符数组
        while (begin < end){
            char temp = str[begin];
            str[begin] = str[end];
            str[end] = temp;
            begin ++;
            end --;
        }
    }
}

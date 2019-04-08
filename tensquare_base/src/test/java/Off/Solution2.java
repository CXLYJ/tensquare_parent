package Off;

/**
 * Created by lyj on 2019/1/30.
 *
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 *
 */
public class Solution2 {

    public  static String replaceSpace(StringBuffer str){
        if (str == null){
            return null;
        }

//        StringBuffer newSrt = new StringBuffer();
//        for (int i= 0; i<str.length(); i++){
//            if (str.charAt(i) == ' '){
//                newSrt.append("%");
//                newSrt.append("2");
//                newSrt.append("0");
//            }else {
//                newSrt.append(str.charAt(i));
//            }
//        }
//        return newSrt.toString();

        StringBuffer st = new StringBuffer();
        for (int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if (String.valueOf(c).equals(" ")){
                st.append("%20");
            }else{
                st.append(c);
            }
        }
        return st.toString();
    }

    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("We");
        stringBuffer.append(" are");
        stringBuffer.append(" happy");
        System.out.println(replaceSpace(stringBuffer));
    }

}

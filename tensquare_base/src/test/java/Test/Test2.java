package Test;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2019/6/21 10:36
 *
 * i++ 的用法解析
 */
public class Test2 {

    /**
     *   该题主要考察的是static属性和i++操作。
         因为i是static的，是类属性，所以不管有多少对象，都共用的一个变量。
         这里getNext()方法被调用了三次，所以进行了三次i++操作。
         但是由于getNext()操作的返回是：return i++; i++是先返回，后++，所以在println是，
         已经返回了i(此时i为3)，再进行自增的，所以这里结果为3

         return i++ 比较特殊，先是return i；然后i++。
         return i=i+ 1 则不同，它是先让i=i+1，再return。
     */

    private static int i = 1;
    public int getNext(){
        return i++;
    }

    public static void main(String[] args) {
       Test2 test = new Test2();
       Test2 testObject = new Test2();
       test.getNext();
       testObject.getNext();
        System.out.println(testObject.getNext());
    }

}

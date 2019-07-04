package copy;

import org.springframework.beans.BeanUtils;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2019/7/4 15:57
 */
public class CopyTest {

    public static void main(String[] args) {

        /**
         * https://www.jianshu.com/p/357b55852efc
         *
         * 1.Spring的BeanUtils的CopyProperties方法需要对应的属性有getter和setter方法；
         2.如果存在属性完全相同的内部类，但是不是同一个内部类，即分别属于各自的内部类，则spring会认为属性不同，不会copy；
         3.泛型只在编译期起作用，不能依靠泛型来做运行期的限制；
         4.最后，spring和apache的copy属性的方法源和目的参数的位置正好相反，所以导包和调用的时候都要注意一下。
         */
//        CopyTest1 test1 = new CopyTest1();
//        test1.otherName = "hahaha";
//        CopyTest1.InnerClass innerClass = new CopyTest1.InnerClass();
//        innerClass.InnerName = "hehehe";
//        test1.innerClass = innerClass;
//
//        System.out.println(test1.toString());
//
//        CopyTest2 test2 = new CopyTest2();
//        BeanUtils.copyProperties(test1, test2);
//        System.out.println(test1.toString());



        CopyTest1 test1 = new CopyTest1();
        test1.otherName = "hahaha";
        CopyTest1.InnerClass innerClass = new CopyTest1.InnerClass();
        innerClass.InnerName = "hehehe";
        test1.innerClass = innerClass;

        System.out.println(test1.toString());

        CopyTest2 test2 = new CopyTest2();
        test2.innerClass = new CopyTest2.InnerClass();
        BeanUtils.copyProperties(test1, test2);
        BeanUtils.copyProperties(test1.innerClass,test2.innerClass);

        System.out.println(test1.toString());
    }

}

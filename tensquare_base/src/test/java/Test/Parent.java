package Test;

/**
 * Created by Administrator on 2019/8/13.
 */
public class Parent {


    /**
     * 子类的静态变量和静态初始化块是在父类的变量、初始化块和构造函数初始化之前就完成了。静态变量、静态初始化块、
     * 变量、初始化块初始化的顺序取决于他们在类中出现的先后顺序
     */

     /* 静态变量 */
      public static String p_StaticField = "父类--静态变量";
           /* 变量 */
      public String    p_Field = "父类--变量";
      protected int    i    = 9;
      protected int    j    = 0;

      static {
          System.out.println( p_StaticField );
          System.out.println( "父类--静态初始化块" );
      }

        /* 初始化块 */
     {
         System.out.println( p_Field );
         System.out.println( "父类--初始化块" );
     }
     
     /* 构造器 */
     public Parent()
     {
         System.out.println( "父类--构造器" );
         System.out.println( "i=" + i + ", j=" + j );
         j = 20;
     }

}

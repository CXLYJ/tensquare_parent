package basics;

import java.io.File;
import java.io.FileInputStream;

/**
 * Created by lyj on 2019/1/29.
 */
public class Demo1 {

    public static void main(String[] args) throws Exception{



        //面试题:read()方法读取的是一个字节,为什么返回是int,而不是byte ？
        //如果使用FileInputStream读取图片数据
        /**
         * 00010111 00010111 00010111 00010111
         * 00010111 11111111 00010111 00010111
         *
         * byte:11111111 表示的-1
         * int:00000000 00000000 00000000 11111111  byte转成int 补0 了不是-1   因此往后读数据
         *
         * 为什么11111111是表示-1？
         * 因为计算机是以补码的方式计算
         * 补码： 11111111 （-1）
         * 反码： 11111110
         * 原码:  10000001
         *
         * 因为字节输入流可以操作任意类型的文件,比如图片音频等,
         * 这些文件底层都是以二进制形式的存储的,如果每次读取都返回byte,
         * 有可能在读到中间的时候遇到111111111 那么这11111111是byte类型的-1,我们的程序是遇到-1就会停止不读了,
         * 后面的数据就读不到了,所以在读取的时候用int类型接收,如果11111111会在其前面补上 24个0凑足4个字节,
         * 那么byte类型的-1就变成int类型的255了这样可以保证整个数据读完,而结束标记的-1就是int类型
         *
         *
         * 假如使用FileInputStream读取图片的时候，
         * 图片中间有一段数据刚好是 11111111，这八个一表示的-1，用byte接收
         * java程序如果读取的是-1，后面的数据就不读取
         * 如果把8个1转成int,那就是00000000 00000000 00000000 11111111,这个表示255，
         * 就不是-1，归避后面数据没有读取问题
         *
         */


        //案例：读取txt文件内容
        //1.创建一个文件对象
//        File file = new File("D:\\ideaWorkpaces\\a.txt");
//
//        //2.创建一个文件输入流【读取文件数据】对象
//        FileInputStream fileInputStream1 = new FileInputStream(file);
//
//        //再创建一个文件输入 流对象
//        FileInputStream fileInputStream2 = new FileInputStream("D:\\ideaWorkpaces\\b.txt");
//
//        //3.读取a.txt的数据
//        /**
//         * 1.read方法每次读取一个字节（byte），把byte转成int返回
//         * 2.当读到后的时候，返回-1，-1读取文件结束
//         */
//        System.out.println(fileInputStream1.read());
//        System.out.println(fileInputStream1.read());
//        System.out.println(fileInputStream2.read());
//        System.out.println(fileInputStream2.read());
//
//        fileInputStream1.close();
//        fileInputStream2.close();

        //1.创建一个文件对象
        File file = new File("D:\\ideaWorkpaces\\a.txt");
        System.out.println(file.getAbsolutePath());

        //2.创建一个文件输入流
        FileInputStream inputStream = new FileInputStream(file);

        int b;
        //while循环里，每次读取字节赋值给b
        while ((b = inputStream.read()) != -1){
            System.out.println(b);
        }


    }

}

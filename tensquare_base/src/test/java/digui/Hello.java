package digui;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2020/7/13 22:09
 */
public class Hello {

    public static void main(String []args) {
         List<Menu> menuList= new ArrayList<Menu>();
         /*插入一些数据*/
         menuList.add(new Menu("GN001D000","0","系统管理","/admin","Y"));
         menuList.add(new Menu("GN001D100","GN001D000","权限管理","/admin","Y"));
         menuList.add(new Menu("GN001D110","GN001D100","密码修改","/admin","Y"));
         menuList.add(new Menu("GN001D120","GN001D100","新加用户","/admin","Y"));
         menuList.add(new Menu("GN001D200","GN001D000","系统监控","/admin","Y"));
         menuList.add(new Menu("GN001D210","GN001D200","在线用户","/admin","Y"));
         menuList.add(new Menu("GN002D000","0","订阅区","/admin","Y"));
         menuList.add(new Menu("GN003D000","0","未知领域","/admin","Y"));
         /*让我们创建树*/
         MenuTree menuTree =new MenuTree(menuList);
         menuList=menuTree.buildTree();
         /*转为json看看效果*/
         String jsonOutput= JSON.toJSONString(menuList);
         System.out.println(jsonOutput);
     }

}

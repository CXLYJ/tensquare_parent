package digui;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2020/7/13 21:55
 *
 * 递归菜单
 */
public class MenuTree {

    private List<Menu> menuList = new ArrayList<>();

    public MenuTree(List<Menu> menuList){
        this.menuList = menuList;
    }

    public List<Menu> buildTree(){
        List<Menu> treeMenus = new ArrayList<>();
        for (Menu menuNode : getRootNode()){
            menuNode = buildChildTree(menuNode);
            treeMenus.add(menuNode);
        }
        return treeMenus;
    }

    /**
     * 递归，建立子树结构
     *
     * @param menuNode
     * @return
     */
    private Menu buildChildTree(Menu menuNode) {
        List<Menu> childMenu = new ArrayList<>();
        menuList.forEach(menu -> {
            if (menu.getParentId().equals(menuNode.getId())){
                childMenu.add(buildChildTree(menu));
            }
        });
        menuNode.setChildren(childMenu);
        return menuNode;
    }

    /**
     * 获取根节点
     *
     * @return
     */
    private List<Menu> getRootNode() {
        List<Menu> rootMenuList = new ArrayList<>();
        menuList.forEach(menu -> {
            if (menu.getParentId().equals("0")){
                rootMenuList.add(menu);
            }
        });
        return rootMenuList;
    }

}

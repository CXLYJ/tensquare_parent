package digui;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2020/7/13 21:46
 *
 * 菜单参数
 */
@Data
public class Menu {

    private String id;
    private String parentId;
    private String text;
    private String url;
    private String yxbz;
    private List<Menu> children;

    public Menu(String id,String parentId,String text,String url,String yxbz) {
                 this.id=id;
                 this.parentId=parentId;
                 this.text=text;
                 this.url=url;
                 this.yxbz=yxbz;
             }

}

package tensquare.rabbit.Controller;

import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tensquare.rabbit.server.CheckCodeService;
import tensquare.rabbit.server.RabbitServer;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2019/5/9 16:24
 */
@RestController
public class SendMailController {

    @Autowired
    private RabbitServer rabbitServer;

    @Autowired
    private CheckCodeService checkCodeService;

    /**
     * 发送验证码
     * @param mail
     * @return
     */
    @RequestMapping(value = "/sendMail/{mail}")
    public Result sendMail(@PathVariable String mail){
        rabbitServer.snedMail(mail);
        return new Result(true, StatusCode.OK,"发送成功");
    }

    /**
     * 验证短信
     * @param code
     * @param mail
     * @return
     */
    @RequestMapping(value = "/checkCode")
    public Result checkCode(@RequestParam("code") String code, @RequestParam("mail") String mail){
        return checkCodeService.checkCode(code,mail);
    }

}

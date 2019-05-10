package tensquare.rabbit.server;

import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2019/5/9 16:33
 */
@Service
public class CheckCodeService {

    @Autowired
    private RedisTemplate redisTemplate;

    public Result checkCode(String code,String mail){
        //判断验证码是否正确
        String syscode = (String) redisTemplate.opsForValue().get("mailcode_" + mail);
        //提取redis的中的验证码
        if (syscode == null){
            return new Result(true, StatusCode.ERROR,"未发送验证码或验证码已过期");
        }
        if (!syscode.equals(code)){
            return new Result(true, StatusCode.ERROR,"验证码错误");
        }
        return new Result(true, StatusCode.OK,"验证码验证通过");
    }


}

package tensquare.rabbit.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by lyj on 2019/1/22.
 * 推送队列
 */
@Component
public class RabbitServer {

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitServer.class);

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 发送6位验证码
     */
    public void snedMail(String mail){
        //1.生成6位验证码
        Random random = new Random();
        int max = 999999; //最大数
        int min = 100000; //最小数
        int code = random.nextInt(max); //生成随机数
        if (code < min){
            code = code + min;
        }
        LOGGER.info("生成的随机验证码为：{}",code);
        //2.将验证码存入redis中
        redisTemplate.opsForValue().set("mailcode_"+mail, code +"", 5, TimeUnit.MINUTES); //五分钟过期
        //3.将验证码和手机号发送到rabbitmq中
        Map<String,Object> map = new HashMap();
        map.put("mail",mail);
        map.put("code",code+"");
        rabbitTemplate.convertAndSend("mail",map);
    }

}

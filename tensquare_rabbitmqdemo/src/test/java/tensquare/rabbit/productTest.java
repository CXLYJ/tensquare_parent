package tensquare.rabbit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by lyj on 2019/1/21.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = RabbitApplication.class)
public class productTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 直接模式测试
     */
    @Test
    public void testMessage(){
        rabbitTemplate.convertAndSend("itcast","直接模式");
    }

    /**
     * 分裂模式测试
     */
    @Test
    public void testMessage2(){
        rabbitTemplate.convertAndSend("chaunzhi","","分裂模式");
    }

    /**
     * 主题模式测试
     */
    @Test
    public void testMessage3(){
        //全部匹配
//        rabbitTemplate.convertAndSend("topic84","good.log","主题模式");

        //good.#,#.log,good.log匹配的规则
        rabbitTemplate.convertAndSend("topic84","good.aaa","主题模式");
    }

}

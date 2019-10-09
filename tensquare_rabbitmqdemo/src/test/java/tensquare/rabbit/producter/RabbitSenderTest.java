package tensquare.rabbit.producter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tensquare.rabbit.RabbitApplication;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2019/10/9
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = RabbitApplication.class)
public class RabbitSenderTest {

    @Autowired
    private RabbitSender rabbitSender;

    @Test
    public void testSender1() throws Exception{
        Map<String, Object> properties = new HashMap<>();
        properties.put("number","123456");
        properties.put("send_times", new Date());
        rabbitSender.send("Hello RabbitMQ！", properties);
    }

}

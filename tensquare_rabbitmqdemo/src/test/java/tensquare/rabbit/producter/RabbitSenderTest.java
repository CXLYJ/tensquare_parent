package tensquare.rabbit.producter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tensquare.rabbit.RabbitApplication;
import tensquare.rabbit.entity.Order;

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
    public void testSender1(){
        Map<String, Object> properties = new HashMap<>();
        properties.put("number","123456");
        properties.put("send_times", new Date());
        rabbitSender.send("Hello RabbitMQ！", properties);
    }


//    public Order getOrder(){
//        return
//                Order.builder()
//                    .id("001")
//                    .name("奶茶")
//                    .build();
//    }

    @Test
    public void testSender2(){
        Order order = Order.builder()
                        .id("001")
                        .name("奶茶")
                        .build();
        rabbitSender.sendOrder(order);
    }

}

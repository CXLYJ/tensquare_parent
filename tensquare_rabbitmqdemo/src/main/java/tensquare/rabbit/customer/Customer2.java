package tensquare.rabbit.customer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by lyj on 2019/1/21.
 *
 * 主题模式
 */
@Component
@RabbitListener(queues = "itheima")
public class Customer2 {

    @RabbitHandler
    public void showMessage(String message){
        System.out.println("itheima："+ message);
    }

}

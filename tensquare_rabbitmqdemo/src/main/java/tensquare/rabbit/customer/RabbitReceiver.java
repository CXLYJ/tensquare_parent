package tensquare.rabbit.customer;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import tensquare.rabbit.entity.Order;

import java.util.Map;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2019/10/10
 */
@Component
public class RabbitReceiver {

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "queue-2", durable = "true"),
            exchange = @Exchange(value = "exchange-2",
            durable = "true",
            type = "topic",
            ignoreDeclarationExceptions = "true"),
            key = "springboot.*"
        )
    )
    @RabbitHandler
    public void onMessage(Message message, Channel channel)throws Exception{
        System.err.println("消费端收到消息体内容：" + message.getPayload());
        Long deliverTag =  (Long) message.getHeaders().get(AmqpHeaders.DELIVERY_TAG);
        //手工ACK
        channel.basicAck(deliverTag, false);
    }


    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "${rabbitmq.order.queue.name}",
                    durable = "${rabbitmq.order.queue.durable}"),
            exchange = @Exchange(value = "${rabbitmq.order.exchange.name}",
                    durable = "${rabbitmq.order.exchange.durable}",
                    type = "${rabbitmq.order.exchange.type}",
                    ignoreDeclarationExceptions = "${rabbitmq.order.exchange.ignoreDeclarationExceptions}"),
            key = "${rabbitmq.order.key}"
        )
    )
    @RabbitHandler
    public void OrderMessage(@Payload Order order,
                             Channel channel,
                             @Headers Map<String, Object> headers)throws Exception{
        System.err.println("消费端收到消息体内容：" + order.getId() + "," + order.getName());
        Long deliverTag =  (Long) headers.get(AmqpHeaders.DELIVERY_TAG);
        //手工ACK
        channel.basicAck(deliverTag, false);
    }

}

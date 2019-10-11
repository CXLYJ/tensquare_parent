package tensquare.rabbit.producter;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import tensquare.rabbit.entity.Order;

import java.util.Map;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2019/10/9
 */
@Component
public class RabbitSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${rabbitmq.order.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.order.key}")
    private String routingKey;

    final RabbitTemplate.ConfirmCallback confirmCallback = new RabbitTemplate.ConfirmCallback() {
        @Override
        public void confirm(CorrelationData correlationData, boolean ack, String cause) {
            System.err.println("correlationData : " + correlationData);
            System.err.println("ack : " + ack);
            if (!ack){
                System.err.println("异常处理......");
            }
        }
    };

    final RabbitTemplate.ReturnCallback returnCallback = new RabbitTemplate.ReturnCallback() {
        @Override
        public void returnedMessage(org.springframework.amqp.core.Message message, int replyCode,
                                    String replyText, String exchange, String routingKey) {
            System.err.println("return exchange : " + exchange + ", routingKey : " + routingKey
                                + ", replyCode : " + replyCode + ", replyText : " + replyText
                                + ", message : " + message);
        }
    };

    public void send(Object message, Map<String,Object> properties){
        MessageHeaders mbs = new MessageHeaders(properties);
        Message msg = MessageBuilder.createMessage(message, mbs);
        rabbitTemplate.setConfirmCallback(confirmCallback);
        rabbitTemplate.setReturnCallback(returnCallback);
        // id + 时间 全剧唯一
        CorrelationData cd = new CorrelationData("123456789");
        rabbitTemplate.convertAndSend("exchange-2", "springboot.hello", msg, cd);
    }

    public void sendOrder(Order order){
        rabbitTemplate.setConfirmCallback(confirmCallback);
        rabbitTemplate.setReturnCallback(returnCallback);
        // id + 时间 全剧唯一
        CorrelationData cd = new CorrelationData("987654321");
        rabbitTemplate.convertAndSend(exchange, routingKey, order, cd);
    }

}

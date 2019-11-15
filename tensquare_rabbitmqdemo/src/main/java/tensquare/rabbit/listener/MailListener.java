//package tensquare.rabbit.listener;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.amqp.rabbit.annotation.RabbitHandler;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.stereotype.Component;
//
//import java.util.map;
//
///**
// * Created by lyj on 2019/1/22.
// * 邮箱监听
// */
//@Component
//@RabbitListener(queues = "mail")
//public class MailListener {
//
//    private static final Logger LOGGER = LoggerFactory.getLogger(MailListener.class);
//
//    @Autowired
//    private JavaMailSender mailSender;
//
//    @Value("${spring.mail.username}")
//    private String sender;
//
//    /**
//     * 监听到消息发送邮件
//     * @param map
//     */
//    @RabbitHandler
//    public void setMailSender(map<String,Object> map){
//        String mail = String.valueOf(map.get("mail"));
//        String code = String.valueOf(map.get("code"));
//        LOGGER.info("手机号：{}",map.get("mail"));
//        LOGGER.info("验证码：{}",map.get("code"));
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setFrom(sender);
//        message.setTo(mail); //发送邮件的邮箱
//        message.setSubject("中国太平洋：验证码");
//        message.setText(code);
//        mailSender.send(message);
//    }
//
//}

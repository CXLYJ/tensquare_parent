package tensquare.rabbit.server;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tensquare.rabbit.RabbitApplication;


/**
 * Created by lyj on 2019/1/22.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = RabbitApplication.class)
public class RabbitServerTest {

    @Autowired
    private RabbitServer rabbitServer;

    @Test
    public void sendSimpleMail() {
      rabbitServer.snedMail("1421805850@qq.com");
    }

}
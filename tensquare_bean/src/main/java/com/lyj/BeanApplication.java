package com.lyj;

import com.lyj.config.WebConfig;
import com.lyj.entity.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class BeanApplication {

    public static void main(String[] args) {
        SpringApplication.run(BeanApplication.class, args);

        //返回 IOC 容器，使用注解配置，传入配置
        ApplicationContext context = new AnnotationConfigApplicationContext(WebConfig.class);
        User user = context.getBean(User.class);
        System.out.println(user);
    }

}

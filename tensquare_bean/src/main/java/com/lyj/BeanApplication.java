package com.lyj;

import com.lyj.demo.config.WebConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

/**
 *
 * 值得注意的是，我们不能将Spring Boot的入口类纳入扫描范围中，否则项目启动将出错
 */

@SpringBootApplication
public class BeanApplication {

    public static void main(String[] args) {
        SpringApplication.run(BeanApplication.class, args);

        //返回 IOC 容器，使用注解配置，传入配置
        ApplicationContext context = new AnnotationConfigApplicationContext(WebConfig.class);
        /*User user = context.getBean(User.class);
        System.out.println(user);*/

        /*String[] beanNames = context.getBeanNamesForType(User.class);
        Arrays.stream(beanNames).forEach(System.out::println);*/

        // 查看基于注解的 IOC容器中所有组件名称
        String[] beanNames = context.getBeanDefinitionNames();
        Arrays.stream(beanNames).forEach(System.out::println);
    }

}

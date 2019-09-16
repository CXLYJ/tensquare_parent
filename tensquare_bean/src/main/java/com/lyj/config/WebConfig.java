package com.lyj.config;

import com.lyj.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2019/9/16
 *
 * 通过@Bean注解，我们向IOC容器注册了一个名称为user（Bean名称默认为方法名，
 * 我们也可以通过@Bean("myUser")方式来将组件名称指定为myUser）
 */
@Configuration
public class WebConfig {

    @Bean
    public User user(){
        return new User("lyj",18);
    }
}

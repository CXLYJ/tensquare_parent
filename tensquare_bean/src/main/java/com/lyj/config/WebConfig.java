package com.lyj.config;

import com.lyj.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2019/9/16
 */
@Configuration
public class WebConfig {

    @Bean
    public User user(){
        return new User("lyj",18);
    }
}

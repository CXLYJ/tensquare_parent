package com.lyj.demo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2019/9/16
 *
 * 1.通过@Bean注解，我们向IOC容器注册了一个名称为user（Bean名称默认为方法名，
 * 我们也可以通过@Bean("myUser")方式来将组件名称指定为myUser）
 *
 *
 * 2.在配置类中，我们通过@ComponentScan("cc.mrbird.demo")配置了扫描路径，
 * 并且将User组件注册注释掉了，取而代之的是在User类上加上@Component注解
 *
 * 
 * 3.其中base-package指定了扫描的路径。路径下所有被@Controller、@Service、@Repository和@Component注解标注的类都会被纳入IOC容器中。
 * 现在我们脱离XML配置后，可以使用@ComponentScan注解来扫描组件并注册。
 * 在使用@ComponentScan扫描之前，我们先创建一个Controller，一个Service，一个Dao，并标注上相应的注解。
 * 然后修改配置类
 */
@Configuration
@ComponentScan("com.lyj.demo")
public class WebConfig {

//    @Bean("myUser")
//    public User user(){
//        return new User("lyj",18);
//    }
}

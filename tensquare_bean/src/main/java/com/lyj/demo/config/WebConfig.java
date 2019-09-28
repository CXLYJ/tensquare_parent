package com.lyj.demo.config;

import com.lyj.demo.entity.User;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2019/9/16
 *
 * 1.
 * 通过@Bean注解，我们向IOC容器注册了一个名称为user（Bean名称默认为方法名，
 * 我们也可以通过@Bean("myUser")方式来将组件名称指定为myUser）
 *
 *
 * 2.
 * 在配置类中，我们通过@ComponentScan("cc.mrbird.demo")配置了扫描路径，
 * 并且将User组件注册注释掉了，取而代之的是在User类上加上@Component注解
 *
 * 
 * 3.
 * 其中base-package指定了扫描的路径。路径下所有被@Controller、@Service、@Repository和@Component注解标注的类都会被纳入IOC容器中。
 * 现在我们脱离XML配置后，可以使用@ComponentScan注解来扫描组件并注册。
 * 在使用@ComponentScan扫描之前，我们先创建一个Controller，一个Service，一个Dao，并标注上相应的注解。
 * 然后修改配置类
 *
 *
 * 4.
 * 根据注解来排除（type = FilterType.ANNOTATION）,这些注解的类型为classes = {Controller.class, Repository.class}。
 * 即Controller和Repository注解标注的类不再被纳入到IOC容器中。
 * 根据指定类型类排除（type = FilterType.ASSIGNABLE_TYPE），排除类型为User.class，其子类，实现类都会被排除。
 *
 *
 * 5.
 * 可看到，我们还可以通过ASPECTJ表达式，REGEX正则表达式和CUSTOM自定义规则（下面详细介绍）来指定扫描策略。
 * includeFilters的作用和excludeFilters相反，其指定的是哪些组件需要被扫描
 * 下面配置了只将Controller纳入IOC容器，并且需要用useDefaultFilters = false来关闭Spring默认的扫描策略
 * 才能让我们的配置生效（Spring Boot入口类的@SpringBootApplication注解包含了一些默认的扫描策略）
 *
 */
@Configuration
//@ComponentScan("com.lyj.demo")
@ComponentScan(value = "com.lyj.demo",
        excludeFilters = {
                @ComponentScan.Filter(type = FilterType.ANNOTATION,
                                      classes = {Controller.class, Repository.class}),
                @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = User.class)
        })
//@ComponentScan(value = "com.lyj.demo",
//        includeFilters = {
//                @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = UserService.class)
//        }, useDefaultFilters = false)
public class WebConfig {

//    @Bean("myUser")
//    public User user(){
//        return new User("lyj",18);
//    }
}

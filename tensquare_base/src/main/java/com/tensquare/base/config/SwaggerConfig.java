package com.tensquare.base.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2019/9/2
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .enable(true)
                .select()
                .build()
                .useDefaultResponseMessages(false);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("机器人SWAGGER")//大标题
                .description("机器人项目接口")//详细描述
                .version("3.0")//版本
                .contact(new Contact("lyj", "https://iclyj.cn", "iclyj@iclyj.cn"))//作者
                .termsOfServiceUrl("NO terms of service")
                .license("The Apache License, Version 3.0")
                .licenseUrl("http://localhost:8080/Robot/swagger-ui.html")
                .build();
    }

}

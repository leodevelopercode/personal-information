package com.leo.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Xiexingxie
 * @date 2023/4/15 下午 08:13
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

    /**
     * enable: 是否开启网页浏览
     * select:
     * .apis(RequestHandlerSelectors.basePackage("com.leo.example")): 配置扫描的接口的方式
     *          RequestHandlerSelectors.any 扫描全部包
     *          RequestHandlerSelectors.none 都不扫描
     *          RequestHandlerSelectors.withClassAnnotation 扫描类上的注解
     *          RequestHandlerSelectors.withMethodAnnotation 扫描方法上的注解
     * 
     * .paths(PathSelectors.any()): 扫描过滤方式
     *          PathSelectors.any() 过滤全部
     *          PathSelectors.none() 不过滤
     *          PathSelectors.regex() 正则表达式过滤
     *          PathSelectors.ant() 过滤指定路径
     * 
     * @return
     */
    @Bean
    Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(true)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.leo.example.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 设置API网页浏览的标题以及各种信息
     * title: 设置文档标题
     * description: 设置文档小标题
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("API文档")
                .description("personalInformation接口测试文档")
                .version("1.0")
                .build();
    }

}

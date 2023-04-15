package com.leo.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Xiexingxie
 * @date 2023/4/14 下午 10:41
 */

@SpringBootApplication
@MapperScan("com.leo.example.repositories")
public class PersonApplication {

    public static void main(String[] args) {
        SpringApplication.run(PersonApplication.class,args);
    }
    
}

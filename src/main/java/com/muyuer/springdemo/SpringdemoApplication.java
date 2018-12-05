package com.muyuer.springdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 主类
 * @author muyuer 182443947@qq.com
 * @date 2018-12-02 17:24
 */
@EnableSwagger2
@SpringBootApplication
public class SpringdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringdemoApplication.class, args);
    }
}

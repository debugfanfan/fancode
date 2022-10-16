package com.fan.fancode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

/**
 * 项目启动类
 *
 * @author debug_fan
 * @date 2022/10/13 22:39
 **/
@EnableOpenApi  // @EnableOpenApi解决swagger-ui.html访问不到
@SpringBootApplication  // @SpringBootApplication表示这是一个SpringBoot的应用,被标注的类是一个主程序
public class FanCodeApplication {

    public static void main(String[] args) {
        SpringApplication.run(FanCodeApplication.class, args);
    }

}

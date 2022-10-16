package com.fan.fancode;

import com.fan.fancode.config.property.MicroServiceUrl;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest // @SpringBootTest表示这是一个SpringBoot测试类
class FancodeApplicationTests {

    private final static Logger logger = LoggerFactory.getLogger(FancodeApplicationTests.class);

    @Resource   // @Resource表示从Spring容器中获取并注入该对象，可以直接使用
    private MicroServiceUrl microServiceUrl;

    @Test
        // @Test表示这是一个测试方法
    void contextLoads() {
    }

    @Test
    void testLog() {


        logger.debug("=====测试日志debug级别打印====");
        logger.info("======测试日志info级别打印=====");
        logger.error("=====测试日志error级别打印====");
        logger.warn("======测试日志warn级别打印=====");

        // 可以使用占位符打印出一些参数信息
        String str1 = "https://blog.csdn.net/qq_39393772";
        String str2 = "291622538";
        logger.info("======个人博客：{}；QQ：{}", str1, str2);
    }

    @Test
    void testPropertyConfig() {
        logger.info("=====获取的订单服务地址为：{}", microServiceUrl.getOrderUrl());
        logger.info("=====获取的用户服务地址为：{}", microServiceUrl.getUserUrl());
        logger.info("=====获取的购物车服务地址为：{}", microServiceUrl.getShoppingUrl());
    }

}

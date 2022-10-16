package com.fan.fancode.config.property;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 配置多个微服务的地址
 *
 * @author debug_fan
 * @date 2022/10/16 00:43
 **/
@Component
@ConfigurationProperties(prefix = "url")    // application.yml中找url开头的属性信息
public class MicroServiceUrl {
    // 与application.yml中的url.orderUrl匹配，获取其配置的属性值
    private String orderUrl;
    // 与application.yml中的url.userUrl匹配，获取其配置的属性值
    private String userUrl;
    // 与application.yml中的url.shoppingUrl匹配，获取其配置的属性值
    private String shoppingUrl;

    public String getOrderUrl() {
        return orderUrl;
    }

    public void setOrderUrl(String orderUrl) {
        this.orderUrl = orderUrl;
    }

    public String getUserUrl() {
        return userUrl;
    }

    public void setUserUrl(String userUrl) {
        this.userUrl = userUrl;
    }

    public String getShoppingUrl() {
        return shoppingUrl;
    }

    public void setShoppingUrl(String shoppingUrl) {
        this.shoppingUrl = shoppingUrl;
    }

    @Override
    public String toString() {
        return "MicroServiceUrl{" +
                "orderUrl='" + orderUrl + '\'' +
                ", userUrl='" + userUrl + '\'' +
                ", shoppingUrl='" + shoppingUrl + '\'' +
                '}';
    }
}
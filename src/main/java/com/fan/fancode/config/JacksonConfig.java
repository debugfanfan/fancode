package com.fan.fancode.config;


import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.io.IOException;

/**
 * jackson的配置类
 *
 * @author debug_fan
 * @date 2022/10/15 15:14
 **/
@Configuration  // @Configuration表示该类为配置类
public class JacksonConfig {

    /**
     * 将Controller返回值中的null值转换为空字符串
     *
     * @param builder builder
     * @return objectMapper
     */
    @Bean   // @Bean表示生成一个由 Spring 容器管理的 bean：objectMapper
    @Primary // @Primary表示在众多相同的bean中,优先使用用@Primary注解的bean
    @ConditionalOnMissingBean(ObjectMapper.class)
    // @ConditionalOnMissingBean(ObjectMapper.class)表示在不存在ObjectMapper的bean时执行该方法
    public ObjectMapper jacksonObjectMapper(Jackson2ObjectMapperBuilder builder) {
        // 创建ObjectMapper对象
        ObjectMapper objectMapper = builder.createXmlMapper(false).build();
        // 设置null值为空字符串
        objectMapper.getSerializerProvider().setNullValueSerializer(new JsonSerializer<Object>() {
            @Override
            public void serialize(Object o, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
                jsonGenerator.writeString("");
            }
        });
        return objectMapper;
    }
}


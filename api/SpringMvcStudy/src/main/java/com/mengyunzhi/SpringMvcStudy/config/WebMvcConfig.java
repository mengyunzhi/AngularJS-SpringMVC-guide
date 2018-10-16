package com.mengyunzhi.SpringMvcStudy.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * @author panjie on 2017/12/30
 */
@Component
public class WebMvcConfig {
    // 声明一个Bean. SpringMVC在启动的时候，会自动的打锚这个BEAN，并按这个BEAN的配置进行一些配置
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                // 添加一个映射 /Teacher
                // 此映射允许进行CORS的地址为：http://localhost:9000
                registry.addMapping("/**").allowedOrigins("http://localhost:9000")
                        .allowedMethods("GET", "POST", "DELETE", "PUT", "PATCH", "OPTIONS");
            }

            @Override
            public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
                ObjectMapper mapper = Jackson2ObjectMapperBuilder.json().defaultViewInclusion(true).build();
                converters.add(new MappingJackson2HttpMessageConverter(mapper));
            }
        };

    }
}

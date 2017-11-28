package com.mengyunzhi.SpringMvcStudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class SpringMvcStudyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMvcStudyApplication.class, args);
	}

	// 声明一个Bean. SpringMVC在启动的时候，会自动的打锚这个BEAN，并按这个BEAN的配置进行一些配置
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				// 添加一个映射 /Teacher
				// 此映射允许进行CORS的地址为：http://localhost:9000
				registry.addMapping("/Teacher").allowedOrigins("http://localhost:9000");
				registry.addMapping("/Teacher/").allowedOrigins("http://localhost:9000");
			}
		};
	}
}

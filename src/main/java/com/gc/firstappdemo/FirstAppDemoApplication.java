package com.gc.firstappdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@SpringBootApplication
@MapperScan("com.gc.firstappdemo.reposity")
@EnableAutoConfiguration(exclude = {ErrorMvcAutoConfiguration.class})
@EnableWebMvc
@ServletComponentScan
@EnableCaching
public class FirstAppDemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(FirstAppDemoApplication.class, args);
	}
}


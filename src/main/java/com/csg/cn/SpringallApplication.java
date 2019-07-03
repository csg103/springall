package com.csg.cn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@MapperScan(basePackages = "com.csg.cn.db.dao")
//@ServletComponentScan   启用后开启原生serverlet拦截 控制返回值
public class SpringallApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(SpringallApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(SpringallApplication.class);
	}

}


package com.csg.cn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.csg.cn.dao")
public class SpringallApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringallApplication.class, args);
	}

}


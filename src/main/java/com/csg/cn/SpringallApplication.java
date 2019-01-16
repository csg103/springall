package com.csg.cn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@MapperScan(basePackages = "com.csg.cn.db.dao")
//@ServletComponentScan   启用后开启原生serverlet拦截 控制返回值
public class SpringallApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringallApplication.class, args);
	}

}


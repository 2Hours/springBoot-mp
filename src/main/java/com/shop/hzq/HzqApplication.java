package com.shop.hzq;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.shop.hzq.mapper")
public class HzqApplication {

	public static void main(String[] args) {
		SpringApplication.run(HzqApplication.class, args);
	}
}

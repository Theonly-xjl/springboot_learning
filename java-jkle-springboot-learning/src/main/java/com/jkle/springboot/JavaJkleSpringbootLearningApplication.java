package com.jkle.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableTransactionManagement
@MapperScan("com.jkle.springboot.mapper")
public class JavaJkleSpringbootLearningApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaJkleSpringbootLearningApplication.class, args);
	}
}

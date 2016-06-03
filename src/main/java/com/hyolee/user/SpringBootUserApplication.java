package com.hyolee.user;

//import org.mybatis.spring.annotation.MapperScan;
import com.mangofactory.swagger.plugin.EnableSwagger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableSwagger
public class SpringBootUserApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringBootUserApplication.class, args);
	}
}

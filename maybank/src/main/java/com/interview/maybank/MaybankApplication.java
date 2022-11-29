package com.interview.maybank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = { "com.interview.maybank" })
@EnableJpaRepositories
@EnableAspectJAutoProxy
public class MaybankApplication {

	public static void main(String[] args) {
		SpringApplication.run(MaybankApplication.class, args);
	}

}

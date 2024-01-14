package com.eazybytes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
//@ComponentScan("com.eazybytes.controller") // 스캔할 패키지가 Application파일과 같은 위치에 있으면, 생략 가능
//// Jpa 사용 시 필요한 어노테이션 2개. 위와 마찬가지로, 같은 위치에 있다면 생략 가능
//@EnableJpaRepositories("com.eazybytes.repository")
//@EntityScan("com.eazybytes.model")
@EnableWebSecurity // 시큐리티 설정 / 스프링 부트가 자동으로 해줌. spring 프로젝트 시 필요
public class SpringSecuritySection3Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecuritySection3Application.class, args);
	}

}

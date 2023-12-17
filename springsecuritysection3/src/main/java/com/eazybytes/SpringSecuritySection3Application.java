package com.eazybytes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@ComponentScan("com.eazybytes.controller") // 스캔할 패키지가 Application파일과 같은 위치에 있으면, 생략 가능
public class SpringSecuritySection3Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecuritySection3Application.class, args);
	}

}

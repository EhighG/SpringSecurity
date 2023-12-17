package com.eazybytes.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

//        /**
//         * custom security configuration
//         */
//
//        http.authorizeHttpRequests((requests)
//                -> requests
//                .requestMatchers("/myAccount", "/myBalance", "/myCards", "/myLoans").authenticated()
//                .requestMatchers("/contact", "/notices").permitAll())
//                .formLogin(Customizer.withDefaults())
//                .httpBasic(Customizer.withDefaults()); // 기존 and(), formLogin(), httpBasic() 은 deprecated
//        return http.build();

//        /**
//         * denyAll()
//         */
//
//        http.authorizeHttpRequests((requests)
//                        -> requests
//                        .anyRequest().denyAll()) // 로그인 창까진 띄운 후, 성공하더라도 403 에러 반환
//                .formLogin(Customizer.withDefaults())
//                .httpBasic(Customizer.withDefaults()); // 기존 and(), formLogin(), httpBasic() 은 deprecated
//        return http.build();

        /**
         * permitAll()
         */

        http.authorizeHttpRequests((requests)
                        -> requests
                        .anyRequest().denyAll()) // 로그인 창까진 띄운 후, 성공하더라도 403 에러 반환
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults()); // 기존 and(), formLogin(), httpBasic() 은 deprecated
        return http.build();
    }
}

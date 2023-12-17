package com.eazybytes.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class ProjectSecurityConfig {

    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

        /**
         * custom security configuration
         */

        http.authorizeHttpRequests((requests)
                -> requests
                .requestMatchers("/myAccount", "/myBalance", "/myCards", "/myLoans").authenticated()
                .requestMatchers("/contact", "/notices").permitAll())
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults()); // 기존 and(), formLogin(), httpBasic() 은 deprecated
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }

//    /**
//     * manage multi-user info(inMemory)
//     * @return
//     */
//    @Bean
//    public InMemoryUserDetailsManager userDetailsService() {
//
////        /*
////         Approach 1. use withDefaultPasswordEncoder()
////         deprecated지만, 지금은 Inmemory 저장소를 사용하므로 괜찮음
////         주의 : password가 코드에 드러나는 건 테스트 목적 외에는 사용 시 주의!
////         */
////        // UserDetails는 인터페이스, User는 구현 클래스 / 모두 스프링 시큐리티가 제공
////        UserDetails admin = User.withDefaultPasswordEncoder()
////                .username("admin")
////                .password("123")
////                .authorities("admin")
////                .build();
////
////        UserDetails user = User.withDefaultPasswordEncoder()
////                .username("user")
////                .password("123")
////                .authorities("read")
////                .build();
//
//        /*
//         Approach 2. 빈으로 등록된 passwordEncoder 사용
//         passwordEncoder 빈을 등록하는 메소드를 외부에 따로 만든다.
//         */
//        UserDetails admin = User.withUsername("admin")
//                .password("123")
//                .authorities("admin")
//                .build();
//
//        UserDetails user = User.withUsername("user")
//                .password("123")
//                .authorities("read")
//                .build();
//
//        return new InMemoryUserDetailsManager(admin, user);
//    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        /*
        인코딩 동작이 없는 인코더(사용시 패스워드가 그대로 저장됨). 추천되지 않음
         */
        return NoOpPasswordEncoder.getInstance();
    }

//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth, DataSource ds) throws Exception {
//        String userQuery = "custom Query";
//        String authQuery = "custom Query";
//
//        auth.jdbcAuthentication()
//                .dataSource(ds)
//                .rolePrefix("ROLE_")
//                .usersByUsernameQuery(userQuery)
//                .authoritiesByUsernameQuery(authQuery);
//    }
}

package com.codingyash.crmsystem.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Controller;

import javax.sql.DataSource;

@Controller
public class SecurityConfig {
    @Bean
    public JdbcUserDetailsManager userDetailsManager(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }
    //Take data from own table instead of spring default table for login

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(configurer ->
                        configurer
//                                .requestMatchers("/").hasRole("EMPLOYEE")
//                                .requestMatchers("/leaders/**").hasRole("MANAGER")
//                                .requestMatchers("/systems").hasRole("ADMIN")
                                .anyRequest().authenticated()
                )

                .formLogin(form ->
                        form
                                .loginPage("/showMyLoginPage")
                                .loginProcessingUrl("/authenticateTheUser")
                                .permitAll()
                )
                .logout(logout -> logout.permitAll()
                );
//                .exceptionHandling(configurer ->
//                        configurer.accessDeniedPage("/access-denied")
//                );



        return http.build();
    }


}


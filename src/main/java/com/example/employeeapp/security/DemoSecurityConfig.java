package com.example.employeeapp.security;
import com.example.employeeapp.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {
    //@Bean
    //public InMemoryUserDetailsManager userDetailsManager(){
    //        UserDetails john = User.builder()
    //                .username("john")
    //                .password("{noop}test123")
    //                .roles("EMPLOYEE")
    //                .build();
    //        return new InMemoryUserDetailsManager(john);
    //}

    //@Bean
    //public UserDetailsManager userDetailsManager(DataSource dataSource){
    //    return new JdbcUserDetailsManager(dataSource);
    //}

    //bcrypt bean definition
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //authenticationProvider bean definition
    @Bean

    public DaoAuthenticationProvider authenticationProvider(UserService userService) {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userService); //set the custom user details service
        auth.setPasswordEncoder(passwordEncoder()); //set the password encoder - bcrypt
        return auth;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configure ->
                configure
                        .requestMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT, "/api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN"));

        http.csrf(crsf->crsf.disable());
        http.httpBasic(Customizer.withDefaults());
        return http.build();
    }
}
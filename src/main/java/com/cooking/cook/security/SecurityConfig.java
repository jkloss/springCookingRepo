package com.cooking.cook.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableJpaAuditing
@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers( "/pizza").hasRole("ADMIN")
                .antMatchers( "/order").hasAnyRole("ADMIN", "USER")
                .antMatchers( "/orderPizza").hasAnyRole("ADMIN", "USER")
                .antMatchers( "/allOrdersPersonalized").hasRole("USER")
                .antMatchers( "/allOrdersToDisplay").hasAnyRole("WORKER", "ADMIN")
                .antMatchers( "/deleteDoneOrder").hasAnyRole("ADMIN", "WORKER")
                .antMatchers( "/deleteRecord/{id}").hasAnyRole("ADMIN", "WORKER")
                .antMatchers("/update").hasRole("USER")
                .antMatchers("/doUpdate").hasRole("USER")
                .antMatchers( "/mainMenu").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginProcessingUrl("/login")
                .loginPage("/loginNewCustomer")
                .failureUrl("/errorLogin")
                .permitAll()
                .and()
                .httpBasic();

    }

    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User
        .withUsername("jan")
        .password(encoder().encode("bla"))
        .roles("USER").build());
        manager.createUser(User
        .withUsername("admin")
        .password(encoder().encode("admin2"))
        .roles("ADMIN").build());
        manager.createUser(User
        .withUsername("worker")
        .password(encoder().encode("work1"))
        .roles("WORKER").build());
        manager.createUser(User
        .withUsername("nowak")
        .password(encoder().encode("now"))
        .roles("USER").build());
        return manager;
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
}

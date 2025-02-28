package com.example.SpringSecurity.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.config.http.UserDetailsServiceFactoryBean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.security.Security;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Autowired()
    UserDetailsService userDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception {

       security.csrf(customizer->customizer.disable());
       security.authorizeHttpRequests(request->request.anyRequest().authenticated());
       security.formLogin(Customizer.withDefaults());
       security.httpBasic(Customizer.withDefaults());
       security.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
       return security.build();

    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
        provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
        provider.setUserDetailsService(userDetailsService);
        return provider;
    }

   /* @Bean
    public UserDetailsService userDetailsService(){
        UserDetails user1= User.withDefaultPasswordEncoder()
                .username("balajis")
                .password("123")
                .roles("user")
                .build();
        UserDetails user2= User.withDefaultPasswordEncoder()
                .username("admin")
                .password("123")
                .roles("admin")
                .build();
        UserDetails user3= User.withDefaultPasswordEncoder()
                .username("subera")
                .password("123")
                .roles("user")
                .build();
        return new InMemoryUserDetailsManager(user1,user2,user3);

    }*/
}

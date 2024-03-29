package com.dds.notesbox.security;

import jakarta.servlet.Filter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import lombok.AllArgsConstructor;

/*
 * Thanks Todo TIC
 * https://www.youtube.com/watch?v=_p-Odh3MZJc
 */

@Configuration
@AllArgsConstructor
public class WebSecurityConfig {

  private final UserDetailsService userDetailsService;
  private final JWTAuthorizationFilter jwtAuthorizationFilter;

  @Bean
  SecurityFilterChain filterChain(HttpSecurity http, AuthenticationManager authManager) throws Exception {

    JWTAuthenticationFilter jwtAuthenticationFilter = new JWTAuthenticationFilter();
    //jwtAuthenticationFilter.setAuthenticationManager(authManager);
    //jwtAuthenticationFilter.setFilterProcessesUrl("/login");
    
    return http.csrf().disable()
    .authorizeHttpRequests()
    //TODO: Refine anonymous endpoints
    //.anyRequest().permitAll()
    .requestMatchers(HttpMethod.GET, "/api/products/**").permitAll()
    .requestMatchers(HttpMethod.POST, "/api/auth/login**").permitAll()
    //.requestMatchers(HttpMethod.GET, "/api/test**").permitAll()
    //.and().formLogin().loginProcessingUrl("/api/login")
    .and()
    .httpBasic()
    .and()
    .sessionManagement()
    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
    .and()
    //.addFilter((Filter) jwtAuthenticationFilter)
    .addFilterBefore(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class)
    .build();
  }


  // @Bean
  // UserDetailsService userDetailsService() {
  //   InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
  //   manager.createUser(User.withUsername("admin").password(passwordEncoder().encode("admin")).roles().build());
  //   return manager;
  // }

  @Bean
  AuthenticationManager authManager(HttpSecurity http) throws Exception {
    return http.getSharedObject(AuthenticationManagerBuilder.class).userDetailsService(userDetailsService).passwordEncoder(passwordEncoder()).and().build();
  }

  @Bean
  PasswordEncoder passwordEncoder() {
    return new Argon2Encoder();
  }
}

package com.douzone.HISservice.config;

import com.douzone.HISservice.config.jwt.JwtAuthenticationFilter;
import com.douzone.HISservice.config.jwt.JwtAuthorizationFilter;
import com.douzone.HISservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.web.cors.CorsUtils;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CorsFilter corsFilter;
    private final UserRepository userRepository;


    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.addFilterBefore(new MyFilter1(), SecurityContextPersistenceFilter.class);
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .cors().and()
                .addFilter(corsFilter) // @CrossOrigin(인증X), 시큐리티 필터에 등록 인증(O)
                .formLogin().disable()
                .httpBasic().disable() //
                .addFilter(new JwtAuthenticationFilter(authenticationManager())) // AuthenticationManager
                .addFilter(new JwtAuthorizationFilter(authenticationManager(), userRepository))
                .authorizeRequests()
//                .antMatchers("/doctor/**")
//                .access("hasRole('ROLE_DOCTOR')")
//                .antMatchers("/reception/**")
//                .access("hasRole('ROLE_OUTRECEIPT')")
//                .antMatchers("/outpatient/**")
//                .access("hasRole('ROLE_OUTNURSE')")
//                .antMatchers("/ward-management/**")
//                .access("hasRole('ROLE_INRECEIPT')")
//                .antMatchers("/ward-management2/**")
//                .access("hasRole('ROLE_INNURSE')")
                .requestMatchers(CorsUtils::isPreFlightRequest).permitAll()
                .anyRequest().permitAll();
    }
}
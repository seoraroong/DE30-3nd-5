package com.miniproject3.seoultour.config;

import com.miniproject3.seoultour.oauth2.util.CookieUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutFilter;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers("/", "/login**", "/css/**", "/js/**").permitAll()
                                .anyRequest().authenticated()
                )
                .oauth2Login(oauth2Login ->
                        oauth2Login
                                .loginPage("/login1")
                                .defaultSuccessUrl("/survey", true)
                )
                .logout(logout ->
                        logout
                                .logoutUrl("/logout")
                                .logoutSuccessHandler(logoutSuccessHandler())
                                .invalidateHttpSession(true)
                                .clearAuthentication(true)
                                .deleteCookies("JSESSIONID")
                                .permitAll()
                );

        return http.build();
    }

    // 로그아웃 성공 시 핸들러
    @Bean
    public LogoutSuccessHandler logoutSuccessHandler() {
        SimpleUrlLogoutSuccessHandler handler = new SimpleUrlLogoutSuccessHandler();
        handler.setUseReferer(true); // 로그아웃 후 이전 페이지로 리다이렉트
        return handler;
    }

    @Bean
    public WebSecurityCustomizer configure(){
        return (web -> web.ignoring()
                .requestMatchers(new AntPathRequestMatcher("/**"))
        );
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }


}
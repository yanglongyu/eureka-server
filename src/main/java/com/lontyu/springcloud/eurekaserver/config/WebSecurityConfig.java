package com.lontyu.springcloud.eurekaserver.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

/**
 * @description: web安全配置
 * @author: xiaoZongjin
 * @create: 2019-09-02
 */
@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER);
        // 关闭csrf
        http.csrf().disable();
        //开启认证
        http.authorizeRequests()
                .anyRequest()
                .authenticated()
                .and().httpBasic();
    }
}
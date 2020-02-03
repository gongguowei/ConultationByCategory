package com.aircos.config.security;

import com.aircos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 登录用户安全配置
 *
 * @author 龚国玮
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true,jsr250Enabled = true,prePostEnabled = true)
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthenticationSuccessHandler authenticationSuccessHandler;

    @Autowired
    private AuthenticationFailHandler authenticationFailHandler;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Autowired
    private MyAuthenticationEntryPoint myAuthenticationEntryPoint;

    @Autowired
    private RestAccessDeniedHandler restAccessDeniedHandler;

    @Autowired
    private UserService userService;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoderBean());
    }

    @Bean
    public PasswordEncoder passwordEncoderBean() {
        return new JWTPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                // 禁用 CSRF
                .csrf().disable()
                // 未登录处理
                //表单登录方式
                .formLogin()
                //web端登录请求url
                .loginProcessingUrl("/login")
                .usernameParameter("username")
                .passwordParameter("password")
                .permitAll()
                //成功处理类
                .successHandler(authenticationSuccessHandler)
                //失败
                .failureHandler(authenticationFailHandler)
                // 不创建会话
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                // 过滤请求
                .authorizeRequests()
                .antMatchers(
                        HttpMethod.GET,
                        "/*.html",
                        "/**/*.html",
                        "/**/*.css",
                        "/**/*.js"
                ).anonymous()
                .antMatchers("*").permitAll()
                // swagger start
                .antMatchers("/swagger-ui.html").permitAll()
                .antMatchers("/swagger-resources/**").permitAll()
                .antMatchers("/webjars/**").permitAll()
                .antMatchers("/*/api-docs").permitAll()
                // swagger end
                .antMatchers("/v1/user/create").permitAll()
                // 所有请求都需要认证
                .anyRequest().authenticated()
                // 防止iframe 造成跨域
                .and().headers().frameOptions().disable()
                .and().exceptionHandling()
                // 用来解决匿名用户访问无权限资源时的异常
                .authenticationEntryPoint(myAuthenticationEntryPoint)
                // 自定义权限拒绝处理类
                .accessDeniedHandler(restAccessDeniedHandler).and()
                //添加自定义权限过滤器
                //.addFilterBefore(myFilterSecurityInterceptor, FilterSecurityInterceptor.class)
                //添加JWT过滤器 除已配置的其它请求都需经过此过滤器
                .addFilter(new JWTAuthenticationFilter(authenticationManager(), userService));
    }
}
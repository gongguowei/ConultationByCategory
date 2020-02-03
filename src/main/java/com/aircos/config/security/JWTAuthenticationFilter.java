package com.aircos.config.security;

import cn.hutool.core.util.StrUtil;
import com.aircos.constant.CommonConstant;
import com.aircos.service.UserService;
import com.aircos.util.JwtUtil;
import com.aircos.util.ResponseUtil;
import com.alibaba.fastjson.JSONObject;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * JWT过滤器
 *
 * @author 龚国玮
 */
@Slf4j
public class JWTAuthenticationFilter extends BasicAuthenticationFilter {

    private UserService userService;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager, UserService userService) {
        super(authenticationManager);
        this.userService = userService;
    }

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager, AuthenticationEntryPoint authenticationEntryPoint) {
        super(authenticationManager, authenticationEntryPoint);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {

        String header = request.getHeader(CommonConstant.HEADER);
        if(StrUtil.isBlank(header)){
            header = request.getParameter(CommonConstant.HEADER);
        }
        if(StrUtil.isNotBlank(header) && header.startsWith(CommonConstant.TOKEN_SPLIT)){
            try {
                UsernamePasswordAuthenticationToken authentication = getAuthentication(header, response);
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        chain.doFilter(request, response);
    }

    private UsernamePasswordAuthenticationToken getAuthentication(String token, HttpServletResponse response) {

        // 用户名
        String openId = null;
        // 权限
        List<GrantedAuthority> authorities = new ArrayList<>();

        JSONObject object = JwtUtil.decrypt(token);
        if(object.getBoolean("success")){
            Claims claims = (Claims) object.get("data");
            openId = claims.getSubject();
        }else{
            ResponseUtil.out(response, ResponseUtil.resultMap(false,object.getInteger("code"), object.getString("message")));
        }

        if(StrUtil.isNotBlank(openId)) {
            //Exrick踩坑提醒 此处password不能为null
            User principal = new User(openId, "", authorities);
            return new UsernamePasswordAuthenticationToken(principal, null, authorities);
        }
        return null;
    }
}
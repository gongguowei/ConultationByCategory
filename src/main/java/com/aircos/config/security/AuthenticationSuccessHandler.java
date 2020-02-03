package com.aircos.config.security;

import com.aircos.enums.ResultCode;
import com.aircos.util.JwtUtil;
import com.aircos.util.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 登录成功处理类
 *
 * @author 龚国玮
 */
@Slf4j
@Component
public class AuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        String openId = ((UserDetails) authentication.getPrincipal()).getUsername();

        Map<String, Object> map = new HashMap<>(16);
        map.put("text", "test");
        //踩坑: Response的code与msg必须在这里设置
        ResponseUtil.out(response, ResponseUtil.resultMap(true,200,"登录成功", JwtUtil.encrypt(openId, map)));
    }
}

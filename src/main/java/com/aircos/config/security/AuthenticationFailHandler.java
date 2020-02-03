package com.aircos.config.security;

import com.aircos.core.LoginFailLimitException;
import com.aircos.enums.ResultCode;
import com.aircos.util.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 错误过滤处理器
 *
 * @author 龚国玮
 */
@Slf4j
@Component
public class AuthenticationFailHandler extends SimpleUrlAuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        if (e instanceof UsernameNotFoundException || e instanceof BadCredentialsException) {
            ResponseUtil.out(response, ResponseUtil.resultMap(false, ResultCode.WRONG_USERNAME_OR_PASSWORD.getCode(), ResultCode.WRONG_USERNAME_OR_PASSWORD.getMessage()));
        } else if (e instanceof DisabledException) {
            ResponseUtil.out(response, ResponseUtil.resultMap(false,ResultCode.ACCOUNT_DISABLED.getCode(), ResultCode.ACCOUNT_DISABLED.getMessage()));
        } else if (e instanceof LoginFailLimitException){
            ResponseUtil.out(response, ResponseUtil.resultMap(false,500,((LoginFailLimitException) e).getMsg()));
        } else {
            log.error(e.getMessage(), e);
            ResponseUtil.out(response, ResponseUtil.resultMap(false,ResultCode.INTERNAL_ERROR.getCode(), ResultCode.INTERNAL_ERROR.getMessage()));
        }
    }
}

package com.aircos.config.security;

import com.aircos.enums.ResultCode;
import com.aircos.util.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义权限不足处理程序
 *
 * @author 龚国玮
 */
@Component
@Slf4j
public class RestAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) {
        ResponseUtil.out(response, ResponseUtil.resultMap(false, ResultCode.NO_PERMISSION.getCode(), ResultCode.NO_PERMISSION.getMessage()));
    }

}

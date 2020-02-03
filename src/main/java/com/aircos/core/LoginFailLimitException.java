package com.aircos.core;

import lombok.Data;
import org.springframework.security.authentication.InternalAuthenticationServiceException;

/**
 * 自定义用户错误处理类
 *
 * @author 龚国玮
 */
@Data
public class LoginFailLimitException extends InternalAuthenticationServiceException {

    private String msg;

    public LoginFailLimitException(String msg){
        super(msg);
        this.msg = msg;
    }

    public LoginFailLimitException(String msg, Throwable t) {
        super(msg, t);
        this.msg = msg;
    }
}
package com.aircos.core;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

/**
 * 自定义统一异常处理
 *
 * @author 龚国玮
 */
@Getter
public class BadRequestException extends RuntimeException{

    private Integer status = BAD_REQUEST.value();

    private Integer errorCode;

    public BadRequestException(String msg){
        super(msg);
    }

    public BadRequestException(HttpStatus status, String msg){
        super(msg);
        this.status = status.value();
    }

    public BadRequestException(Integer errorCode, String message) {
        super(message);
        setErrorCode(errorCode);
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }
}
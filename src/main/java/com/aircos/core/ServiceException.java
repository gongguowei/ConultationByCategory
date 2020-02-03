package com.aircos.core;

import com.aircos.enums.ResultCode;

/**
 * 无需HTTP错误码的服务（业务）异常，该异常原则上只服务于Service层和Manage层
 *
 * @author 龚国玮
 * @see com.aircos.config.WebMvcConfig
 */
public class ServiceException extends RuntimeException {

    private Integer errorCode;

    public ServiceException() {
    }

    public ServiceException(String message) {
        super(message);
        errorCode = -1;
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
        errorCode = -1;
    }

    public ServiceException(Integer errorCode, String message) {
        super(message);
        setErrorCode(errorCode);
    }

    public ServiceException(Integer errorCode, String message, Throwable cause) {
        super(message, cause);
        setErrorCode(errorCode);
    }

    public ServiceException(ResultCode resultCode, String message) {
        super(resultCode.getMessage());
        setErrorCode(resultCode.getCode());
    }

    public ServiceException(ResultCode resultCode, String message, Throwable cause) {
        super(resultCode.getMessage(), cause);
        setErrorCode(resultCode.getCode());
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }
}
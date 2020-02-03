package com.aircos.core;

import com.aircos.enums.ResultCode;

/**
 * 响应结果生成工具
 *
 * @author 龚国玮
 */
public class ResultGenerator {

    public static<T> Result<T> success(ResultCode resultCode) {
        return new Result()
                .setErrorCode(resultCode.getCode())
                .setErrorMessage(resultCode.getMessage())
                .setSuccess(true);
    }

    public static<T> Result<T> success(ResultCode resultCode, T result) {
        return new Result()
                .setErrorCode(resultCode.getCode())
                .setErrorMessage(resultCode.getMessage())
                .setResult(result)
                .setSuccess(true);
    }

    public static Result success() {
        return new Result()
                .setErrorCode(ResultCode.SUCCESS.getCode())
                .setErrorMessage(ResultCode.SUCCESS.getMessage())
                .setSuccess(true);
    }

    public static<T> Result<T> success(T result) {
        return new Result()
                .setErrorCode(ResultCode.SUCCESS.getCode())
                .setErrorMessage(ResultCode.SUCCESS.getMessage())
                .setResult(result)
                .setSuccess(true);
    }

    public static<T> Result<T> failure(ResultCode resultCode) {
        return new Result()
                .setErrorCode(resultCode.getCode())
                .setErrorMessage(resultCode.getMessage())
                .setSuccess(false);
    }

    public static<T> Result<T> failure(ResultCode resultCode, T result) {
        return new Result()
                .setErrorCode(resultCode.getCode())
                .setErrorMessage(resultCode.getMessage())
                .setResult(result)
                .setSuccess(false);
    }

    public static<T> Result<T> failure(String errorMessage) {
        return new Result()
                .setErrorCode(ResultCode.FAIL.getCode())
                .setErrorMessage(errorMessage)
                .setSuccess(false);
    }

    public static<T> Result<T> failure(String errorMessage, T result) {
        return new Result()
                .setErrorCode(ResultCode.FAIL.getCode())
                .setErrorMessage(errorMessage)
                .setResult(result)
                .setSuccess(false);
    }

    public static Result failure() {
        return new Result()
                .setErrorCode(ResultCode.FAIL.getCode())
                .setErrorMessage(ResultCode.FAIL.getMessage())
                .setSuccess(false);
    }

    public static<T> Result<T> failure(T result) {
        return new Result()
                .setErrorCode(ResultCode.FAIL.getCode())
                .setErrorMessage(ResultCode.FAIL.getMessage())
                .setResult(result)
                .setSuccess(false);
    }
}

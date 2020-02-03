package com.aircos.core;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

/**
 * 统一API响应结果封装
 *
 * @author 龚国玮
 */
public class Result<T> {

    @JsonProperty("current_time")
    private String currentTime;

    @JsonProperty("error_code")
    private int errorCode;

    @JsonProperty("error_message")
    private String errorMessage;

    private T result = (T) new HashMap();

    private Boolean success;

    public Result() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        this.currentTime = now.format(formatter);
    }

    public int getErrorCode() {
        return errorCode;
    }

    public Result setErrorCode(int errorCode) {
        this.errorCode = errorCode;
        return this;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public Result setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
        return this;
    }

    public T getResult() {
        return result;
    }

    public Result setResult(T result) {
        this.result = result;
        return this;
    }

    public Boolean getSuccess() {
        return success;
    }

    public Result setSuccess(Boolean success) {
        this.success = success;
        return this;
    }

    public String getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }

    @Override
    public String toString() {
        ObjectMapper mapper = new ObjectMapper();
        String result = "";
        try {
            result = mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return result;
    }
}

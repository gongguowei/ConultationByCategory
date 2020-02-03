package com.aircos.enums;

/**
 * 响应码
 *
 * @author 龚国玮
 */
public enum ResultCode {

    SUCCESS("操作成功", 0),
    FAIL("操作失败", -1),
    NOT_FOUND("接口不存在", 404),
    TOKEN_OUT("token已失效，请登录", 401),
    ACCOUNT_NOT_EXIST("账号不存在", 404),
    NO_PERMISSION("抱歉，您没有访问权限", 403),
    WRONG_USERNAME_OR_PASSWORD("用户名或密码错误", 500),
    ACCOUNT_DISABLED("账户被禁用，请联系管理员", 500),
    INTERNAL_ERROR("登录失败，其他内部错误", 500);

    private String message;
    private int code;

    ResultCode(String message, int code) {
        this.message = message;
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
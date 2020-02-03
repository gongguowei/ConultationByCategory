package com.aircos.constant;

/**
 * 通用配置
 *
 * @author 龚国玮
 */
public interface CommonConstant {

    /**
     * token参数头
     */
    String HEADER = "Authorization";

    /**
     * token分割
     */
    String TOKEN_SPLIT = "Bearer ";

    /**
     * jwt有效时间 7天
     */
    Long JWT_TIME = 7*24*60*60*1000L;

    /**
     * jwt 秘钥
     */
    String JWT_KEY = "CONSULTATION";

    /**
     * 自定义数据头
     */
    String AUTHORITIES = "authorization";

}

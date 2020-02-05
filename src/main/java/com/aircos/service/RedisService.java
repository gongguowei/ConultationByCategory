package com.aircos.service;

/**
 * Interface of Redis缓存
 *
 * @author gongguowei01@gmail.com
 * @since 2020-02-05
 */
public interface RedisService {

    /**
     * 根据手机号获取用户验证码
     *
     * @param key 手机号
     * @return 验证码
     */
    String getCodeVal(String key);
}

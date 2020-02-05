package com.aircos.service.impl;

import com.aircos.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * Service of Redis缓存服务
 *
 * @author gongguowei01@gmail.com
 * @since 2020-02-05
 */
@Service
public class RedisServiceImpl implements RedisService {
    @Autowired
    RedisTemplate redisTemplate;

    @Override
    public String getCodeVal(String key) {
        try {
            String value = redisTemplate.opsForValue().get(key).toString();
            return value;
        }catch (Exception e){
            return "";
        }
    }
}

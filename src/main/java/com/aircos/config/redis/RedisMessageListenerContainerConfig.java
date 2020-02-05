package com.aircos.config.redis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Slf4j
@Configuration
public class RedisMessageListenerContainerConfig {
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 处理乱码
     * @return
     */
    @Bean
    public RedisTemplate redisTemplateInit() {
        // key序列化
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        //val实例化
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());

        return redisTemplate;
    }

    /**
     * redis消息监听器配置.
     *
     * @return RedisMessageListenerContainer
     */
    @Bean
    public RedisMessageListenerContainer configRedisMessageListenerContainer(RedisConnectionFactory connectionFactory) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        // 设置Redis的连接工厂
        container.setConnectionFactory(connectionFactory);
        return container;
    }
}

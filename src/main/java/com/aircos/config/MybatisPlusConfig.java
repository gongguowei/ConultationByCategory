package com.aircos.config;

import com.aircos.core.mybatis.base.MySqlInjector;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author K
 * @since 2019/7/9
 */
@Configuration
public class MybatisPlusConfig {

    @Bean
    public MySqlInjector sqlInjector() {
        return new MySqlInjector();
    }
}

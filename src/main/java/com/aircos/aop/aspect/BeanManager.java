package com.aircos.aop.aspect;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan
public class BeanManager {
   /**
     * 配置数据库事务切面
     */
    @Bean
    public TransactionAspect buildTransactionAspect() {
        return new TransactionAspect();
    }
}


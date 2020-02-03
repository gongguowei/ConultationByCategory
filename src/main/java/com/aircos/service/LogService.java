package com.aircos.service;

import com.aircos.entity.dao.ProfessionLog;
import org.aspectj.lang.JoinPoint;
import org.springframework.scheduling.annotation.Async;

/**
 * Interface of 日志记录
 *
 * @author gongguowei01@gmail.com
 * @since 2020-02-03
 */
public interface LogService {


    /**
     * 面向切面：记录用户搜索专业
     *
     * @param userId
     * @param requestId
     * @param joinPoint
     */
    @Async
    void createProfessionLog(Integer userId, String requestId, JoinPoint joinPoint);
}

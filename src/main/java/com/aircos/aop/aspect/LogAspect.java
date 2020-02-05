package com.aircos.aop.aspect;

import com.aircos.entity.dao.User;
import com.aircos.service.LogService;
import com.aircos.service.UserService;
import com.aircos.util.IpUtil;
import com.aircos.util.RequestHolder;
import com.aircos.util.SecurityUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * AOP通知/增强: 专业搜索
 *
 * @author gongguowei01@gmail.com
 * @since 2020-02-02
 */
@Component
@Aspect
@Slf4j
public class LogAspect {

    @Resource
    private LogService logService;

    @Resource
    private UserService userService;

    private long currentTime = 0L;

    /**
     * 配置切入点
     */
    @Pointcut("@annotation(com.aircos.aop.QueryProfessionLogPoint)")
    public void logPointcut() {
        // 该方法无方法体,主要为了让同类中其他方法使用此切入点
    }

    /**
     * 配置环绕通知,使用在具体方法上注册的切入点
     *
     * @param joinPoint 方法的执行
     */
    @Before("logPointcut()")
    public Object logBefore(JoinPoint joinPoint) throws Throwable {
        User loginUser = userService.findByPhone(SecurityUtils.getPhone());

        Object result = null;
        currentTime = System.currentTimeMillis();
        result = joinPoint.getThis();

        logService.createProfessionLog(loginUser.getId(), IpUtil.getIP(RequestHolder.getHttpServletRequest()), joinPoint);

        return result;
    }
}
package com.aircos.service.impl;

import com.aircos.entity.dao.ProfessionLog;
import com.aircos.mapper.ProfessionLogMapper;
import com.aircos.service.LogService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Service of 日志记录
 *
 * @author gongguowei01@gmail.com
 * @since 2020-02-02
 */
@Service
@Slf4j
public class LogServiceImpl implements LogService {

    private final ProfessionLogMapper professionLogMapper;

    @Autowired
    public LogServiceImpl(ProfessionLogMapper professionLogMapper) {
        this.professionLogMapper = professionLogMapper;
    }

    @Override
    public void createProfessionLog(Integer userId, String requestId, JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();

        Method method = signature.getMethod();
        com.aircos.aop.QueryProfessionLogPoint queryProfessionLog = method.getAnnotation(com.aircos.aop.QueryProfessionLogPoint.class);

        String queryParam = Arrays.toString(joinPoint.getArgs());
        //这里是将特殊字符换为aa字符串," "代表直接去掉
        String after = " ";
        String regEx="[\n`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。， 、？]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(queryParam);

        ProfessionLog professionLog = new ProfessionLog();
        professionLog.setUserId(userId);
        professionLog.setRequestIp(requestId);
        professionLog.setDescription(queryProfessionLog.value());
        professionLog.setParam(m.replaceAll(after).trim());

        professionLogMapper.insert(professionLog);
    }
}

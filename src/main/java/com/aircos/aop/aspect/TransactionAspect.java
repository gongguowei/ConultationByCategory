package com.aircos.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import javax.annotation.Priority;

@Aspect
@Priority(1)
@Slf4j
public class TransactionAspect {

    @Autowired(required = false)
    private DataSourceTransactionManager transactionManager; //spring中配置的事务管理器
    private DefaultTransactionDefinition definition;

    public TransactionAspect() {
        definition = new DefaultTransactionDefinition();
        definition.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
    }

    @Around("@annotation(com.aircos.aop.Transaction))") //标明注解的路径 和通知方式为around
    public Response watch(ProceedingJoinPoint joinPoint) {
        TransactionStatus status = transactionManager.getTransaction(definition);
        try {
            Response response = (Response)joinPoint.proceed();
            if (response.status == 0) {
                transactionManager.commit(status);
            } else {
                transactionManager.rollback(status);
            }
            return response;
        } catch (Throwable throwable) {
            transactionManager.rollback(status);
            return new Response(1, throwable.getMessage(), null);
        }
    }

    public class Response<T> {

        /* 状态码，0代表成功，非0代表失败 */
        public int status;
        /* 处理信息 */
        public String message;
        /* 处理结果 */
        public T result;

        public Response(int status, String message, T result) {
            this.status = status;
            this.message = message;
            this.result = result;
        }
    }
}

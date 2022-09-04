package com.jkxy.car.api.common.aspect;

import com.jkxy.car.api.common.annotation.LogAuth;
import com.jkxy.car.api.pojo.AuthAble;
import com.jkxy.car.api.service.UserService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoginAspect {
    @Autowired
    UserService userService;
    @Pointcut("@annotation(com.jkxy.car.api.common.annotation.LogAuth)")
    public void setLogService() {
    }

    @Before("setLogService() && @annotation(logAuth)")
    public void userVinRelationCheck(JoinPoint joinPoint, LogAuth logAuth) throws Exception {
        Object[] args = joinPoint.getArgs();
        AuthAble header = null;
        for (Object arg : args) {
            if (arg instanceof AuthAble){
                header = (AuthAble) arg;
            }
        }
        if (header != null){
            userService.login(header.getPhone(), header.getPwd());
            return;
        }
        throw new RuntimeException("认证失败");
    }
}

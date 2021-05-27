package com.zerent.webpra.aop;

import com.zerent.webpra.annotation.Encryption;
import com.zerent.webpra.model.vo.ResultVo;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class EncryptionAop {

    @Around("@annotation(com.zerent.webpra.annotation.Encryption)")
    public ResultVo encryptPoint(ProceedingJoinPoint joinPoint) throws Throwable {
        ResultVo resultVo = (ResultVo) joinPoint.proceed();
        //获取注解
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        Encryption annotation = method.getAnnotation(Encryption.class);

        if(annotation != null){
            resultVo.setData("encrypt data");
        }
        return resultVo;
    }
}

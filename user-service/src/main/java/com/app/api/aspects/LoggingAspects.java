package com.app.api.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author Anish Panthi
 */
@Component
@Aspect
@Slf4j
public class LoggingAspects {

    @Pointcut("within(com.app.api..*)"
            + "&& !@annotation(com.app.api.annotation.EnableEscapeForCGLibProxy)"
            + "&& !@target(com.app.api.annotation.EnableEscapeForCGLibProxy)")
    public void logExceptionForAllMethods() {}

    @AfterThrowing(pointcut = "logExceptionForAllMethods()", throwing = "exception")
    public void afterThrowingException(JoinPoint joinPoint, Exception exception) {
        String errorMessage = "Exception Occurred:: ";
        errorMessage += " -- Class:: " + joinPoint.getSignature().getDeclaringTypeName();
        errorMessage += " -- Method:: " + joinPoint.getSignature().getName();
        errorMessage += " -- Root Cause:: " + exception;
        errorMessage += " -- FullStackTrace:: " + exception.fillInStackTrace();

        log.error("{}", errorMessage);
    }
}

package com.stackroute.springRestfulWithMongo.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Pointcut("execution(* com.stackroute.springRestfulWithMongo.controller.CustomerController.*(..))")
    public void controllerMethods() {
    }


    @Before("controllerMethods()")
    public void beforeAdvice(JoinPoint joinpoint) {
        logger.info("*******@Before********");
        logger.debug("Method Name{}", joinpoint.getSignature().getName());
        logger.debug("Method Args{}", Arrays.toString(joinpoint.getArgs()));
        logger.info("*******************");
    }


    @After("controllerMethods()")
    public void afterAdvice(JoinPoint joinpoint) {
        logger.info("*******@After********");
        logger.debug("Method Name{}", joinpoint.getSignature().getName());
        logger.debug("Method Args{}", Arrays.toString(joinpoint.getArgs()));
        logger.info("*******************");
    }


    @AfterThrowing(value = "controllerMethods()", throwing = "error")
    public void afterAdvice(JoinPoint joinpoint, Throwable error) {
        logger.info("*******@AfterThrowing********");
        logger.debug("Method Name{}", joinpoint.getSignature().getName());
        logger.debug("Method Args{}", Arrays.toString(joinpoint.getArgs()));
        logger.debug("Exception:{}", error);
        logger.info("*******************");
    }

    @AfterReturning(value = "controllerMethods()", returning = "result")
    public void afterAdvice(JoinPoint joinpoint, Object result) {
        logger.info("*******@AfterReturning********");
        logger.debug("Method Name{}", joinpoint.getSignature().getName());
        logger.debug("Method Args{}", Arrays.toString(joinpoint.getArgs()));
        logger.debug("Exception:{}", result);
        logger.info("*******************");
    }


}
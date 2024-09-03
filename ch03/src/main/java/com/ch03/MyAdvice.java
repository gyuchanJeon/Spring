package com.ch03;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAdvice {

    // 포인트컷
    @Pointcut("execution(void com.ch03.MyService.insert())")
    public void insertPointcut(){} // 핵심관심을 가리키는 내용이 없는 메서드

    @Pointcut("execution(void com.ch03.MyService.select(..))")
    public void selectPointcut(){}

    @Before("insertPointcut() || selectPointcut()")
    public void beforeAdvice() {
        System.out.println("부가기능 - beforeAdvice...");
    }

    @After("insertPointcut()")
    public void afterAdvice() {
        System.out.println("부가기능 - afterAdvice...");
    }

    @AfterReturning("insertPointcut()")
    public void afterReturningAdvice() {
        System.out.println("부가기능 - afterReturningAdvice...");
    }

    @Around("insertPointcut()")
    public void aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("부가기능 - aroundAdvice...1");
        pjp.proceed(); // 핵심관심
        System.out.println("부가기능 - aroundAdvice...2");
    }

    @AfterThrowing("selectPointcut()")
    public void afterThrowingAdvice() {
        System.out.println("부가기능 - afterThrowingAdvice...");
    }

}

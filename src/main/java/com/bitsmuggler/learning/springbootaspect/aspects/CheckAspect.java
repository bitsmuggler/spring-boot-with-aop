package com.bitsmuggler.learning.springbootaspect.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CheckAspect {

  @Before("@annotation(com.bitsmuggler.learning.springbootaspect.aspects.CheckSomething)")
  public void checkSomethingBefore() {
    System.out.println("Before execution");
  }

  @AfterReturning(pointcut = "@annotation(com.bitsmuggler.learning.springbootaspect.aspects.CheckSomething)")
  public void checkSomethingAfter(JoinPoint joinPoint) {
    System.out.println("After execution");
  }

  @AfterThrowing(pointcut = "@annotation(com.bitsmuggler.learning.springbootaspect.aspects.CheckSomething)", throwing = "ex")
  public void checkSomethingAfterThrowingAnException(Exception ex) {
    System.out.println("After throwing an exception: " + ex);
  }

  @Around("@annotation(com.bitsmuggler.learning.springbootaspect.aspects.CheckSomething)")
  public Object checkSomethingAround(ProceedingJoinPoint joinPoint) throws Throwable {
    System.out.println("Before in Around execution");
    Object result = joinPoint.proceed();
    System.out.println("After in arround execution");
    return result;
  }

}

package com.bitsmuggler.learning.springbootaspect.aspects;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
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

  @After("@annotation(com.bitsmuggler.learning.springbootaspect.aspects.CheckSomething)")
  public void checkSomethingAfter() {
    System.out.println("Before execution");
  }


  @Around("@annotation(com.bitsmuggler.learning.springbootaspect.aspects.CheckSomething)")
  public void checkSomethingAround(ProceedingJoinPoint joinPoint) throws Throwable {
    System.out.println("Around execution");
    joinPoint.proceed();
  }
}

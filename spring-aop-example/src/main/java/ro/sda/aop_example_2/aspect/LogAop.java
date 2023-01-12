package ro.sda.aop_example_2.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import ro.sda.aop_example_2.annotations.LoggerAudit;

import java.lang.reflect.Method;

@Aspect
@Component
public class LogAop {

  @AfterReturning(pointcut = "@annotation(ro.sda.aop_example_2.annotations.LoggerAudit)")
  private static void log(JoinPoint joinPoint) {

    MethodSignature signature = (MethodSignature) joinPoint.getSignature();
    Method method = signature.getMethod();
    String methodMessage = method.getAnnotation(LoggerAudit.class).value();

    System.out.println("Method " + method.getName() + "  returned with message: " +  methodMessage);


  }

}
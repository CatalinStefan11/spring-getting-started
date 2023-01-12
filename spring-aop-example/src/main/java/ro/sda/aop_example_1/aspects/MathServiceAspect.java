package ro.sda.aop_example_1.aspects;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * -> Join point: 
 * A join-point is a candidate point in the Program Execution of the application where an aspect can be plugged in.
 * This point could be a method being called, an exception being thrown, or even a field being modified. 
 * These are the points where your aspect’s code can be inserted into the normal flow of your application to add new behavior.
 * In Spring AOP a join point is always the execution of a method.
 *
 * Advice:  Advices are actions taken for a particular join point. 
 * This is an object which includes API invocations to the system-wide concerns representing the action to perform at a join-point specified by a point.
 * 
 * Aspect: An aspect is a class that implements enterprise application concerns that cut across multiple classes, such as transaction management. 
 *
 * Pointcut: A pointcut defines at what join-points, the associated Advice should be applied. 
 * Advice can be applied at any join-point supported by the AOP framework. 
 * Of course, you don’t want to apply all of your aspects at all the possible join-points. 
 * Pointcuts allow you to specify where you want your advice to be applied.
 *
 * Explanation using Restaurant Analogy: Source by https://coderanch.com/t/485525/frameworks/Difference-Joint-Point-Point-Cut
 *
 * When you go out to a restaurant, you look at a menu and see several options to choose from. You can order one or more of the items on the menu. 
 * But until you actually order them, they are just "opportunities to dine". Once you place the order and the waiter brings it to your table, it's a meal.
 *
 * Join-points are options on the menu and Pointcuts are items you select.
 *
 * A Join-point is an opportunity within code for you to apply an aspect...just an opportunity. 
 * Once you take that opportunity and select one or more join-points and apply an aspect to them, you've got a pointcut.
 */

@Aspect
public class MathServiceAspect {

  @Before("execution(* ro.sda.aop_example.services.MathService.add(..))")
  public void before() {
    System.out.println("Method add() will be called!");
  }

  @After("execution(* ro.sda.aop_example.services.MathService.add(..))")
  public void after() {
    System.out.println("AFTER");
  }

  @AfterReturning("execution(* ro.sda.aop_example.services.MathService.add(..))")
  public void afterReturning() {
    System.out.println("AFTER RETURNING");
  }

  @AfterThrowing("execution(* ro.sda.aop_example.services.MathService.add(..))")
  public void afterThrowing() {
    System.out.println("AFTER THROWING");
  }
}
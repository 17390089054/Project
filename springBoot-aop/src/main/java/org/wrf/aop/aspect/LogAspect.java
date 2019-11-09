package org.wrf.aop.aspect;

import java.lang.reflect.Method;
import java.util.Arrays;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.wrf.aop.annotation.Action;

//@Aspect
//@Component
public class LogAspect {

	@Pointcut("@annotation(org.wrf.aop.annotation.Action)")
	public void log() {
		System.out.println("打印一条Log日志");
	}

	/**
	 * 前置通知
	 */
	@Before("log()")
	public void doBeforeController(JoinPoint joinPoint) {
		System.out.println("before.....");
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();
		Action action = method.getAnnotation(Action.class);
		System.out.println("Signature--->"+joinPoint.getSignature());
		System.out.println("Kind--->"+joinPoint.getKind());
		System.out.println("SourceLocation-->"+joinPoint.getSourceLocation());
		System.out.println("args--->"+Arrays.asList(joinPoint.getArgs()));
		System.out.println("target-->"+joinPoint.getTarget().toString());
		System.out.println("actionName ---> " + action.value());


	}

	/**
	 * 后置通知
	 */
	@AfterReturning(pointcut = "log()", returning = "retValue")
	public void doAfterController(JoinPoint joinPoint, Object retValue) {
		System.out.println("retValue is:" + retValue);
	}


	@After("log()")
	public  void exitMethod(JoinPoint joinPoint){
		System.out.println("after.......");
		System.out.println("Signature--->"+joinPoint.getSignature());
		System.out.println("Kind--->"+joinPoint.getKind());
		System.out.println("SourceLocation-->"+joinPoint.getSourceLocation());
		System.out.println("args--->"+Arrays.asList(joinPoint.getArgs()));
		System.out.println("target-->"+joinPoint.getTarget().toString());
	}


}

package com.atsicau.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

//告诉Spring当前类是一个切面类
@Aspect
public class LogAspects {
	//抽取公共的切入点表达式
	//1.本类引用
	//2.其他的切面引用
	@Pointcut("execution(public int com.atsicau.aop.MathCalculator.*(..))")
	public void pointCut(){
		
	}

	//@Before 在目标方法之前切入，切入点表达式(指定在哪个方法切入)
	@Before(value = "pointCut()")
	public void logStart(JoinPoint joinPoint){
		Object[] obj = joinPoint.getArgs();
		System.out.println(" "+joinPoint.getSignature().getName()+" 运行。。。@Before{"+Arrays.asList(obj)+"}");
	}
	//@After 在目标方法之后切入，
	@After("com.atsicau.aop.LogAspects.pointCut()")
	public void logEnd(JoinPoint joinPoint){
		System.out.println(" "+joinPoint.getSignature().getName()+" 结束。。。。。@After");
	}
	@AfterReturning(value = "pointCut()",returning = "result")
	public void logRuturn(JoinPoint joinPoint,Object result){
		System.out.println(" "+joinPoint.getSignature().getName()+" 正常返回。。。。@AfterReturning {"+result+"}");
	}
	//JoinPoint一定要出现在参数列表的第一位
	@AfterThrowing(value="pointCut()",throwing="exception")
	public void logException(	JoinPoint joinPoint , Exception exception){
		System.out.println(" "+joinPoint.getSignature().getName()+" 除法异常。。。。@AfterThrowing {"+exception+"}");
	}
}

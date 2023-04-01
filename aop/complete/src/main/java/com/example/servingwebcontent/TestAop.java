package com.example.servingwebcontent;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TestAop {
	@Pointcut("execution(* com.example.servingwebcontent.*.*(..))")
	public void checkAdd(){	}

	@Around("execution(* com.example.servingwebcontent.*.*(..))")
	public Object checkUser(ProceedingJoinPoint pp){
		System.out.println("**************The System is Searching Information For You****************");
		Object o = null;
		System.out.println(pp.getSignature()); // String com.example.servingwebcontent.GreetingController.greeting(String,Model)
		try {
			o = pp.proceed();
		} catch (Throwable e ) {

		}
		System.out.println("**************The System is Searching Information For You end****************");
		return o;
	}

	@Before("checkAdd()")
	public void beforeAdd(){
		System.out.println(">>>>>>>>　增长用户--检查ing..........");
	}
	
	@After("checkAdd()")
	public void afterAdd(){
		System.out.println(">>>>>>>>　增长用户--检查完毕！未发现异常!..........");
	}
}
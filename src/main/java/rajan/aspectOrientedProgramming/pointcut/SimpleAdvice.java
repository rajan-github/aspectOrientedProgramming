package rajan.aspectOrientedProgramming.pointcut;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * This is around advice implementation using MethodInterceptor which writes
 * message after foo executed and also before foo method executes.
 * 
 * @author rajan
 *
 */
public class SimpleAdvice implements MethodInterceptor {

	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println(">> Invoking " + invocation.getMethod().getName());
		Object retVal = invocation.proceed();
		System.out.println("Done");
		return retVal;
	}

}

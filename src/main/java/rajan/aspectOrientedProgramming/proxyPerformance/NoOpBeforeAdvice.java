package rajan.aspectOrientedProgramming.proxyPerformance;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class NoOpBeforeAdvice implements MethodBeforeAdvice {

	public void before(Method method, Object[] arg1, Object target) throws Throwable {
		// no operation
	}

}

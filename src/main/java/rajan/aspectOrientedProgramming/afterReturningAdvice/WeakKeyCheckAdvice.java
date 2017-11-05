package rajan.aspectOrientedProgramming.afterReturningAdvice;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class WeakKeyCheckAdvice implements AfterReturningAdvice {

	public void afterReturning(Object returnValue, Method method, Object[] arg2, Object target) throws Throwable {
		if ((target instanceof KeyGenerator) && ("getKey".equals(method.getName()))) {
			long key = ((Long) returnValue).longValue();
			if (key == KeyGenerator.WEEK_KEY) {
				throw new SecurityException("Key generator generated a weak key. Try again");
			}
		}
	}

}

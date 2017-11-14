package rajan.aspectOrientedProgramming.proxyPerformance;

import java.lang.reflect.Method;

import org.springframework.aop.support.StaticMethodMatcherPointcut;

public class TestPointcut extends StaticMethodMatcherPointcut {

	public boolean matches(Method method, Class<?> cls) {
		return "advised".equals(method.getName());
	}

}

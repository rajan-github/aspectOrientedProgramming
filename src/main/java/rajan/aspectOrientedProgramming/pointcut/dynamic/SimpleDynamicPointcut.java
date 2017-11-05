package rajan.aspectOrientedProgramming.pointcut.dynamic;

import java.lang.reflect.Method;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.DynamicMethodMatcherPointcut;

public class SimpleDynamicPointcut extends DynamicMethodMatcherPointcut {

	public boolean matches(Method method, Class<?> arg1) {
		System.out.println("static check for " + method.getName());
		return "foo".equals(method.getName());
	}

	public boolean matches(Method method, Class<?> arg1, Object... arg2) {
		System.out.println("Dynamic check for " + method.getName());
		int x = ((Integer) arg2[0]).intValue();
		return x != 100;
	}

	public ClassFilter getClassFilter() {
		return new ClassFilter() {

			public boolean matches(Class<?> cls) {
				return cls == SampleBean.class;
			}
		};
	}

}

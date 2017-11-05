package rajan.aspectOrientedProgramming.pointcut;

import java.lang.reflect.Method;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcut;

public class SimpleStaticPointcut extends StaticMethodMatcherPointcut {

	public boolean matches(Method method, Class<?> arg1) {
		return "foo".equals(method.getName());
	}

	@Override
	public ClassFilter getClassFilter() {
		return new ClassFilter() {

			public boolean matches(Class<?> cls) {
				return cls == BeanOne.class;
			}
		};
	}

}

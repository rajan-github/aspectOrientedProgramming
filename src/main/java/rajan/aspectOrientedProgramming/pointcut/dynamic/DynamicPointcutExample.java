package rajan.aspectOrientedProgramming.pointcut.dynamic;

import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

import rajan.aspectOrientedProgramming.pointcut.SimpleAdvice;

public class DynamicPointcutExample {
	public static void main(String[] args) {
		SampleBean target = new SampleBean();
		Advisor advisor = new DefaultPointcutAdvisor(new SimpleDynamicPointcut(), new SimpleAdvice());
		ProxyFactory pf = new ProxyFactory();
		pf.addAdvisor(advisor);
		pf.setTarget(target);

		SampleBean proxy = (SampleBean) pf.getProxy();
		proxy.foo(100);
		proxy.foo(101);
		proxy.foo(99);
		proxy.bar();
		proxy.bar();
		proxy.bar();
	}
}

package rajan.aspectOrientedProgramming.pointcut.nameMatching;

import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;

import rajan.aspectOrientedProgramming.pointcut.SimpleAdvice;

public class NamePointcutExample {
	public static void main(String[] args) {
		NameBean target = new NameBean();
		NameMatchMethodPointcut pc = new NameMatchMethodPointcut();
		pc.addMethodName("foo");
		pc.addMethodName("bar");
		Advisor advisor = new DefaultPointcutAdvisor(pc, new SimpleAdvice());

		ProxyFactory pf = new ProxyFactory();
		pf.addAdvisor(advisor);
		pf.setTarget(target);
		NameBean proxy = (NameBean) pf.getProxy();
		proxy.foo();
		proxy.foo(100);
		proxy.bar();
		proxy.bar();
	}
}

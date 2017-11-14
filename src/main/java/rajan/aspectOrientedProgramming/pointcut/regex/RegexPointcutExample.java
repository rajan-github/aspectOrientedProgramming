package rajan.aspectOrientedProgramming.pointcut.regex;

import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.JdkRegexpMethodPointcut;

import rajan.aspectOrientedProgramming.pointcut.SimpleAdvice;

public class RegexPointcutExample {
	public static void main(String[] args) {
		RegexBean target = new RegexBean();
		JdkRegexpMethodPointcut pc = new JdkRegexpMethodPointcut();
		pc.setPattern(".*foo.*");
		Advisor advisor = new DefaultPointcutAdvisor(pc, new SimpleAdvice());

		ProxyFactory pf = new ProxyFactory();
		pf.addAdvisor(advisor);
		pf.setTarget(target);
		RegexBean proxy = (RegexBean) pf.getProxy();
		proxy.foo1();
		proxy.foo2();
		proxy.bar();
	}
}

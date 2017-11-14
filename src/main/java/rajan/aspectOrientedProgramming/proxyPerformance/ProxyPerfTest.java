package rajan.aspectOrientedProgramming.proxyPerformance;

import org.springframework.aop.Advisor;
import org.springframework.aop.framework.Advised;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

public class ProxyPerfTest {

	public static void main(String[] args) {
		SimpleBean target = new DefaultSimpleBean();
		Advisor advisor = new DefaultPointcutAdvisor(new TestPointcut(), new NoOpBeforeAdvice());
		runCglibTests(advisor, target);
		runCglibFrozenTests(advisor, target);
		runJdkTests(advisor, target);
	}

	private static void runCglibTests(Advisor advisor, SimpleBean target) {
		ProxyFactory pf = new ProxyFactory();
		pf.setProxyTargetClass(true);
		pf.setTarget(target);
		pf.addAdvisor(advisor);

		SimpleBean proxy = (SimpleBean) pf.getProxy();
		System.out.println("Running CGLIB(Standard) Tests");
		test(proxy);
	}

	private static void runCglibFrozenTests(Advisor advisor, SimpleBean target) {
		ProxyFactory pf = new ProxyFactory();
		pf.setProxyTargetClass(true);
		pf.addAdvisor(advisor);
		pf.setTarget(target);
		pf.setFrozen(true);

		SimpleBean proxy = (SimpleBean) pf.getProxy();
		System.out.println("Running CGLIB(Frozen) Tests");
		test(proxy);
	}

	private static void runJdkTests(Advisor advisor, SimpleBean bean) {
		ProxyFactory pf = new ProxyFactory();
		pf.setTarget(bean);
		pf.addAdvisor(advisor);
		pf.setInterfaces(new Class[] { SimpleBean.class });
		SimpleBean proxy = (SimpleBean) pf.getProxy();
		System.out.println("Running Jdk Tests");
		test(proxy);
	}

	private static void test(SimpleBean bean) {
		long before = 0;
		long after = 0;
		System.out.println("Testing advised method");
		before = System.currentTimeMillis();
		for (int i = 0; i < 500000; i++) {
			bean.advised();
		}
		after = System.currentTimeMillis();
		System.out.println("Took " + (after - before) + " ms");

		System.out.println("Testing Unadvised method");
		before = System.currentTimeMillis();
		for (int i = 0; i < 500000; i++) {
			bean.unadvised();
		}
		after = System.currentTimeMillis();
		System.out.println("Took " + (after - before) + " ms");

		System.out.println("Testing equals() method");
		before = System.currentTimeMillis();
		for (int i = 0; i < 500000; i++) {
			bean.equals(bean);
		}
		after = System.currentTimeMillis();
		System.out.println("Took " + (after - before) + " ms");

		System.out.println("Testing hashcode() method");
		before = System.currentTimeMillis();
		for (int i = 0; i < 500000; i++) {
			bean.hashCode();
		}
		after = System.currentTimeMillis();
		System.out.println("Took " + (after - before) + " ms");

		Advised advised = (Advised) bean;
		System.out.println("Testing Advised.getProxyTargetClass() method");
		before = System.currentTimeMillis();
		for (int i = 0; i < 500000; i++) {
			advised.getTargetClass();
		}
		after = System.currentTimeMillis();
		System.out.println("Took " + (after - before) + " ms");

		System.out.println(">>>\n");
	}
}

package rajan.aspectOrientedProgramming.afterReturningAdvice;

import org.springframework.aop.framework.ProxyFactory;

public class AfterAdviceExample {
	public static void main(String[] args) {
		KeyGenerator keyGen = getKeyGenerator();
		for (int i = 0; i < 10; i++) {
			try {
				System.out.println("Key: " + keyGen.getKey());
			} catch (SecurityException ex) {
				System.out.println("Weak key generated!");
			}
		}
	}

	private static KeyGenerator getKeyGenerator() {
		KeyGenerator target = new KeyGenerator();
		ProxyFactory pf = new ProxyFactory();
		pf.addAdvice(new WeakKeyCheckAdvice());
		pf.setTarget(target);
		return (KeyGenerator) pf.getProxy();
	}
}

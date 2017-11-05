package rajan.aspectOrientedProgramming.throwsAdvice;

import java.lang.reflect.Method;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.aop.framework.ProxyFactory;

public class SimpleThrowAdvice implements ThrowsAdvice {
	public static void main(String[] args) {
		ErrorBean errorBean = new ErrorBean();
		ProxyFactory pf = new ProxyFactory();
		pf.setTarget(errorBean);
		pf.addAdvice(new SimpleThrowAdvice());
		ErrorBean proxy = (ErrorBean) pf.getProxy();
		try {
			proxy.errorProneMethod();
		} catch (Exception ignored) {

		}

		try {
			proxy.otherErrorProneMethod();
		} catch (Exception ignored) {

		}
	}

	public void afterThrowing(Exception ex) throws Throwable {
		System.out.println("***");
		System.out.println("Generic exception captured");
		System.out.println("Caught: " + ex.getClass().getName());
		System.out.println("***\n");
	}

	public void afterThrowing(Method method, Object[] args, Object target, IllegalArgumentException ex) {
		System.out.println("***");
		System.out.println("IllegalArgumentException Capture");
		System.out.println("caught: " + ex.getClass().getName());
		System.out.println("Method: "+method.getName());
		System.out.println("***\n");
	}
}

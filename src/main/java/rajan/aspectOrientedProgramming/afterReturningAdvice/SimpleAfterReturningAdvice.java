package rajan.aspectOrientedProgramming.afterReturningAdvice;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.framework.ProxyFactory;

import rajan.aspectOrientedProgramming.MessageWriter;

public class SimpleAfterReturningAdvice implements AfterReturningAdvice {
	public static void main(String[] args) {
		MessageWriter target = new MessageWriter();
		ProxyFactory pf = new ProxyFactory();
		pf.addAdvice(new SimpleAfterReturningAdvice());
		pf.setTarget(target);
		MessageWriter proxy = (MessageWriter) pf.getProxy();
		proxy.writeMessage();
	}

	public void afterReturning(Object returnValue, Method method, Object[] arg2, Object arg3) throws Throwable {
		System.out.println("");
		System.out.println("After method: " + method.getName());
	}

}

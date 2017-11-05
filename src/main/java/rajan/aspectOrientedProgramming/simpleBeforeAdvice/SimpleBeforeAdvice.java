package rajan.aspectOrientedProgramming.simpleBeforeAdvice;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;

import rajan.aspectOrientedProgramming.MessageWriter;

public class SimpleBeforeAdvice implements MethodBeforeAdvice {
	public static void main(String[] args) {
		MessageWriter target = new MessageWriter();
		ProxyFactory pf = new ProxyFactory();
		pf.addAdvice(new SimpleBeforeAdvice());
		pf.setTarget(target);
		MessageWriter proxy = (MessageWriter) pf.getProxy();
		proxy.writeMessage();
	}

	public void before(Method method, Object[] arg1, Object arg2) throws Throwable {
		System.out.println("Before method: " + method.getName());

	}

}

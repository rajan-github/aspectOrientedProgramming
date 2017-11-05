package rajan.aspectOrientedProgramming.beforeAdvice;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class SecurityAdvice implements MethodBeforeAdvice {
	private SecurityManager securityManager;

	public SecurityAdvice() {
		super();
		this.securityManager = new SecurityManager();
	}

	public void before(Method method, Object[] arg1, Object arg2) throws Throwable {
		UserInfo user = securityManager.getLoggedOnUser();
		if (user == null) {
			System.out.println("No user authenticated");
			throw new SecurityException("You must login before attempting to invoke the method: " + method.getName());
		} else if ("chris".equals(user.getUserName())) {
			System.out.println("Logged in user is chris- Okay!");
		} else {
			System.out.println("Logged in user is: " + user.getUserName() + " is not allowed to access to method "
					+ method.getName());
			throw new SecurityException("You must login before attempting to invoke the method: " + method.getName());
		}
	}
}

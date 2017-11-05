package rajan.aspectOrientedProgramming.beforeAdvice;

import org.springframework.aop.framework.ProxyFactory;

public class SecurityExample {
	public static void main(String args[]) {
		SecurityManager mgr = new SecurityManager();
		SecureBean bean = getSecureBean();
		mgr.login("chris", "pwd");
		bean.writeSecureMessage();
		mgr.logout();

		try {
			mgr.login("Invalid user", "pwd");
			bean.writeSecureMessage();
			mgr.logout();
		} catch (SecurityException ex) {
			System.out.println(ex.getMessage());
		} finally {
			mgr.logout();
		}
	}

	private static SecureBean getSecureBean() {
		SecureBean target = new SecureBean();
		SecurityAdvice advice = new SecurityAdvice();
		ProxyFactory pf = new ProxyFactory();
		pf.addAdvice(advice);
		pf.setTarget(target);
		return (SecureBean) pf.getProxy();
	}
}

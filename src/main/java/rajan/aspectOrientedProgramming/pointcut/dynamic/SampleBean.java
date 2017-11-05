package rajan.aspectOrientedProgramming.pointcut.dynamic;

/**
 * For this example we want to advise foo method but unlike static advice we
 * want to advice foo when input is not equals to 100.
 * 
 * @author rajan
 *
 */
public class SampleBean {
	public void foo(int x) {
		System.out.println("Invoked foo() with: " + x);
	}

	public void bar() {
		System.out.println("Invoked bar()");
	}
}

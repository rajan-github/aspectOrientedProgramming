package rajan.aspectOrientedProgramming.pointcut.annotationMatching;

public class SampleAnnotationBean {
	@AdviceRequired
	public void foo(int x) {
		System.out.println("Invoked foo with: " + x);
	}

	@AdviceRequired
	public void bar() {
		System.out.println("Invoked bar");
	}
}

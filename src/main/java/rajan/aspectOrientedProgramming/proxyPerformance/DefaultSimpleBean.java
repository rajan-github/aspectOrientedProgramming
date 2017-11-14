package rajan.aspectOrientedProgramming.proxyPerformance;

public class DefaultSimpleBean implements SimpleBean {
	private long dummy = 0;

	public long getDummy() {
		return dummy;
	}

	public void setDummy(long dummy) {
		this.dummy = dummy;
	}

	public void advised() {
		dummy = System.currentTimeMillis();
	}

	public void unadvised() {
		dummy = System.currentTimeMillis();
	}

}

package rajan.aspectOrientedProgramming.afterReturningAdvice;

import java.util.Random;

public class KeyGenerator {
	protected static final long WEEK_KEY = 0xFFFFFFF0000000L;
	protected static final long STRONG_KEY = 0xACDF03F590AE56L;

	private Random random = new Random();

	public long getKey() {
		int x = random.nextInt(3);
		if (x == 1) {
			return WEEK_KEY;
		}
		return STRONG_KEY;
	}

}

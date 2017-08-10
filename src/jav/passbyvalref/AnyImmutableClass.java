package jav.passbyvalref;

public class AnyImmutableClass {
	private final String x;
	private final String y;
	
	AnyImmutableClass(String x, String y) {
		this.x = x;
		this.y = y;
	}

	String getX() {
		return x;
	}

	String getY() {
		return y;
	}
}
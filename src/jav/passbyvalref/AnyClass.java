package jav.passbyvalref;

public class AnyClass implements Cloneable{
	private int a;
	private int b;
	
	public AnyClass(int a, int b) {
		this.a = a;
		this.b = b;
	}
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	public int getB() {
		return b;
	}
	public void setB(int b) {
		this.b = b;
	}

	@Override
	protected AnyClass clone() throws CloneNotSupportedException {
		return (AnyClass) super.clone();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + a;
		result = prime * result + b;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AnyClass other = (AnyClass) obj;
		if (a != other.a)
			return false;
		if (b != other.b)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "AnyClass [a=" + a + ", b=" + b + "]";
	}
}
class Test {
	public static void main(String[] args) throws CloneNotSupportedException {
		AnyClass obj = new AnyClass(1, 2);
		System.out.println(obj);
		AnyClass clone = obj.clone();
		System.out.println(clone);
	}
}
package jav.passbyvalref;

public class JavaPassbyValTest{
	void badSwap(int a, int b){
		int temp = a;
		a = b;
		b = temp;
	}
	void badSwap(AnyClass a, AnyClass b){
		a.setA(a);
		AnyClass temp = a;
		a = b;
		b = temp;
	}
}
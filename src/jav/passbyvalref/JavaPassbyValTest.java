package jav.passbyvalref;

public class JavaPassbyValTest{
	void badSwap(int a, int b){
		int temp = a;
		a = b;
		b = temp;
	}
	void badSwap(AnyClass a, AnyClass b){
		a.setA(a.getA()+100);
		a.setB(a.getB()+100);
		AnyClass temp = a;
		a = b;
		b = temp;
	}
}
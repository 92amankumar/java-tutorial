package jav.passbyvalref;

import org.junit.Test;
import static org.junit.Assert.*;

public class ReferenceTest{
	
	int a = 2;
	int b = 5;
	JavaPassbyValTest ref = new JavaPassbyValTest();
	
	@Test
	public void testPrimitive(){
		ref.badSwap(a, b);
		assertEquals(2, a);
		assertEquals(5, b);
	}
	
	@Test
	public void testObject() throws CloneNotSupportedException{
		AnyClass obj1 = new AnyClass(a, b);
		AnyClass clone1 = obj1.clone();
		assertEquals(obj1, clone1);
		
		AnyClass obj2 = new AnyClass(a+10, b+10);
		AnyClass clone2 = obj2.clone();
		assertEquals(obj2, clone2);
		
		ref.badSwap(obj1, obj2);
		
		assertNotEquals(obj1, clone1);
		assertNotEquals(obj2, clone2);
	}
}

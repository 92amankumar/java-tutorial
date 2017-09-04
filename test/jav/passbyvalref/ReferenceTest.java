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
		
		
		ref.badSwap(obj1, null);
		
		assertNotEquals(obj1, clone1);
	}
}

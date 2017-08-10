package jav.testjunit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

//Regression Testing Framework to implement unit testing in Java
public class TestJunit {

	@Test
	public void test() {
		String str = "Is Junit working";
		assertEquals("Is Junit working", str);
	}

}

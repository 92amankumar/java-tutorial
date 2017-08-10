package jav.runner;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import jav.passbyvalref.ReferenceTest;
import jav.testjunit.TestJunit;

@RunWith(Suite.class)

@SuiteClasses({
	TestJunit.class,
	ReferenceTest.class
})

public class TestRunner {
}

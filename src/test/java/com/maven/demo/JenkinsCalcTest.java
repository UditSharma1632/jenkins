package com.maven.demo;

import static org.junit.Assert.*;

import org.junit.Test;

public class JenkinsCalcTest {

	@Test
	public void addtest() {
		JenkinsCalculator myCalc = new JenkinsCalculator();
		assertEquals(10, myCalc.addNumbers(5, 5));
	}
	
	@Test
	public void subtracttest() {
		JenkinsCalculator myCalc = new JenkinsCalculator();
		assertEquals(5, myCalc.subtractNumbers(10, 5));

	}
}
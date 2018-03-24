package com.areyes1.jgc.test.suite;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.isA;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class JUnitTest2Suite1 {
	int totalNumberOfApplicants = 0;
	int totalNumberOfAcceptableApplicants = 10;
	ArrayList<String> listOfValidStrings = new ArrayList<String>();
	
	@Before
	public void setData(){
		this.totalNumberOfApplicants = 9;
		listOfValidStrings.add("object_1");
		listOfValidStrings.add("object_2");
		listOfValidStrings.add("object_3");
	}
	
	@Test
	public void testAssertThatEqual() {
		assertThat("123",is("123"));
	}
	
	@Test
	public void testAssertThatObject() {
		assertThat("123",isA(String.class));
	}

}

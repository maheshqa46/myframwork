package com.tmb.test;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class AssertJDemo {
	
	
	@Test
	public void stringTest() {
		String temp ="Hello World";
		
		Assertions.assertThat(temp)
		.isNotNull()
		.isNotEmpty()
		.isNotBlank()
		.isEqualTo("Hello World")
		.contains("Hello")
		.doesNotContain("Hi")
		.containsIgnoringCase("world")
		.endsWith("World");
	}

}

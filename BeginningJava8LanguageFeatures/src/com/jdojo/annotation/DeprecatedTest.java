// DeprecatedTest.java
package com.jdojo.annotation;

@Deprecated
public class DeprecatedTest {
	private DeprecatedTest() {
	}

	public static DeprecatedTest getInstance() {
		// Using the deprecated class inside its own body
		DeprecatedTest dt = new DeprecatedTest();
		return dt;
	}
}
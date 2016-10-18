// ReflectPermissionTest.java
package com.jdojo.reflection;

import java.lang.reflect.ReflectPermission;

public class ReflectPermissionTest {
	public static void main(String[] args) {
		try {
			// Create a permission object  
			ReflectPermission rp = new ReflectPermission("suppressAccessChecks");

			// check for permission  
			rp.checkGuard(null);
			System.out.println("Reflect permission is granted");
		} 
		catch (SecurityException e) {
			System.out.println("Reflect permission is not granted");
		}
	}
}

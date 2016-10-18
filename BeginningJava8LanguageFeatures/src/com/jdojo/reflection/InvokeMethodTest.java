// InvokeMethodTest.java
package com.jdojo.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class InvokeMethodTest {
	public static void main(String[] args) {
		Class<Person> personClass = Person.class;
		try {
			// Create an object of Person class  
			Person p = personClass.newInstance();
			System.out.println(p);
			 
			// Get the reference of the setName() method  
			Method setName = personClass.getMethod("setName", String.class);
			 
			// Invoke the setName() method on p passing 
			// a new value for name as "Ann"  
			setName.invoke(p, "Ann");
			System.out.println(p);
		}
		catch (InstantiationException | IllegalAccessException | 
		       NoSuchMethodException | SecurityException | 
		       IllegalArgumentException | InvocationTargetException e) {
			System.out.println(e.getMessage());
		}
	}
}

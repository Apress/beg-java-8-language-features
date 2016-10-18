// BulbTest.java
package com.jdojo.reflection;

public class BulbTest {
	public static void main(String[] args) {
		/* Uncomment only one of the following statements at a time. 
		   Observe the output to see the difference in the way the Bulb class 
		   is loaded and initialized.
		*/
		
		BulbTest.createObject();
		// BulbTest.forName();
		// BulbTest.forNameVersion2();
		// BulbTest.classLiteral();
	}

	public static void classLiteral() {
		// Will load the class, but won't initialize in Java 5 and later.
		// Prior version of Java will initialize the class too.
		Class<Bulb> c = Bulb.class;
	}

	public static void forNameVersion2() {
		try {
			String className = "com.jdojo.reflection.Bulb";
			boolean initialize = false;

			// Get the classloader for the current class  
			ClassLoader cLoader = BulbTest.class.getClassLoader();

			// Will load, but not initialize the class, because we have 
			// set the initialize variable to false  
			Class c = Class.forName(className, initialize, cLoader);
		}
		catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void forName() {
		try {
			String className = "com.jdojo.reflection.Bulb";

			// Will load and initialize the class  
			Class c = Class.forName(className);
		}
		catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void createObject() {
		// Will load and initialize the Bulb class  
		new Bulb();
	}
}

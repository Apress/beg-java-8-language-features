// AccessAnnotationTest.java
package com.jdojo.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;

public class AccessAnnotationTest {
	public static void main(String[] args) {
		// Read annotation of class declaration
		Class<AccessAnnotation> c = AccessAnnotation.class;
		System.out.println("Annotations for class:" + c.getName());
		printAnnotations(c);

		// Read annotation of package declaration
		Package p = c.getPackage();
		System.out.println("Annotations for package:" + p.getName());
		printAnnotations(p);

		// Read annotation of method declaration
		System.out.println("Method annotations:");
		Method[] m = c.getDeclaredMethods();
		for (int i = 0; i < m.length; i++) {
			System.out.println("Annotations for method:" + m[i].getName());
			printAnnotations(m[i]);
		}
	}

	public static void printAnnotations(AnnotatedElement programElement) {
		Annotation[] annList = programElement.getAnnotations();
		for (int i = 0; i < annList.length; i++) {
			System.out.println(annList[i]);
			if (annList[i] instanceof Version) {
				Version v = (Version)annList[i];
				int major = v.major();
				int minor = v.minor();
				System.out.println("Found Version annotation: "  + 
				      "major =" + major + ", minor=" + minor);
			}
		}
		System.out.println();
	}
}

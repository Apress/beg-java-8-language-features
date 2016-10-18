// ClassReflection.java
package com.jdojo.reflection;

import java.lang.reflect.Modifier;
import java.lang.reflect.TypeVariable;

public class ClassReflection {
	public static void main(String[] args) {
		// Print the class declaration for the Person class
		String classDesciption = getClassDescription(Person.class);
		System.out.println(classDesciption);		
	}

	public static String getClassDescription(Class c) {
		StringBuilder classDesc = new StringBuilder();
		
                // Prepare the modifiers and construct keyword (class, enum, interface etc.)
                int modifierBits = 0;
                String keyword = "";
                
		// Add keyword @interface, interface or class
		if (c.isPrimitive()) {                    
			// We do not want to add anything  
		} 		
		else if (c.isInterface()) {
                        modifierBits = c.getModifiers() & Modifier.interfaceModifiers();
                        
                        // AN annotation is an interface
                        if (c.isAnnotation()) {
                            keyword = "@interface";
                        }
                        else {
                            keyword = "interface";
                        }			
		} 
                else if (c.isEnum()) {
                        modifierBits = c.getModifiers() & Modifier.classModifiers();
                        keyword = "enum";
                }
                else {
                        modifierBits = c.getModifiers() & Modifier.classModifiers();
			keyword = "class";
		}
                
                // Convert modifiers to their string represenation  
                String modifiers = Modifier.toString(modifierBits);
                                
                // Append modifiers
                classDesc.append(modifiers);
                
                // Append the construct keyword
                classDesc.append(" " + keyword);
                
		// Append simple name                
		String simpleName = c.getSimpleName();
		classDesc.append(" " + simpleName);
                
                // Append generic parameters
                String genericParms = getGenericTypeParams(c);
                classDesc.append(genericParms);

		// Append super class  
		Class superClass = c.getSuperclass();
		if (superClass != null) {
			String superClassSimpleName = superClass.getSimpleName();
			classDesc.append(" extends " + superClassSimpleName);
		}

		// Append Interfaces  
		String interfaces = ClassReflection.getClassInterfaces(c);
		if (interfaces != null) {
			classDesc.append(" implements " + interfaces);
		}

		return classDesc.toString();
	}

	public static String getClassInterfaces(Class c) {
		// Get a comma-separated list of interfaces implemented by the class
		Class[] interfaces = c.getInterfaces();		
		String interfacesList = null;
		if (interfaces.length > 0) {		
			String[] interfaceNames = new String[interfaces.length];		
			for(int i = 0; i < interfaces.length; i++) {
				interfaceNames[i] = interfaces[i].getSimpleName();
			}			
			interfacesList = String.join(", ", interfaceNames);
		}		
		return interfacesList;
	}
        
        public static String getGenericTypeParams(Class c) {
            StringBuilder sb = new StringBuilder();
            TypeVariable<?>[] typeParms = c.getTypeParameters();
            
            if (typeParms.length > 0) {
                String[] paramNames = new String[typeParms.length];                
                for(int i = 0; i < typeParms.length; i++) {
                    paramNames[i] = typeParms[i].getTypeName();
                }
                
                sb.append('<');
                String parmsList = String.join(",", paramNames);
                sb.append(parmsList);
                sb.append('>');
            }            
            return sb.toString();
        }
}

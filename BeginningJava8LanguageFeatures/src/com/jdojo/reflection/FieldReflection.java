// FieldReflection.java
package com.jdojo.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

public class FieldReflection {
    public static void main(String[] args) {
        Class<Person> c = Person.class;

        // Print declared fields 
        ArrayList<String> fieldsDesciption = getDeclaredFieldsList(c);

        System.out.println("Declared Fields for " + c.getName());
        for (String desc : fieldsDesciption) {
            System.out.println(desc);
        }

        // Get the accessible public fields  
        fieldsDesciption = getFieldsList(c);

        System.out.println("\nAccessible Fields for " + c.getName());
        for (String desc : fieldsDesciption) {
            System.out.println(desc);
        }

    }

    public static ArrayList<String> getFieldsList(Class c) {
        Field[] fields = c.getFields();
        ArrayList<String> fieldsList = getFieldsDesciption(fields);
        return fieldsList;
    }

    public static ArrayList<String> getDeclaredFieldsList(Class c) {
        Field[] fields = c.getDeclaredFields();
        ArrayList<String> fieldsList = getFieldsDesciption(fields);
        return fieldsList;
    }

    public static ArrayList<String> getFieldsDesciption(Field[] fields) {
        ArrayList<String> fieldList = new ArrayList<>();

        for (Field f : fields) {
            // Get the modifiers for the field  
            int mod = f.getModifiers() & Modifier.fieldModifiers();
            String modifiers = Modifier.toString(mod);

            // Get the simple name of the field type  
            Class<?> type = f.getType();
            String typeName = type.getSimpleName();

            // Get the name of the field  
            String fieldName = f.getName();

            fieldList.add(modifiers + " " + typeName + " " + fieldName);
        }

        return fieldList;
    }
}

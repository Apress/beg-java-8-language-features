// NestedGroupings.java
package com.jdojo.streams;

import java.time.Month;
import java.util.Map;
import java.util.stream.Collectors;

public class NestedGroupings {
	public static void main(String[] args) {
		Map<Person.Gender, Map<Month, String>> personsByGenderAndDobMonth
			= Person.persons()
			        .stream()
			        .collect(Collectors.groupingBy(Person::getGender,
			          Collectors.groupingBy(p -> p.getDob().getMonth(),
			          Collectors.mapping(Person::getName, 
                             Collectors.joining(", ")))));

		System.out.println(personsByGenderAndDobMonth);
	}
}

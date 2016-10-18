// Person.java
package com.jdojo.reflection;

import java.io.Serializable;

public class Person implements Cloneable, Serializable {
	private int id = -1;
	private String name = "Unknown";

	public Person() {
	}

	public Person(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Object clone() {
		try {
			return super.clone();
		} 
		catch (CloneNotSupportedException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	public String toString() {
		return "Person: id=" + this.id + ", name=" + this.name;
	}
}

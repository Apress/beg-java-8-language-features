// PublicPerson.java
package com.jdojo.reflection;

public class PublicPerson {
	private int id = -1;
	public String name = "Unknown";

	public PublicPerson() {
	}

	public String toString() {
		return "Person: id=" + this.id + ", name=" + this.name;
	}
}

// LowerCaseReaderTest.java
package com.jdojo.io;

import java.io.FileReader;
import java.io.BufferedReader;

public class LowerCaseReaderTest {
	public static void main(String[] args) throws Exception {
		String fileName = "luci4.txt";
		LowerCaseReader lcr = new LowerCaseReader(new FileReader(fileName));

		System.out.println("Reading luci4.txt using LowerCaseReader:");
		int c = -1;
		while ((c = lcr.read()) != -1) {
			System.out.print((char) c);
		}
		lcr.close();

		System.out.println("\n\nReading luci4.txt using " + 
		                   "LowerCaseReader and BufferedReader:");
		
		BufferedReader br = new BufferedReader(
			new LowerCaseReader(new FileReader(fileName)));

		String str = null;
		while ((str = br.readLine()) != null) {
			System.out.println(str);
		}
		br.close();
	}
}

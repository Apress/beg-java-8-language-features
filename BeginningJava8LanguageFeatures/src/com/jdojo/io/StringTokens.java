// StringTokens.java
package com.jdojo.io;

import java.util.StringTokenizer;

public class StringTokens { 
	public static void main(String[] args) {
		String str = "This is a test, which is simple";
		String delimiters = " ,"; // a space and a comma
		StringTokenizer st = new StringTokenizer(str, delimiters);
		
		System.out.println("Tokens using a StringTokenizer:");
		String token = null;
		while(st.hasMoreTokens()) {
			token = st.nextToken();
			System.out.println(token);
		}
		
		// Split the same string using String.split() method		
		System.out.println("\nTokens using the String.split() method:");
		String regex = "[ ,]+" ; /* a space or a comma */
		String[] s = str.split(regex);		
		for(int i = 0 ; i < s.length; i++) {
			System.out.println(s[i]);
		}
	}
}

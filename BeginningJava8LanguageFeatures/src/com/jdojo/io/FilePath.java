// FilePath.java
package com.jdojo.io;

import java.io.File;
import java.io.IOException;

public class FilePath {
	public static void main(String[] args) {
		String workingDir = System.getProperty("user.dir");
		System.out.println("Working Directory: " + workingDir);
		System.out.println("----------------------");
		printFilePath("dummy.txt");

		System.out.println("----------------------");
		printFilePath(".." + File.separator + "notes.txt");
	}

	public static void printFilePath(String pathname){
		File f = new File(pathname);
		System.out.println("File Name: " + f.getName());
		System.out.println("File exists: " + f.exists());
		System.out.println("Absolute Path: " + f.getAbsolutePath());

		try {
			System.out.println("Canonical Path: " + f.getCanonicalPath());
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
}

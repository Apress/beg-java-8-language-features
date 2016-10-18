// ZipUtility.java
package com.jdojo.archives;

import java.util.zip.ZipOutputStream;
import java.util.zip.ZipEntry;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.util.zip.Deflater;

public class ZipUtility {
	public static void main(String[] args) {
		// we want to create a ziptest.zip file in the current 
		// directory. We want to add two files to this zip file. 
		// Both file paths are relative to the current directory. 
		String zipFileName = "ziptest.zip";
		String[] entries = new String[2];
		entries[0] = "test1.txt";
		entries[1] = "notes" + File.separator + "test2.txt";
		zip(zipFileName, entries);
	}

	public static void zip(String zipFileName, String[] zipEntries) {
		// Get the current directory for later use
		String currentDirectory = System.getProperty("user.dir");

		try (ZipOutputStream zos = 
			new ZipOutputStream(
				new BufferedOutputStream(
					new FileOutputStream(zipFileName)))) {

			// Set the compression level to best compression
			zos.setLevel(Deflater.BEST_COMPRESSION);

			// Add each entry to the ZIP file
			for (int i = 0; i < zipEntries.length; i++) {
				// Make sure the entry file exists
				File entryFile = new File(zipEntries[i]);
				if (!entryFile.exists()) {
					System.out.println("The entry file "
						+ entryFile.getAbsolutePath()
						+ " does not exist");
					System.out.println(
						"Aborted processing.");
					return;
				}

				// Create a ZipEntry object
				ZipEntry ze = new ZipEntry(zipEntries[i]);

				// Add zip entry object to the ZIP file
				zos.putNextEntry(ze);

				// Add the contents of the entry to the ZIP file
				addEntryContent(zos, zipEntries[i]);

				// We are done with the current entry
				zos.closeEntry();
			}

			System.out.println("Output has been written to " + 
			   currentDirectory + File.separator + zipFileName);
		} 
		catch (IOException e) {
			e.printStackTrace();
		}		
	}

	public static void addEntryContent(ZipOutputStream zos,
	                                   String entryFileName) 
			throws IOException, FileNotFoundException {

		// Create an input stream to read data from the entry file
		BufferedInputStream bis = new BufferedInputStream(
					new FileInputStream(entryFileName));

		byte[] buffer = new byte[1024];
		int count = -1;
		while ((count = bis.read(buffer)) != -1) {
			zos.write(buffer, 0, count);
		}
		bis.close();
	}
}

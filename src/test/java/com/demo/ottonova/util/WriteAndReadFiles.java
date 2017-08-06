package com.demo.ottonova.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WriteAndReadFiles {

	public static void writerStringFile(List<String> theArray) throws IOException {
		System.out.println("Starting to write the File");
		FileWriter writer = new FileWriter("export.txt");
		for (String str : theArray) {
			writer.write(str + "\n");
		}
		writer.close();
		System.out.println("Finish to write the File");
	}

	public static List<String> readFileToArraySpaceXSpace() throws FileNotFoundException {
		List<String> theArray = new ArrayList<String>();

		System.out.println("Starting to read the File");
		Scanner s = new Scanner(new File("export.txt"));
		while (s.hasNext()) {
			theArray.add(s.next());
		}
		s.close();
		System.out.println("Finish to read the File");

		return theArray;
	}

	public static List<String> readFileToArrayLineXLine() throws IOException {
		List<String> theArray = new ArrayList<String>();
		System.out.println("Starting to read the File");

		try (BufferedReader br = new BufferedReader(new FileReader("export.txt"))) {
			String line;
			while ((line = br.readLine()) != null) {
				// process the line.
				theArray.add(line);
			}
		}

		System.out.println("Finish to read the File");
		return theArray;
	}
}

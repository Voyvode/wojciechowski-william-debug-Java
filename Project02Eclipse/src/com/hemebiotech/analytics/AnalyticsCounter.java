package com.hemebiotech.analytics;

import java.io.*;

public class AnalyticsCounter {
	private static int headacheCount = 0;
	private static int rashCount = 0;
	private static int pupilCount = 0;
	
	public static void main(String args[]) {
		try (var reader = new BufferedReader(new FileReader("symptoms.txt"))) {
			String line = reader.readLine();

			int i = 0;
			while (line != null) {
				i++;
				System.out.println("symptom from file: " + line);
				if (line.equals("headache")) {
					headacheCount++;
					System.out.println("number of headaches: " + headacheCount);
				} else if (line.equals("rash")) {
					rashCount++;
				} else if (line.equals("dilated pupils")) {
					pupilCount++;
				}

				line = reader.readLine();
			}
		} catch (FileNotFoundException e) {
			System.err.println("Can’t read " + e.getMessage());
		} catch (IOException e) {
			System.err.println("IO error while reading: " + e.getMessage());
		}

		try (var writer = new FileWriter("result.out")) {
			writer.write("headache: " + headacheCount + "\n");
			writer.write("rash: " + rashCount + "\n");
			writer.write("dilated pupils: " + pupilCount + "\n");
		} catch (IOException e) {
			System.err.println("Can’t write to " + e.getMessage());
		}
	}
}

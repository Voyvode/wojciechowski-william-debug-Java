package com.hemebiotech.analytics;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter {

	private final String filepath;

	public WriteSymptomDataToFile(String filepath) {
		this.filepath = filepath;
	}

	@Override
	public void writeSymptoms(Map<String, Integer> symptoms) {
		try (var writer = new PrintWriter(filepath)) {
			symptoms.forEach((symptom, count) -> writer.printf("%s: %d%n", symptom, count));
		} catch (FileNotFoundException e) {
			System.err.println("Can't write " + e.getMessage());
		} catch (SecurityException e) {
			System.err.println("Can't access " + e.getMessage());
		}
	}

}

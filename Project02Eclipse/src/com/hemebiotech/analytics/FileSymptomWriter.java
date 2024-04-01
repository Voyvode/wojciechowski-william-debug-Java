package com.hemebiotech.analytics;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * {@code FileSymptomWriter} implements the {@code SymptomWriter} interface.
 * This class writes the analyzed symptoms as a text file to a specified path.
 */
public class FileSymptomWriter implements SymptomWriter {

	private final String filepath;

	/**
	 * Constructs a symptom writer given a path to write text file.
	 *
	 * @param filepath the path to write a text file
	 */
	public FileSymptomWriter(String filepath) {
		this.filepath = filepath;
	}

	/**
	 * Writes a map of symptoms to the specified file path. Each symptom is written
	 * on a separate line, formatted as {@code symptom: count}.
	 *
	 * @param symptoms a map of symptoms to be written down
	 */
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

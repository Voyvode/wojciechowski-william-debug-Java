package com.hemebiotech.analytics;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * {@code FileSymptomReader} implements the {@code SymptomReader} interface.
 * This class retrieves collected symptoms from the provided text file and returns them
 * as a list of strings.
 */
public class FileSymptomReader implements SymptomReader {

	private final String filepath;

	/**
	 * Constructs a symptom reader given a text file.
	 *
	 * @param filepath the path to a text file
	 */
	public FileSymptomReader(String filepath) {
		this.filepath = filepath;
	}

	/**
	 * Retrieves a list of symptoms from the provided text file. Content of the file
	 * is read line by line, collected, and returned as a list of symptoms.
	 *
	 * @return a list of symptoms
	 */
	@Override
	public List<String> getSymptoms() {
		var list = new ArrayList<String>();

		try (var lines = Files.lines(Paths.get(filepath))) {
			list.addAll(lines.collect(Collectors.toCollection(ArrayList::new)));
		} catch (FileNotFoundException e) {
			System.err.println("Can't read " + e.getMessage());
		} catch (IOException e) {
			System.err.println("IO error while reading: " + e.getMessage());
		}

		return list;
	}

}

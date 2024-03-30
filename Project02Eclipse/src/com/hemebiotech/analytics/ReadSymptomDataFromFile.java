package com.hemebiotech.analytics;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Simple brute force implementation
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private final String filepath;

	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 */
	public ReadSymptomDataFromFile(String filepath) {
		this.filepath = filepath;
	}
	
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

package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * The {@code AnalyticsCounter} class is responsible for analyzing and counting symptoms
 * from a given data source. It provides methods to read the symptoms, count their
 * occurrences, sort the results, and write the symptom counts to an output.<p>
 *
 * This class uses two interfaces, {@code SymptomReader} and {@code SymptomWriter}
 * to handle custom input and output of symptom data.
 */
public class AnalyticsCounter {

	private final SymptomReader symptomReader;
	private final SymptomWriter symptomWriter;

	/**
	 * Constructs an {@code AnalyticsCounter} given the symptom reader and writer implementations.
	 *
	 * @param symptomReader the symptom reader implementation
	 * @param symptomWriter the symptom writer implementation
	 */
	public AnalyticsCounter(SymptomReader symptomReader, SymptomWriter symptomWriter) {
		this.symptomReader = symptomReader;
		this.symptomWriter = symptomWriter;
	}

	/**
	 * Returns a list of symptoms as read by the symptom reader.
	 *
	 * @return a list of symptoms
	 */
	public List<String> getSymptoms() {
		return symptomReader.getSymptoms();
	}

	/**
	 * Takes a list of symptoms and returns the count of each as a map.
	 *
	 * @param symptoms the list of symptoms
	 * @return a map containing symptoms as keys and counts as values
	 */
	public Map<String, Integer> countSymptoms(List<String> symptoms) {
		return symptoms.stream()
				.collect(Collectors.groupingBy(symptom -> symptom, Collectors.summingInt(symptom -> 1)));
	}

	/**
	 * Sorts a map of symptom counts in alphabetical order.
	 *
	 * @param symptoms the map of symptom counts to sort
	 * @return a sorted map of symptom counts
	 */
	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
		return new TreeMap<>(symptoms);
	}

	/**
	 * Writes the symptom counts to an output destination using the symptom writer.
	 *
	 * @param symptoms the map of symptom counts
	 */
	public void writeSymptoms(Map<String, Integer> symptoms) {
		symptomWriter.writeSymptoms(symptoms);
	}

	/**
	 * A convenience method that combines read, count, sort, and write operations in one call.
	 */
	public void writeSymptoms() {
		var list = getSymptoms();
		var map = countSymptoms(list);
		var sortedMap = sortSymptoms(map);
		writeSymptoms(sortedMap);
	}

}

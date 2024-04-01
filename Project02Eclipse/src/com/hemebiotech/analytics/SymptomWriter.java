package com.hemebiotech.analytics;

import java.util.Map;

/**
 * The {@code SymptomWriter} interface provides a method to write symptoms somewhere.<p>
 *
 * Its implementation manages the formatting and writing process to a specific destination.
 */
public interface SymptomWriter {

	/**
	 * Writes the processed symptoms to a destination.
	 *
	 * @param symptoms a map containing the symptoms as keys and their counts as values
	 */
	void writeSymptoms(Map<String, Integer> symptoms);

}

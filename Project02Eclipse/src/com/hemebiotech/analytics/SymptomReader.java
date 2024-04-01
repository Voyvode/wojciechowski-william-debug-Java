package com.hemebiotech.analytics;

import java.util.List;

/**
 * The {@code SymptomReader} interface provides a method to get symptoms from a data source.<p>
 *
 * Its implementation manages the process of retrieving raw data from a specific source
 * and turns them into a list of strings.
 */
public interface SymptomReader {

	/**
	 * Retrieves a list of symptoms from a data source.
	 * If no data is available, an empty list is returned.
	 *
	 * @return a list of symptoms
	 */
	List<String> getSymptoms();

}

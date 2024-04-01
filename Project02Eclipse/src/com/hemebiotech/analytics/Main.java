package com.hemebiotech.analytics;

/**
 * Entry point.
 */
public class Main {

	/**
	 * Initializes a {@code FileSymptomReader} to read symptom data from {@code symptoms.txt},
	 * a {@code FileSymptomWriter} to write the processed data to {@code result.out}, then
	 * creates an {@code AnalyticsCounter} to proceed.
	 *
	 * @param args command-line arguments (unused)
	 */
	public static void main(String[] args) {
		var sr = new FileSymptomReader("symptoms.txt");
		var sw = new FileSymptomWriter("result.out");

		new AnalyticsCounter(sr, sw).writeSymptoms();
	}

}

package com.hemebiotech.analytics;

public class Main {

	public static void main(String[] args) {
		var sr = new ReadSymptomDataFromFile("symptoms.txt");
		var sw = new WriteSymptomDataToFile("result.out");

		new AnalyticsCounter(sr, sw).writeSymptoms();
	}

}

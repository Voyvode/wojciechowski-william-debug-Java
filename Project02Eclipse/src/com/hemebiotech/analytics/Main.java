package com.hemebiotech.analytics;

public class Main {

	public static void main(String[] args) {
		var sr = new FileSymptomReader("symptoms.txt");
		var sw = new FileSymptomWriter("result.out");

		new AnalyticsCounter(sr, sw).writeSymptoms();
	}

}

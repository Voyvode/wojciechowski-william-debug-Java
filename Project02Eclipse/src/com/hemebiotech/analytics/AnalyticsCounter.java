package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class AnalyticsCounter {

	private final ISymptomReader symptomReader;
	private final ISymptomWriter symptomWriter;

	public AnalyticsCounter(ISymptomReader symptomReader, ISymptomWriter symptomWriter) {
		this.symptomReader = symptomReader;
		this.symptomWriter = symptomWriter;
	}

	public List<String> getSymptoms() {
		return symptomReader.getSymptoms();
	}

	public Map<String, Integer> countSymptoms(List<String> symptoms) {
		return symptoms.stream()
				.collect(Collectors.groupingBy(symptom -> symptom, Collectors.summingInt(symptom -> 1)));
	}

	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
		return new TreeMap<>(symptoms);
	}

	public void writeSymptoms(Map<String, Integer> symptoms) {
		symptomWriter.writeSymptoms(symptoms);
	}

	public void writeSymptoms() {
		var list = getSymptoms();
		var map = countSymptoms(list);
		var sortedMap = sortSymptoms(map);
		writeSymptoms(sortedMap);
	}

}

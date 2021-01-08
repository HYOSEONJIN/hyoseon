package com.aia.firstspring.domain;

public class SearchType {
	
	private int value;
	private String label;
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	@Override
	public String toString() {
		return "SearchType [value=" + value + ", label=" + label + "]";
	}
	public SearchType(int value, String label) {
		
		this.value = value;
		this.label = label;
	}

	
	
}

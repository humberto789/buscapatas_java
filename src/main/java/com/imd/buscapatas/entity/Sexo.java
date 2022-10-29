package com.imd.buscapatas.entity;

public enum Sexo {

	M("M"),
	F("F");
	
	private String label;
	
	private Sexo(String label) {
		this.label = label;
	}
	
	public String getLabel() {
		return label;
	}
	
}

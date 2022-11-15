package com.imd.buscapatas.entity;

public enum Sexo {

	M("Macho"),
	F("Femea");
	
	private String label;
	
	private Sexo(String label) {
		this.label = label;
	}
	
	public String getLabel() {
		return label;
	}
	
}

package com.imd.buscapatas.entity;

public enum Sexo {

	MACHO("M"),
	FEMEA("F");
	
	private String label;
	
	private Sexo(String label) {
		this.label = label;
	}
	
	public String getLabel() {
		return label;
	}
	
}

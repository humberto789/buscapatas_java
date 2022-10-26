package com.imd.buscapatas.entity;

public enum TipoPost {

	ANIMAL_PERDIDO(1),
	ANIMAL_AVISTADO(2);
	
	private int label;
	
	private TipoPost(int label) {
		this.label = label;
	}
	
	public int getLabel() {
		return label;
	}
}

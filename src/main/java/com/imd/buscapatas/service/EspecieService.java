package com.imd.buscapatas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imd.buscapatas.entity.Especie;
import com.imd.buscapatas.repository.EspecieRepository;

@Service
public class EspecieService {

	@Autowired
	EspecieRepository especieRepository;
	
	public String addEspecie(Especie especie) {
		try {	
			
			especieRepository.save(especie);
			
			return "Especie salva com sucesso.";
		} catch (Exception e) {
			throw e;
		}
	}
	
	public String removeAnimal(Especie especie) {
		try {	
			if(especieRepository.existsById(especie.getId())) {
				especieRepository.delete(especie);
				return "Especie removida com sucesso.";
			}else {
				return "Essa especie não existe";
			}
		} catch (Exception e) {
			throw e;
		}
	}
	
	public String updateAnimal(Especie especie) {
		try {
			if(especieRepository.existsById(especie.getId())) {
				especieRepository.save(especie);
				return "Especie atualizada com sucesso.";
			}else {
				return "Essa especie não existe";
			}
		} catch (Exception e){
			throw e;
		}
	}
}

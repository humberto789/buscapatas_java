package com.imd.buscapatas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imd.buscapatas.entity.Especie;
import com.imd.buscapatas.repository.EspecieRepository;
import com.imd.buscapatas.repository.RacaRepository;

@Service
public class EspecieService {

	@Autowired
	EspecieRepository especieRepository;
	
	@Autowired
	RacaRepository racaRepository;
	
	public String addEspecie(Especie especie) {
		try {	
			
			especieRepository.save(especie);
			
			return "Especie salva com sucesso.";
		} catch (Exception e) {
			throw e;
		}
	}
	
	public String removeEspecie(Especie especie) {
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
	
	public String updateEspecie(Especie especie) {
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

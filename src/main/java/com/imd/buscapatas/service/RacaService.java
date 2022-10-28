package com.imd.buscapatas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imd.buscapatas.entity.Raca;
import com.imd.buscapatas.repository.RacaRepository;

@Service
public class RacaService {
	@Autowired
	RacaRepository racaRepository;
	
	public String addRaca(Raca raca) {
		try {	
			if(racaRepository.existsByRaca(raca.getRaca())) {
				
				racaRepository.save(raca);
				
				return "Raca salva com sucesso.";
			}else {
				return "Essa raca já existe";
			}
		} catch (Exception e) {
			throw e;
		}
	}
	
	public String removeRaca(Raca raca) {
		try {	
			if(racaRepository.existsById(raca.getId())) {
				racaRepository.delete(raca);
				return "Raca removida com sucesso.";
			}else {
				return "Essa raca não existe";
			}
		} catch (Exception e) {
			throw e;
		}
	}
	
	public String updateRaca(Raca raca) {
		try {
			if(racaRepository.existsById(raca.getId())) {
				racaRepository.save(raca);
				return "Raca atualizada com sucesso.";
			}else {
				return "Essa raca não existe";
			}
		} catch (Exception e){
			throw e;
		}
	}
}

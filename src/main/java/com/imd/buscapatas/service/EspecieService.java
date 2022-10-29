package com.imd.buscapatas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imd.buscapatas.entity.Especie;
import com.imd.buscapatas.entity.Raca;
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
			if(!especieRepository.existsByNome(especie.getNome())) {
				
				especieRepository.save(especie);
				
				especie.setId(especieRepository.findByNome(especie.getNome()).getId());
				
				if(especie.getRacas() != null) {
					for(Raca raca : especie.getRacas()) {
						if(!racaRepository.existsByNome(raca.getNome())) {
							raca.setEspecie(especie);
							racaRepository.save(raca);
						}
						raca = racaRepository.findTop1ByNome(raca.getNome()).get(0);
					}
				}
				
				return "Especie salva com sucesso.";
			}else {
				return "Essa especie já existe no sistema";
			}
		} catch (Exception e) {
			throw e;
		}
	}
	
	public String removeEspecie(Especie especie) {
		try {	
			if(especieRepository.existsById(especie.getId())) {

				for(Raca raca : especie.getRacas()) {
					racaRepository.delete(raca);
				}
				
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
				
				if(especie.getRacas() != null) {
					for(Raca raca : especie.getRacas()) {
						if(!racaRepository.existsByNome(raca.getNome())) {
							raca.setEspecie(especie);
							racaRepository.save(raca);
						}
						raca = racaRepository.findTop1ByNome(raca.getNome()).get(0);
					}
				}
				
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

package com.imd.buscapatas.service;

import com.imd.buscapatas.entity.Raca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imd.buscapatas.entity.Raca;
import com.imd.buscapatas.repository.RacaRepository;

import java.util.List;

@Service
public class RacaService {
	@Autowired
	RacaRepository racaRepository;

	public List<Raca> getAllRacas(){

		try {
			List<Raca> listaRacas = racaRepository.findAll();

			return listaRacas;
		}catch(Exception e) {
			throw e;
		}
	}

	public List<Raca> getRacasByEspecie(int especie_id){

		try {
			List<Raca> listaRacas = racaRepository.findByEspecieId(especie_id);

			return listaRacas;
		}catch(Exception e) {
			throw e;
		}
	}
	
	public String addRaca(Raca raca) {
		try {	

			racaRepository.save(raca);

			return "Raça salva com sucesso.";

		} catch (Exception e) {
			throw e;
		}
	}
	
	public String removeRaca(Raca raca) {
		try {	
			if(racaRepository.existsById(raca.getId())) {
				racaRepository.delete(raca);
				return "Raça removida com sucesso.";
			}else {
				return "Essa raça não existe";
			}
		} catch (Exception e) {
			throw e;
		}
	}
	
	public String updateRaca(Raca raca) {
		try {
			if(racaRepository.existsById(raca.getId())) {
				racaRepository.save(raca);
				return "Raça atualizada com sucesso.";
			}else {
				return "Essa raça não existe";
			}
		} catch (Exception e){
			throw e;
		}
	}
}

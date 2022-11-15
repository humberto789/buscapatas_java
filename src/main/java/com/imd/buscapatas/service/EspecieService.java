package com.imd.buscapatas.service;

import com.imd.buscapatas.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imd.buscapatas.entity.Especie;
import com.imd.buscapatas.entity.Raca;
import com.imd.buscapatas.repository.EspecieRepository;
import com.imd.buscapatas.repository.RacaRepository;

import java.util.List;

@Service
public class EspecieService {

	@Autowired
	EspecieRepository especieRepository;
	
	@Autowired
	RacaRepository racaRepository;

	public List<Especie> getAllEspecies(){

		try {
			List<Especie> listaEspecies = especieRepository.findAll();

			return listaEspecies;
		}catch(Exception e) {
			throw e;
		}
	}

	public String addEspecie(Especie especie) {
		try {	
			if(!especieRepository.existsByNome(especie.getNome())) {
				
				especieRepository.save(especie);
				
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

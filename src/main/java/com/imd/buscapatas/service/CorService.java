package com.imd.buscapatas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imd.buscapatas.entity.Cor;
import com.imd.buscapatas.repository.CorRepository;

import java.util.List;

@Service
public class CorService {

	@Autowired
	CorRepository corRepository;

	public List<Cor> getAllCores(){

		try {
			List<Cor> listaCores = corRepository.findAll();

			return listaCores;
		}catch(Exception e) {
			throw e;
		}
	}

	public String addCor(Cor cor) {
		try {	
			if(!corRepository.existsByNome(cor.getNome())) {
				corRepository.save(cor);
				
				return "Cor salva com sucesso.";
			}else {
				return "Essa cor já existe";
			}
		} catch (Exception e) {
			throw e;
		}
	}
	
	public String removeCor(Cor cor) {
		try {	
			if(corRepository.existsById(cor.getId())) {
				corRepository.delete(cor);
				return "cor removida com sucesso.";
			}else {
				return "Essa cor não existe";
			}
		} catch (Exception e) {
			throw e;
		}
	}
	
	public String updateCor(Cor cor) {
		try {
			if(corRepository.existsById(cor.getId())) {
				corRepository.save(cor);
				return "Cor atualizada com sucesso.";
			}else {
				return "Essa cor não existe";
			}
		} catch (Exception e){
			throw e;
		}
	}
}

package com.imd.buscapatas.controller;

import com.imd.buscapatas.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.imd.buscapatas.entity.Especie;
import com.imd.buscapatas.service.EspecieService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class EspecieController {

	@Autowired
	EspecieService especieService;

	@RequestMapping(value = "especies", method = RequestMethod.GET)
	public List<Especie> getAllEspecies(){
		return especieService.getAllEspecies();
	}
	
	
	@RequestMapping(value = "especies", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public String addEspecie(@RequestBody Especie especie) {
		return especieService.addEspecie(especie);
	}
	
	@RequestMapping(value = "especies", method = RequestMethod.PUT)
	public String updateEspecie(@RequestBody Especie especie) {
		return especieService.updateEspecie(especie);
	}


	
	@RequestMapping(value = "especies", method = RequestMethod.DELETE)
	public String removeEspecie(@RequestBody Especie especie) {
		return especieService.removeEspecie(especie);
	}
}

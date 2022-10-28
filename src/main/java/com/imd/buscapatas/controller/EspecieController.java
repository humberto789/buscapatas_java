package com.imd.buscapatas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.imd.buscapatas.entity.Especie;
import com.imd.buscapatas.service.EspecieService;

@RestController
@CrossOrigin(origins = "*")
public class EspecieController {

	@Autowired
	EspecieService especieService;
	
	@RequestMapping(value = "especie", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public String addEspecie(@RequestBody Especie especie) {
		return especieService.addEspecie(especie);
	}
	
	@RequestMapping(value = "especie", method = RequestMethod.PUT)
	public String updateUsuario(@RequestBody Especie especie) {
		return especieService.updateEspecie(especie);
	}
	
	@RequestMapping(value = "especie", method = RequestMethod.DELETE)
	public String removeUsuario(@RequestBody Especie especie) {
		return especieService.removeEspecie(especie);
	}
}

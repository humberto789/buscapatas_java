package com.imd.buscapatas.controller;

import com.imd.buscapatas.entity.Cor;
import com.imd.buscapatas.entity.Especie;
import com.imd.buscapatas.entity.Raca;
import com.imd.buscapatas.service.CorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class CorController {

	@Autowired
	CorService corService;

	@RequestMapping(value = "cores", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public List<Cor> getAllCores(){
		return corService.getAllCores();
	}
	
	@RequestMapping(value = "cores", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public String addCor(@RequestBody Cor cor) {
		return corService.addCor(cor);
	}
	
	@RequestMapping(value = "cores", method = RequestMethod.PUT)
	public String updateCor(@RequestBody Cor cor) {
		return corService.updateCor(cor);
	}


}

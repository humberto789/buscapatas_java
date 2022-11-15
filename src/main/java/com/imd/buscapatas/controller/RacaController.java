package com.imd.buscapatas.controller;

import com.imd.buscapatas.entity.Especie;
import com.imd.buscapatas.entity.Raca;
import com.imd.buscapatas.service.RacaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class RacaController {

	@Autowired
	RacaService racaService;
	
	@RequestMapping(value = "racas", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public String addRaca(@RequestBody Raca raca) {
		return racaService.addRaca(raca);
	}
	
	@RequestMapping(value = "racas", method = RequestMethod.PUT)
	public String updateRaca(@RequestBody Raca raca) {
		return racaService.updateRaca(raca);
	}

	@RequestMapping(value = "racas", method = RequestMethod.GET)
	public List<Raca> getAllRacas(){
		return racaService.getAllRacas();
	}
	
	@RequestMapping(value = "racas/especie/{id}", method = RequestMethod.GET)
	public List<Raca> getRacasByEspecie(@PathVariable int id){
		return racaService.getRacasByEspecie(id);
	}

}

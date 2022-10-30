package com.imd.buscapatas.controller;

import com.imd.buscapatas.entity.Cor;
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

	@RequestMapping(value = "cores", method = RequestMethod.GET)
	public List<Cor> getAllCores(){
		return corService.getAllCores();
	}


}

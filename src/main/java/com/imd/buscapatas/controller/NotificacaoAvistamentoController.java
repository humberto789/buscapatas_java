package com.imd.buscapatas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.imd.buscapatas.entity.NotificacaoAvistamento;
import com.imd.buscapatas.service.NotificacaoAvistamentoService;

@RestController
@CrossOrigin(origins = "*")
public class NotificacaoAvistamentoController {

	@Autowired
	NotificacaoAvistamentoService notificacaoAvistamentoService;
	
	@RequestMapping(value = "notifications", method = RequestMethod.GET)
	public List<NotificacaoAvistamento> getAllNotificacaoAvistamento(){
		return notificacaoAvistamentoService.getAllNotificacaoAvistamento();
	}
	
	@RequestMapping(value = "notifications", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public String addNotificacaoAvistamento(@RequestBody NotificacaoAvistamento notificacaoAvistamento) {
		return notificacaoAvistamentoService.addNotificacaoAvistamento(notificacaoAvistamento);
	}
	
	@RequestMapping(value = "notifications", method = RequestMethod.PUT)
	public String updateNotificacaoAvistamento(@RequestBody NotificacaoAvistamento notificacaoAvistamento) {
		return notificacaoAvistamentoService.updateNotificacaoAvistamento(notificacaoAvistamento);
	}
	
	@RequestMapping(value = "notifications", method = RequestMethod.DELETE)
	public String removeNotificacaoAvistamento(@RequestBody NotificacaoAvistamento notificacaoAvistamento) {
		return notificacaoAvistamentoService.removeNotificacaoAvistamento(notificacaoAvistamento);
	}
}

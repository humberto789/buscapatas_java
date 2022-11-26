package com.imd.buscapatas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.imd.buscapatas.entity.NotificacaoAvistamento;
import com.imd.buscapatas.service.NotificacaoAvistamentoService;

@RestController
@CrossOrigin(origins = "*")
public class NotificacaoAvistamentoController {

	@Autowired
	NotificacaoAvistamentoService notificacaoAvistamentoService;
	
	@RequestMapping(value = "notificacoes", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public List<NotificacaoAvistamento> getAllNotificacaoAvistamento(){
		return notificacaoAvistamentoService.getAllNotificacaoAvistamento();
	}

	@RequestMapping(value = "notificacoes/usuario/{id}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public List<NotificacaoAvistamento> getNotificacoesByUsuario(@PathVariable int id){
		return notificacaoAvistamentoService.getNotificacoesByUsuario(id);
	}

	@RequestMapping(value = "notificacoes/post/{id}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public List<NotificacaoAvistamento> getNotificacoesByPost(@PathVariable int id){
		return notificacaoAvistamentoService.getNotificacoesByPost(id);
	}
	
	@RequestMapping(value = "notificacoes", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public String addNotificacaoAvistamento(@RequestBody NotificacaoAvistamento notificacaoAvistamento) {
		return notificacaoAvistamentoService.addNotificacaoAvistamento(notificacaoAvistamento);
	}
	
	@RequestMapping(value = "notificacoes", method = RequestMethod.PUT)
	public String updateNotificacaoAvistamento(@RequestBody NotificacaoAvistamento notificacaoAvistamento) {
		return notificacaoAvistamentoService.updateNotificacaoAvistamento(notificacaoAvistamento);
	}
	
	@RequestMapping(value = "notificacoes", method = RequestMethod.DELETE)
	public String removeNotificacaoAvistamento(@RequestBody NotificacaoAvistamento notificacaoAvistamento) {
		return notificacaoAvistamentoService.removeNotificacaoAvistamento(notificacaoAvistamento);
	}
}

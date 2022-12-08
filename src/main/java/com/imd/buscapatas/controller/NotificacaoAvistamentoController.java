package com.imd.buscapatas.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.imd.buscapatas.entity.NotificacaoAvistamento;
import com.imd.buscapatas.service.NotificacaoAvistamentoService;
import com.imd.buscapatas.util.AzureConfig;

@RestController
@CrossOrigin(origins = "*")
public class NotificacaoAvistamentoController {

	private static String caminhoImagens = "https://buscapatas.s3.sa-east-1.amazonaws.com/";
	
	ObjectMapper objectMapper = new ObjectMapper();
	
	@Autowired
	AzureConfig azure;
	
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
	
	@RequestMapping(value = "notificacoes", method = RequestMethod.POST)
	public String addPost(@RequestParam("jsondata") String jsonData, @RequestParam(value = "file", required = false) MultipartFile arquivo) {
		
		try{

			NotificacaoAvistamento notificacao = objectMapper.readValue(jsonData, NotificacaoAvistamento.class);
			
			String resultado = notificacaoAvistamentoService.addNotificacaoAvistamento(notificacao);
			
			if(arquivo != null) {
				notificacao.setCaminhoImagem("notificacao-foto-" + String.valueOf(notificacao.getId()) + arquivo.getOriginalFilename());
				azure.enviarArquivo(arquivo, notificacao.getCaminhoImagem());
			}else {
				notificacao.setCaminhoImagem("notificacao-foto-padrao.png");
			}
			
			notificacaoAvistamentoService.updateCaminhoImagemNotificacaoAvistamento(notificacao);
			
			return resultado;
		}catch(IOException e) {
			e.printStackTrace();
		}

		return "Houve algum erro";
	}
	
	@RequestMapping(value = "notificacoes", method = RequestMethod.PUT)
	public String updatePost(@RequestParam("jsondata") String jsonData, @RequestParam(value = "file", required = false) MultipartFile arquivo) {
		try{

			NotificacaoAvistamento notificacao = objectMapper.readValue(jsonData, NotificacaoAvistamento.class);
			
			if(arquivo != null) {
				notificacao.setCaminhoImagem("notificacao-foto-" + String.valueOf(notificacao.getId()) + arquivo.getOriginalFilename());
				azure.enviarArquivo(arquivo, notificacao.getCaminhoImagem());
			}else {
				notificacao.setCaminhoImagem("notificacao-foto-padrao.png");
			}
		
			return notificacaoAvistamentoService.updateNotificacaoAvistamento(notificacao);
		}catch(IOException e) {
			e.printStackTrace();
		}

		return "Houve algum erro";
	}
	
	@RequestMapping(value = "notificacoes", method = RequestMethod.DELETE)
	public String removeNotificacaoAvistamento(@RequestBody NotificacaoAvistamento notificacaoAvistamento) {
		return notificacaoAvistamentoService.removeNotificacaoAvistamento(notificacaoAvistamento);
	}
}

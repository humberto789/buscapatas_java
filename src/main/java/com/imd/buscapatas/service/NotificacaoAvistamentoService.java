package com.imd.buscapatas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imd.buscapatas.entity.NotificacaoAvistamento;
import com.imd.buscapatas.entity.Post;
import com.imd.buscapatas.repository.NotificacaoAvistamentoRepository;

@Service
public class NotificacaoAvistamentoService {
	
	@Autowired
	NotificacaoAvistamentoRepository notificacaoAvistamentoRepository;
	
	public List<NotificacaoAvistamento> getAllNotificacaoAvistamento(){

		try {
			List<NotificacaoAvistamento> listaNotificacaoAvistamento = notificacaoAvistamentoRepository.findAll();

			return listaNotificacaoAvistamento;
		}catch(Exception e) {
			throw e;
		}
	}

	public List<NotificacaoAvistamento> getNotificacoesByUsuario(int id_usuario){

		try {
			List<NotificacaoAvistamento> listaNotificacaoAvistamento = notificacaoAvistamentoRepository.findByUsuarioId(id_usuario);

			return listaNotificacaoAvistamento;
		}catch(Exception e) {
			throw e;
		}
	}

	public List<NotificacaoAvistamento> getNotificacoesByPost(int id_post){

		try {
			List<NotificacaoAvistamento> listaNotificacaoAvistamento = notificacaoAvistamentoRepository.findByPostId(id_post);

			return listaNotificacaoAvistamento;
		}catch(Exception e) {
			throw e;
		}
	}

	public String addNotificacaoAvistamento(NotificacaoAvistamento notificacaoAvistamento) {
		try {	
			
			notificacaoAvistamentoRepository.save(notificacaoAvistamento);
			
			return "Notificação de avistamento salva com sucesso.";
		} catch (Exception e) {
			throw e;
		}
	}
	
	public String removeNotificacaoAvistamento(NotificacaoAvistamento notificacaoAvistamento) {
		try {	
			if(notificacaoAvistamentoRepository.existsById(notificacaoAvistamento.getId())) {
				notificacaoAvistamentoRepository.delete(notificacaoAvistamento);
				return "Notificação de avistamento removida com sucesso.";
			}else {
				return "Essa notificação de avistamento não existe";
			}
		} catch (Exception e) {
			throw e;
		}
	}
	
	public String updateNotificacaoAvistamento(NotificacaoAvistamento notificacaoAvistamento) {
		try {
			if(notificacaoAvistamentoRepository.existsById(notificacaoAvistamento.getId())) {
				notificacaoAvistamentoRepository.save(notificacaoAvistamento);
				return "Notificação de avistamento atualizada com sucesso.";
			}else {
				return "Essa notificação de avistamento não existe";
			}
		} catch (Exception e){
			throw e;
		}
	}
	
	public String updateCaminhoImagemNotificacaoAvistamento(NotificacaoAvistamento notificacaoAvistamento) {
		try {
			if(notificacaoAvistamentoRepository.existsById(notificacaoAvistamento.getId())) {
				
				notificacaoAvistamentoRepository.updateCaminhoImagem(notificacaoAvistamento.getId(), notificacaoAvistamento.getCaminhoImagem());
				
				return "Notificação de avistamento atualizado com sucesso.";
			}else {
				return "Essa notificação de avistamento não existe";
			}
		} catch (Exception e){
			throw e;
		}
	}
}

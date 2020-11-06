package br.api.locadora.service;

import org.springframework.stereotype.Service;

import br.api.locadora.model.FormaPagamento;
import br.api.locadora.repository.FormaPagamentoRepository;

@Service
public class FormaPagamentoService {
	
	final FormaPagamentoRepository _formaPagamentoRepository;
	
	public FormaPagamentoService(FormaPagamentoRepository formaPagamento) {
		this._formaPagamentoRepository = formaPagamento;
	}
	
	public void inserir(FormaPagamento formaPagamento) {
		_formaPagamentoRepository.save(formaPagamento);
	}
	
	public Iterable<FormaPagamento> listar() {
		return _formaPagamentoRepository.findAll();
	}
	
	public void editar(FormaPagamento formaPagamento) {
		_formaPagamentoRepository.save(formaPagamento);
	}
	
	public void deletar(Long Id) {
		_formaPagamentoRepository.deleteById(Id);
	}
}

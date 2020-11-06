package br.api.locadora.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.api.locadora.model.Cliente;
import br.api.locadora.model.FormaPagamento;
import br.api.locadora.service.FormaPagamentoService;

@RestController
@RequestMapping("/formas-de-pagamento")
public class FormaPagamentoController {
	
	final FormaPagamentoService _formaPagamentoService;
	
	public FormaPagamentoController(FormaPagamentoService formaPagamentoService) {
		this._formaPagamentoService = formaPagamentoService;
	}
	
	@PostMapping
	public ResponseEntity<FormaPagamento> criar(@RequestBody FormaPagamento formaPagamento) {
		_formaPagamentoService.inserir(formaPagamento);
		return ResponseEntity.status(HttpStatus.CREATED).body(formaPagamento);
	}
	
	@GetMapping
	public Iterable<FormaPagamento> listar() {
		return _formaPagamentoService.listar();
	}
	
	@PutMapping(path = "/{id}")
    public ResponseEntity<FormaPagamento> atualizar(@RequestBody FormaPagamento formaPagamento, @PathVariable Long id) {
		formaPagamento.setId(id);
		_formaPagamentoService.editar(formaPagamento);
        return ResponseEntity.status(HttpStatus.OK).body(formaPagamento);
    }
	
	@DeleteMapping(path = "/{id}")
    public ResponseEntity<FormaPagamento> deletar(@PathVariable Long id) {
		_formaPagamentoService.deletar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}

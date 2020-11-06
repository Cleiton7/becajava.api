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
import br.api.locadora.model.Locacao;
import br.api.locadora.service.ClienteService;
import br.api.locadora.service.LocacaoService;

@RestController
@RequestMapping("/locacoes")
public class LocacaoController {

	final LocacaoService _locacaoService;
	
	public LocacaoController(LocacaoService locacaoService) {
		this._locacaoService = locacaoService;
	}
	
	@PostMapping
    public ResponseEntity<String> criar(@RequestBody Locacao locacao) {
		try
		{
			_locacaoService.inserir(locacao);
			return ResponseEntity.status(HttpStatus.CREATED).body("Locação criado");			
		}
		catch(Exception e)
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro na criação de Locação");	
		}
    }
	
	@GetMapping
	public ResponseEntity<String> listar() {
		try
		{
			_locacaoService.listar();
			return ResponseEntity.status(HttpStatus.OK).body("Locações encontrados");
		}
		catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro na busca por locações");
		}
	}
	
	@PutMapping(path = "/{id}")
    public ResponseEntity<String> atualizar(@RequestBody Locacao locacao, @PathVariable Long id) {
		try
		{
			locacao.setId(id);
			_locacaoService.editar(locacao);
			return ResponseEntity.status(HttpStatus.CREATED).body("Locação editada");
		}
		catch(Exception e)
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro na edição de locação");			
		}
    }
	
	@DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deletar(@PathVariable Long id) {
    	try
    	{
    		_locacaoService.deletar(id);
    		return ResponseEntity.status(HttpStatus.CREATED).body("Locação deletado");  		
    	}
    	catch(Exception e)
    	{
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro na deleção de locação");	
    	}
    }
}

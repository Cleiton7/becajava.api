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
import br.api.locadora.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	final ClienteService _clienteService;
	
	public ClienteController(ClienteService clienteService) {
		this._clienteService = clienteService;
	}
	
	@PostMapping
    public ResponseEntity<String> criar(@RequestBody Cliente cliente) {
		try
		{
			_clienteService.inserir(cliente);
			return ResponseEntity.status(HttpStatus.CREATED).body("Cliente criado");			
		}
		catch(Exception e)
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro na criação de Cliente");	
		}
    }
	
	@GetMapping
	public ResponseEntity<String> listar() {
		try
		{
			_clienteService.listar();
			return ResponseEntity.status(HttpStatus.OK).body("Clientes encontrados");
		}
		catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro na busca por Cliente");
		}
	}
	
	
	@PutMapping(path = "/{id}")
    public ResponseEntity<String> atualizar(@RequestBody Cliente cliente, @PathVariable Long id) {
		try
		{
			cliente.setId(id);
			_clienteService.editar(cliente);
			return ResponseEntity.status(HttpStatus.CREATED).body("Cliente editado");
		}
		catch(Exception e)
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro na edição de Cliente");			
		}
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deletar(@PathVariable Long id) {
    	try
    	{
    		_clienteService.deletar(id);
    		return ResponseEntity.status(HttpStatus.CREATED).body("Cliente deletado");  		
    	}
    	catch(Exception e)
    	{
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro na deleção de Cliente");	
    	}
    }
}
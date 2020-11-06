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

import br.api.locadora.model.Locadora;
import br.api.locadora.service.LocadoraService;

@RestController
@RequestMapping("/locadoras")
public class LocadoraController {

	final LocadoraService _locadoraService;
	
	public LocadoraController(LocadoraService locadoraService) {
		this._locadoraService = locadoraService;
	}
	
	@PostMapping
    public ResponseEntity<String> criar(@RequestBody Locadora locadora) {
		try
		{
			_locadoraService.inserir(locadora);
			return ResponseEntity.status(HttpStatus.CREATED).body("Locadora criada!");	
		}
		catch(Exception e)
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro na criação de Locadora!");			
		}
    }
	
	@GetMapping
	public ResponseEntity<String> listar() {
		try
		{
			_locadoraService.listar();
			return ResponseEntity.status(HttpStatus.CREATED).body("Locadora localizadas!");	
		}
		catch(Exception e)
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro na busca por locadora!");
		}
	}
	
	@PutMapping(path = "/{id}")
    public ResponseEntity<String> atualizar(@RequestBody Locadora locadora, @PathVariable Long id) {
		try
		{
			locadora.setId(id);
			_locadoraService.editar(locadora);
			return ResponseEntity.status(HttpStatus.CREATED).body("Locadora editada!");	
		}catch(Exception e)
		{
			return ResponseEntity.status(HttpStatus.OK).body("Erro na edição de locadora!");
		}
    }
	
	@DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deletar(@PathVariable Long id) {
		try
		{
			_locadoraService.deletar(id);
			return ResponseEntity.status(HttpStatus.CREATED).body("Locadora deletada!");	
		}
		catch(Exception e)
		{
			return ResponseEntity.status(HttpStatus.OK).body("Erro na deleção de locadora!");			
		}
    }
}


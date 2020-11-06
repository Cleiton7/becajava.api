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

import br.api.locadora.model.Veiculo;
import br.api.locadora.service.VeiculoService;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {
	
	final VeiculoService _veiculoService;
	
	public VeiculoController(VeiculoService veiculoService) {
		this._veiculoService = veiculoService;
	}
	
//	CADRASTRANDO 
	@PostMapping
    public ResponseEntity<Veiculo> criar(@RequestBody Veiculo veiculo) {
		_veiculoService.inserir(veiculo);
        return ResponseEntity.status(HttpStatus.CREATED).body(veiculo);
    }
	
	@GetMapping
	public Iterable<Veiculo> listar() {
		return _veiculoService.listar();
	}
	
	@PutMapping(path = "/{id}")
    public ResponseEntity<Veiculo> atualizar(@RequestBody Veiculo veiculo, @PathVariable Long id) {
		veiculo.setId(id);
		_veiculoService.editar(veiculo);
        return ResponseEntity.status(HttpStatus.OK).body(veiculo);
    }
	
	@DeleteMapping(path = "/{id}")
    public ResponseEntity<Veiculo> deletar(@PathVariable Long id) {
		_veiculoService.deletar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}

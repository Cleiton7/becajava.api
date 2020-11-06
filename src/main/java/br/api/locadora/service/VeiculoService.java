package br.api.locadora.service;

import org.springframework.stereotype.Service;

import br.api.locadora.model.Veiculo;
import br.api.locadora.repository.VeiculoRepository;

@Service
public class VeiculoService {

	final VeiculoRepository _veiculoRepository;
	
	public VeiculoService(VeiculoRepository veiculoRepository) {
		this._veiculoRepository = veiculoRepository;
	}
	
	public void inserir(Veiculo veiculo) {
		_veiculoRepository.save(veiculo);
	}
	
	public Iterable<Veiculo> listar() {
		return _veiculoRepository.findAll();
	}
	
	public void editar(Veiculo veiculo) {
		_veiculoRepository.save(veiculo);
	}
	
	public void deletar(Long id) {
		_veiculoRepository.deleteById(id);
	}
}

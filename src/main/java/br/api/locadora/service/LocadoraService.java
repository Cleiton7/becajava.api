package br.api.locadora.service;

import org.springframework.stereotype.Service;

import br.api.locadora.model.Locadora;
import br.api.locadora.repository.LocadoraRepository;

@Service
public class LocadoraService {
	
	final LocadoraRepository _locadoraRepository;
	
	public LocadoraService(LocadoraRepository locadoraRepository) {
		this._locadoraRepository = locadoraRepository;
	}
	
	public void inserir(Locadora locadora) {
		_locadoraRepository.save(locadora);
	}
	
	public Iterable<Locadora> listar() {
		return _locadoraRepository.findAll();
	}
	
	public void editar(Locadora locadora) {
		_locadoraRepository.save(locadora);
	}
	
	public void deletar(Long id) {
		_locadoraRepository.deleteById(id);
	}
}

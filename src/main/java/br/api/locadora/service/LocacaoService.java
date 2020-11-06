package br.api.locadora.service;

import org.springframework.stereotype.Service;

import br.api.locadora.model.Locacao;
import br.api.locadora.repository.LocacaoRepository;

@Service
public class LocacaoService {
	
	final LocacaoRepository _locacaoRepository;
	
	public LocacaoService(LocacaoRepository locacaoRepository){
		this._locacaoRepository = locacaoRepository;
	}
	
	public void inserir(Locacao locacao) {
		_locacaoRepository.save(locacao);
	}
	
	public Iterable<Locacao> listar() {
		return _locacaoRepository.findAll();
	}
	
	public void editar(Locacao locacao) {
		_locacaoRepository.save(locacao);
	}
	
	public void deletar(Long id) {
		_locacaoRepository.deleteById(id);
	}
}

package br.api.locadora.service;

import org.springframework.stereotype.Service;

import br.api.locadora.model.Cliente;
import br.api.locadora.repository.ClienteRepository;

@Service
public class ClienteService {
	final ClienteRepository _clienteRepository;
	
	public ClienteService (ClienteRepository serviceRepository){
		this._clienteRepository = serviceRepository;
	}
	
	public void inserir(Cliente cliente) {
		_clienteRepository.save(cliente);
	}
	
	public Iterable<Cliente> listar() {
		return _clienteRepository.findAll();
	}
	
	public void editar(Cliente cliente) {
		_clienteRepository.save(cliente);
	}
	
	public void deletar(Long id) {
		_clienteRepository.deleteById(id);
	}
}
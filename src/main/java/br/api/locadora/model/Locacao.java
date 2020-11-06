package br.api.locadora.model;

import javax.persistence.*;

@Entity
public class Locacao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private int Valor;

	@ManyToOne
	@JoinColumn(name = "VeiculoId")
	private Veiculo Veiculo;

	@ManyToOne
	@JoinColumn(name = "ClienteId")
	private Cliente Cliente;
	
	@ManyToOne
	@JoinColumn(name = "formaPagamentoId")
	private FormaPagamento formaPagamento;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public int getValor() {
		return Valor;
	}

	public void setValor(int valor) {
		Valor = valor;
	}

	public Veiculo getVeiculo() {
		return Veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		Veiculo = veiculo;
	}

	public Cliente getCliente() {
		return Cliente;
	}

	public void setCliente(Cliente cliente) {
		Cliente = cliente;
	}

	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}
}

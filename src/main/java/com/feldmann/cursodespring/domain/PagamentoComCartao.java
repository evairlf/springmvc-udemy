package com.feldmann.cursodespring.domain;

import javax.persistence.Entity;

import com.feldmann.cursodespring.domain.enums.EstadoPagamento;

@Entity
public class PagamentoComCartao extends Pagamento{
	//As subclasses nao precisam implementar o Serializable pois a classe mãe ja tem implementado, so precisam do serial
	private static final long serialVersionUID = 1L;
	
	private Integer numeroDeParcelas;
	
	public PagamentoComCartao() {}

	public PagamentoComCartao(Integer id, EstadoPagamento tipo, Pedido pedido,Integer numeroDeParcelas) {
		super(id, tipo, pedido);
		this.numeroDeParcelas = numeroDeParcelas;
	}

	public Integer getNumeroDeParcelas() {
		return numeroDeParcelas;
	}

	public void setNumeroDeParcelas(Integer numeroDeParcelas) {
		this.numeroDeParcelas = numeroDeParcelas;
	}
	
	
	
	
}

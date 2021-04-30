package com.feldmann.cursodespring.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.feldmann.cursodespring.domain.enums.EstadoPagamento;

@Entity
public class PagamentoComBoleto extends Pagamento{
	//As subclasses nao precisam implementar o Serializable pois a classe mãe ja tem implementado, so precisam do serial
	private static final long serialVersionUID = 1L;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date datavencimento;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date datapagamento;
	
	public PagamentoComBoleto() {}

	public PagamentoComBoleto(Integer id, EstadoPagamento tipo, Pedido pedido,Date datavencimento,Date datapagamento) {
		super(id, tipo, pedido);
		this.datapagamento = datapagamento;
		this.datavencimento = datavencimento;
	}

	public Date getDatavencimento() {
		return datavencimento;
	}

	public void setDatavencimento(Date datavencimento) {
		this.datavencimento = datavencimento;
	}

	public Date getDatapagamento() {
		return datapagamento;
	}

	public void setDatapagamento(Date datapagamento) {
		this.datapagamento = datapagamento;
	}
	
	
	
	
}

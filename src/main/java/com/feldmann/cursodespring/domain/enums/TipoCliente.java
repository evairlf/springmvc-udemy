package com.feldmann.cursodespring.domain.enums;

public enum TipoCliente {
	PESSOAFISICA(1,"Pessoa Física"),
	PESSOAJURIDICA(2,"Pessoa Jurídica");
	
	private int cod;
	private String descryption;
	
	private TipoCliente(int cod,String descryption) {
		this.cod = cod;
		this.descryption = descryption;
	}
	
	public int getCod() {
		return cod;
	}
	
	public String getDescryption() {
		return descryption;
	}
	
	public static TipoCliente toEnum(Integer cod) {
		
		if(cod == null) {
			return null;
		}
		
		for(TipoCliente x: TipoCliente.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id Inválido = " + cod);
	}
}

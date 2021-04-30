package com.feldmann.cursodespring.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feldmann.cursodespring.domain.Pedido;
import com.feldmann.cursodespring.repositories.PedidoRepository;
import com.feldmann.cursodespring.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	public Pedido buscar(Integer id) {
		Optional<Pedido> obj = pedidoRepository.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException(
				"Objeto não encontado id: "+ id + "Tipo: "+ Pedido.class.getName()));
	}
}

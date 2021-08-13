package com.nandodevs.marketapi.api.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

import com.nandodevs.marketapi.domain.model.Cliente;
import com.nandodevs.marketapi.domain.repository.ClienteRepository;

@AllArgsConstructor //Cria um construtor do respository
@RestController
public class ClienteController {
	
	//@Autowired - pode ser esse
	private ClienteRepository clienteRepository;
	
	@GetMapping("/clientes")
	public List<Cliente> listar() {
		return clienteRepository.findAll();
	}
}

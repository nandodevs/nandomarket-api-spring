package com.nandodevs.marketapi.api.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nandodevs.marketapi.domain.model.Cliente;

@RestController
public class ClienteController {
	
	@GetMapping("/clientes")
	public List<Cliente> listar() {
		var cliente1 = new Cliente();
		cliente1.setId(1L);
		cliente1.setNome("Jubileu");
		cliente1.setEmail("jubileu@nandoapi.com");
		cliente1.setTelefone("98 98447-5522");
		
		var cliente2 = new Cliente();
		cliente2.setId(2L);
		cliente2.setNome("Rosa Maria");
		cliente2.setEmail("rosamaria@nandoapi.com");
		cliente2.setTelefone("98 99991-0123");
		
		return Arrays.asList(cliente1, cliente2);
	}
}

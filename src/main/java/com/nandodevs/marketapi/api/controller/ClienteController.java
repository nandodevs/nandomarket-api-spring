package com.nandodevs.marketapi.api.controller;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

import com.nandodevs.marketapi.domain.model.Cliente;
import com.nandodevs.marketapi.domain.repository.ClienteRepository;

@AllArgsConstructor //Cria um construtor do respository
@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	//@Autowired - pode ser esse
	private ClienteRepository clienteRepository;
	
	@GetMapping
	public List<Cliente> listar() {
		return clienteRepository.findAll();
	}

	@GetMapping("/{clienteId}")
	public ResponseEntity<Cliente> buscar(@PathVariable Long clienteId){
		return clienteRepository.findById(clienteId)
			//.map(cliente -> ResponseEntity.ok(cliente))
			.map(ResponseEntity::ok)
			.orElse(ResponseEntity.notFound().build());

		


		//PODE SER FEITO DESSA FORMA
		// Optional <Cliente> cliente = clienteRepository.findById(clienteId);

		// //Caso encontre algo, será exibido normalmente na API
		// if(cliente.isPresent()){
		// 	return ResponseEntity.ok(cliente.get());
		// }
		
		// //Caso não encontre, será exibido erro 404.
		// return ResponseEntity.notFound().build();
	}

	@PostMapping //Inserir dados no banco
	@ResponseStatus(HttpStatus.CREATED) //Retorna o status 201
	public Cliente adicionar(@RequestBody Cliente cliente){
		return clienteRepository.save(cliente);
	}

	//Método para atualizar os dados
	@PutMapping("/{clienteId}")
	public ResponseEntity<Cliente> atualizar(@PathVariable Long clienteId, @RequestBody Cliente cliente){

		if(!clienteRepository.existsById(clienteId)){
			return ResponseEntity.notFound().build();
		}

		cliente.setId(clienteId); //Força a atualização do ID
		cliente = clienteRepository.save(cliente);

		return ResponseEntity.ok(cliente); //Retorna o status 200
	}

	@DeleteMapping("/{clienteId}") //Exclui baseado no ID
	public ResponseEntity<Void> remover(@PathVariable Long clienteId){

		if(!clienteRepository.existsById(clienteId)){
			return ResponseEntity.notFound().build();
		}

		clienteRepository.deleteById(clienteId);

		return ResponseEntity.noContent().build();
	}

}

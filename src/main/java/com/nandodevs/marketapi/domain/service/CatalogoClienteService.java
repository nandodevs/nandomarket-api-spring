package com.nandodevs.marketapi.domain.service;

import com.nandodevs.marketapi.domain.exception.NegocioExpection;
import com.nandodevs.marketapi.domain.model.Cliente;
import com.nandodevs.marketapi.domain.repository.ClienteRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CatalogoClienteService { //Classe para definir as regras do negócio da aplicação
    
    private ClienteRepository clienteRepository;

    @Transactional
    public Cliente salvar(Cliente cliente){
        boolean emailEmUso = clienteRepository.findByEmail(cliente.getEmail())
            .stream()
            .anyMatch(clienteExistente -> !clienteExistente.equals(cliente)); 

        if(emailEmUso){
            throw new NegocioExpection("Já existe um cliente cadastrado com esse email");
        }
        return clienteRepository.save(cliente);  
    }

    @Transactional
    public void excluir(Long clienteId){
        clienteRepository.deleteById(clienteId);
    }

}

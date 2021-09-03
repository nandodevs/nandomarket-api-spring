package com.nandodevs.marketapi.domain.service;

import java.time.OffsetDateTime;

import com.nandodevs.marketapi.domain.model.Cliente;
import com.nandodevs.marketapi.domain.model.Entrega;
import com.nandodevs.marketapi.domain.model.StatusEntrega;
import com.nandodevs.marketapi.domain.repository.EntregaRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class SolicitacaoEntregaService {

    private CatalogoClienteService catalogoClienteService;
    private EntregaRepository entregaRepository;

    @Transactional
    public Entrega solicitar(Entrega entrega){

        Cliente cliente = catalogoClienteService.buscar(entrega.getCliente().getId());

        entrega.setCliente(cliente);    
        entrega.setStatus(StatusEntrega.PENDENTE);
        entrega.setDataPedido(OffsetDateTime.now());

        return entregaRepository.save(entrega);
    }
    
}

package com.nandodevs.marketapi.api.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.nandodevs.marketapi.domain.model.StatusEntrega;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EntregaModel {
    
    private Long id;
    private String nomeCliente;
    private DestinarioModel destinatario;
    private BigDecimal taxa;
    private StatusEntrega status;
    private OffsetDateTime dataPedido;
    private OffsetDateTime dataFinalizacao;


}

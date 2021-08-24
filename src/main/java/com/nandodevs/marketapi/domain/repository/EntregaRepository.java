package com.nandodevs.marketapi.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nandodevs.marketapi.domain.model.Entrega;



@Repository
public interface EntregaRepository extends JpaRepository<Entrega, Long>{

}


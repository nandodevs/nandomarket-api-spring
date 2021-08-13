package com.nandodevs.marketapi.domain.repository;

import com.nandodevs.marketapi.domain.model.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
    
}

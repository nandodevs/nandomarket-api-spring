package com.nandodevs.marketapi.domain.repository;

import java.util.List;
import java.util.Optional;

import com.nandodevs.marketapi.domain.model.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{

    //List<Cliente> findByNome(String nome);
   // List<Cliente> findByContaining(String nome);
    Optional<Cliente> findByEmail(String email);
}

package com.example.paging;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {


    Optional<Cliente> findByApellido(String  apellido);
}

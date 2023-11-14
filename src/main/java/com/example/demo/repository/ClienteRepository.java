package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    
}

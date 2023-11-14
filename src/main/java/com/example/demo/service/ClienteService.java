package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Cliente;
import com.example.demo.repository.ClienteRepository;


@Service
public class ClienteService {
    
    @Autowired
    private ClienteRepository repository;

    
    public Cliente save(Cliente cliente) {
        if(cliente == null){
            throw new RuntimeException("Cliente parameter is null!");
        }
            return repository.save(cliente);
        }


    public List<Cliente> findAll() {
        return repository.findAll();
    }

    public Cliente findById(Long id){
        return repository.findById(id)
        .orElseThrow(() ->   new IllegalArgumentException("Cliente with id: " + id + " does not exist"));
    }

    public Cliente update(Long id, Cliente cliente) {
        return repository.save(cliente);
    }



    public void delete(Long id){
        repository.deleteById(id);
    }
    
}
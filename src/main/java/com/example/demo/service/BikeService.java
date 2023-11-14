package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.entities.Bike;
import com.example.demo.repository.BikeRepository;

@Service
public class BikeService {
    
    @Autowired
    private BikeRepository repository;
    
    public Bike save(Bike bk) {
        if(bk == null){
            throw new RuntimeException("Bike parameter is null!");
        }
            return repository.save(bk);
        }


    public List<Bike> findAll() {
        return repository.findAll();
    }

    public Bike findById(Long id){
        return repository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Bike with id: " + id + " does not exist"));
    }

    public Bike update(Long id, Bike bike) {
        return repository.save(bike);
    }



    public void delete(Long id){
        repository.deleteById(id);
    }

}


package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Bike;
import com.example.demo.service.BikeService;



@RestController
@RequestMapping(value = "/bike")
public class BikeController {

    @Autowired
    private BikeService bikeService;

   @PostMapping("/salvar")
    public ResponseEntity<Bike> salvarEndereco(@RequestBody Bike bk) {
        Bike bike = bikeService.save(bk);

        if (bike != null) {
            return new ResponseEntity<>(bike, HttpStatus.CREATED);
        }

        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<List<Bike>> findAll() {
        var bk = bikeService.findAll();
        return new ResponseEntity<>(bk, HttpStatus.OK);
    }

     @PutMapping("/{id}")
    public ResponseEntity<Bike> atualizar(@PathVariable Long id, @RequestBody Bike bk) {
        bikeService.update(id, bk);
        return ResponseEntity.ok(bk);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluirBike(@PathVariable Long id) {
        Bike bk = bikeService.findById(id);

        if (bk != null) {
            bikeService.delete(id);
            return new ResponseEntity<>("Bike excluído com sucesso", HttpStatus.OK);
        }

        return new ResponseEntity<>("Bike não encontrado", HttpStatus.NOT_FOUND);
    }
    
}

package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entities.Cliente;
import com.example.demo.service.ClienteService;

@RestController
@RequestMapping(value="/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;
    

    @PostMapping("/salvar")
    public ResponseEntity<Cliente> save(@RequestBody Cliente cliente){
        clienteService.save(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<List<Cliente>> findAll() {
        var cliente = clienteService.findAll();
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    } 

   @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizarCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
        Cliente cl = clienteService.update(id, cliente);

        if (cl != null) {
            return ResponseEntity.ok().body(cl);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluirCliente(@PathVariable Long id) {
        Cliente cliente = clienteService.findById(id);

        if (cliente != null) {
            clienteService.delete(id);
            return new ResponseEntity<>("Cliente excluído com sucesso", HttpStatus.OK);
        }

        return new ResponseEntity<>("Cliente não encontrado", HttpStatus.NOT_FOUND);
    }
}
